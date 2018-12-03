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

public class AmericanSignalT121TileEntity extends TileEntity implements ISirenTileEntity {

	private boolean isPlaying = false;
	private boolean shouldStart = false;
	private boolean shouldStop = false;
	private boolean isLinked;

	public void updateEntity() {
		if (worldObj.isRemote)
			return;

		if (!worldObj.isRemote) {

			if (this.isPlaying) {
				List l = this.worldObj.getEntitiesWithinAABB(EntityVillager.class,
						AxisAlignedBB.fromBounds(this.getPos().getX() - 20, this.getPos().getY() - 20,
								this.getPos().getZ() - 20, this.getPos().getX() + 20, this.getPos().getY() + 20,
								this.getPos().getZ() + 20));
				if (!l.isEmpty()) {
					for (int i = 0; i < l.size(); i++) {
						EntityVillager villager = (EntityVillager) l.get(i);
						ExtendedVillager props = ExtendedVillager.get(villager);
						props.setIsScared(true);

					}
				}
			}

			// */

			if (!isPlaying && shouldStart) {
				shouldStart = false;
				shouldStop = false;
				isPlaying = true;
				this.updateClientTileEntity();
				SirenModPacketDispatcher.sendToAllAround(
						new SirenModPlayLoopedSoundMessage(this.getPos().getX(), this.getPos().getY(),
								this.getPos().getZ(), "sirenT121"),
						this.worldObj.provider.getDimensionId(), this.getPos().getX(), this.getPos().getY(),
						this.getPos().getZ(), 50000000);
			}
		}
	}

	public boolean getIsLinked() {
		return this.isLinked;
	}

	public void setIsLinked(boolean isLinked) {
		this.isLinked = isLinked;
		this.updateClientTileEntity();
	}

	public void playSound() {
		worldObj.playSoundEffect(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), "sirenmod:sirenT121",
				8.0F, 1.0F);
	}

	public void updateClientTileEntity() {
		worldObj.markBlockForUpdate(pos);
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
		this.updateClientTileEntity();
	}

	public void setShouldStop(boolean shouldStop) {
		if (shouldStop) {
			if (isPlaying) {
				isPlaying = false;
				this.shouldStop = true;
				System.err.println("Should Stop");
			}
		} else {
			this.shouldStop = shouldStop;
		}

		this.updateClientTileEntity();
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("shouldStop", this.shouldStop);
		nbt.setBoolean("shouldStart", this.shouldStart);
		nbt.setBoolean("isPlaying", this.isPlaying);
		nbt.setBoolean("isLinked", this.isLinked);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.shouldStop = nbt.getBoolean("shouldStop");
		this.shouldStart = nbt.getBoolean("shouldStart");
		this.isPlaying = nbt.getBoolean("isPlaying");
		this.isLinked = nbt.getBoolean("isLinked");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tileTag = new NBTTagCompound();
		this.writeToNBT(tileTag);
		return new S35PacketUpdateTileEntity(pos, 1, tileTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		NBTTagCompound tag = packet.getNbtCompound();
		readFromNBT(packet.getNbtCompound());
	}
}
