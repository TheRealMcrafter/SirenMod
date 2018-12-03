package TheRealMcrafter.SirenMod.TileEntity;

import java.util.List;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedVillager;
import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.packet.SirenModPlayLoopedSoundMessage;

public class GeneralSirenTileEntity extends TileEntity implements ISirenTileEntity {
	private String color = "lightGray";
	private float rotation;
	private double timer;
	private boolean isPlaying = false;
	private boolean shouldStart = false;
	private boolean shouldStop = false;
	private boolean isOn;
	private float increment;
	private boolean wasPlaying;
	private boolean isLinked;

	public void updateEntity() {

		if (worldObj.isRemote)
			return;

		if (this.isPlaying) {
			List l = this.worldObj.getEntitiesWithinAABB(EntityVillager.class,
					AxisAlignedBB.getBoundingBox(this.xCoord - 20, this.yCoord - 20, this.zCoord - 20, this.xCoord + 20,
							this.yCoord + 20, this.zCoord + 20));

			if (!l.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					EntityVillager villager = (EntityVillager) l.get(i);
					ExtendedVillager props = ExtendedVillager.get(villager);
					props.setIsScared(true);
				}
			}
		}

		if (isOn) {
			if (timer > 170) {
				timer = 0;
				isOn = false;
				this.rotation = 0;
				this.updateClientTileEntity();
			} else {
				timer++;
				if (timer > 160) {
					increment = 0.1F;
				} else if (timer > 120) {
					increment = 0.3F;
				} else if (timer > 80) {
					increment = 0.5F;
				} else if (timer > 50) {
					increment = 0.3F;
				} else if (timer > 20) {
					increment = 0.2F;
				} else {
					increment = 0.1F;
				}

				this.rotation = this.rotation + increment;
				this.updateClientTileEntity();
			}
		}

		if (this.isPlaying) {
			List l = this.worldObj.getEntitiesWithinAABB(EntityVillager.class,
					AxisAlignedBB.getBoundingBox(this.xCoord - 20, this.yCoord - 20, this.zCoord - 20, this.xCoord + 20,
							this.yCoord + 20, this.zCoord + 20));

			if (!l.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					EntityVillager villager = (EntityVillager) l.get(i);
					ExtendedVillager props = ExtendedVillager.get(villager);
					props.setIsScared(true);
				}
			}
		}

		if (!isPlaying && shouldStart) {
			shouldStart = false;
			shouldStop = false;
			isPlaying = true;
			this.updateClientTileEntity();
			SirenModPacketDispatcher.sendToAllAround(
					new SirenModPlayLoopedSoundMessage(xCoord, yCoord, zCoord, "generalSirenFull"),
					this.worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50000000);
		}

		if (isPlaying) {

			this.wasPlaying = true;
			this.rotation = this.rotation + 0.5F;
			this.updateClientTileEntity();
		} else {
			if (wasPlaying) {
				if (timer > 58 && rotation % 6.3 <= 1) {
					timer = 0;
					wasPlaying = false;
					this.rotation = 0;
					this.updateClientTileEntity();
				} else if (timer > 30) {
					timer++;
					this.rotation = this.rotation + 0.1F;
					this.updateClientTileEntity();
				} else if (timer > 20) {
					timer++;
					this.rotation = this.rotation + 0.2F;
					this.updateClientTileEntity();
				} else {
					timer++;
					this.rotation = this.rotation + 0.4F;
					this.updateClientTileEntity();
				}
			}
		}

	}

	public void startSingleRotation() {
		worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "sirenmod:generalSirenFull", 1.0F, 1.0F);
		this.isOn = true;
	}

	public boolean isShouldStop() {
		return shouldStop;
	}

	public void setShouldStart(boolean shouldStart) {
		if (shouldStart == true) {
			this.shouldStop = false;
		} else {
			this.shouldStop = true;
		}
		this.shouldStart = shouldStart;
	}

	public void setShouldStop(boolean shouldStop) {
		if (shouldStop) {
			if (isPlaying) {
				isPlaying = false;
				this.shouldStop = true;
			}
		} else {
			this.shouldStop = shouldStop;
		}
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void updateClientTileEntity() {
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public float getRotation() {
		return this.rotation;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("color", this.color);
		nbt.setFloat("rotation", this.rotation);
		nbt.setBoolean("shouldStop", this.shouldStop);
		nbt.setBoolean("shouldStart", this.shouldStart);
		nbt.setBoolean("isPlaying", this.isPlaying);
		nbt.setBoolean("wasPlaying", this.wasPlaying);
		nbt.setBoolean("isLinked", this.isLinked);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.color = nbt.getString("color");
		this.rotation = nbt.getFloat("rotation");
		this.shouldStop = nbt.getBoolean("shouldStop");
		this.shouldStart = nbt.getBoolean("shouldStart");
		this.isPlaying = nbt.getBoolean("isPlaying");
		this.wasPlaying = nbt.getBoolean("wasPlaying");
		this.isLinked = nbt.getBoolean("isLinked");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tileTag = new NBTTagCompound();
		this.writeToNBT(tileTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tileTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		NBTTagCompound tag = packet.func_148857_g();
		readFromNBT(packet.func_148857_g());
	}

	public boolean getIsLinked() {
		return this.isLinked;
	}

	public void setIsLinked(boolean isLinked) {
		this.isLinked = isLinked;
		this.updateClientTileEntity();
	}

	public void playSound() {
		worldObj.playSoundEffect(xCoord, yCoord, zCoord, "sirenmod:sirenT121", 8.0F, 1.0F);
	}
}
