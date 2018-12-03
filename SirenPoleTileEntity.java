package TheRealMcrafter.SirenMod.TileEntity;

import TheRealMcrafter.SirenMod.common.SirenMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class SirenPoleTileEntity extends TileEntity {

	private boolean isPowered;

	public void updateEntity() {
		if (worldObj.isRemote)
			return;

		if (!worldObj.isRemote) {

			if (this.isPowered) {
				TileEntity tile = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
				if (tile != null) {
					if (tile instanceof SirenPoleTileEntity) {
						((SirenPoleTileEntity) tile).setIsPowered(true);
						((SirenPoleTileEntity) tile).updateClientRender();
					} else if (tile instanceof GeneralSirenTileEntity) {
						((GeneralSirenTileEntity) tile).setShouldStart(true);
						((GeneralSirenTileEntity) tile).updateClientTileEntity();
					} else if (tile instanceof NuclearSirenTileEntity) {
						((NuclearSirenTileEntity) tile).setShouldStart(true);
						((NuclearSirenTileEntity) tile).updateClientTileEntity();
					} else if (tile instanceof AmericanSignalT121TileEntity) {
						((AmericanSignalT121TileEntity) tile).setShouldStart(true);
						((AmericanSignalT121TileEntity) tile).updateClientTileEntity();
					}
				}
			} else {
				TileEntity tile = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
				if (tile != null) {
					if (tile instanceof SirenPoleTileEntity) {
						((SirenPoleTileEntity) tile).setIsPowered(false);
						((SirenPoleTileEntity) tile).updateClientRender();
					} else if (tile instanceof GeneralSirenTileEntity) {
						if (!((GeneralSirenTileEntity) tile).getIsLinked()) {
							((GeneralSirenTileEntity) tile).setShouldStop(true);
							((GeneralSirenTileEntity) tile).updateClientTileEntity();
						}
					} else if (tile instanceof NuclearSirenTileEntity) {
						if (!((NuclearSirenTileEntity) tile).getIsLinked()) {
							((NuclearSirenTileEntity) tile).setShouldStop(true);
							((NuclearSirenTileEntity) tile).updateClientTileEntity();
						}
					} else if (tile instanceof AmericanSignalT121TileEntity) {
						if (!((AmericanSignalT121TileEntity) tile).getIsLinked()) {
							((AmericanSignalT121TileEntity) tile).setShouldStop(true);
							((AmericanSignalT121TileEntity) tile).updateClientTileEntity();
						}
					}

				}
			}

		}
	}

	public void setIsPowered(boolean value) {
		this.isPowered = value;
		this.updateClientRender();
	}

	public boolean getIsPowered() {
		this.updateClientRender();
		return this.isPowered;
	}

	public void updateClientRender() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("isPowered", this.isPowered);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.isPowered = nbt.getBoolean("isPowered");
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
