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

public class BurglarSirenTileEntity extends TileEntity {

	private boolean isPlaying = false;
	private boolean shouldStart = false;
	private boolean shouldStop = false;

	public void updateEntity() {

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
			SirenModPacketDispatcher.sendToAllAround(
					new SirenModPlayLoopedSoundMessage(xCoord, yCoord, zCoord, "burglarAlarm"),
					this.worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50000000);
		}

	}

	public void updateClientRender() {
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
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

	public void playSound() {
		worldObj.playSoundEffect(xCoord, yCoord, zCoord, "sirenmod:burglarAlarm", 5.0F, 1.0F);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("shouldStop", this.shouldStop);
		nbt.setBoolean("shouldStart", this.shouldStart);
		nbt.setBoolean("isPlaying", this.isPlaying);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.shouldStop = nbt.getBoolean("shouldStop");
		this.shouldStart = nbt.getBoolean("shouldStart");
		this.isPlaying = nbt.getBoolean("isPlaying");
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

}
