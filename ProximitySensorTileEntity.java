package TheRealMcrafter.SirenMod.TileEntity;

import java.util.List;

import TheRealMcrafter.SirenMod.common.SirenMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ProximitySensorTileEntity extends TileEntity {

	public boolean isDetecting;

	public void updateEntity() {
		if (!worldObj.isRemote) {
			List l = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class,
					AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 10, this.zCoord - 10, this.xCoord + 10,
							this.yCoord + 10, this.zCoord + 10));
			if (l.isEmpty()) {
				this.isDetecting = false;
			} else {
				this.isDetecting = true;
			}

			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord + 1, this.zCoord, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord - 1, this.yCoord, this.zCoord, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord + 1, this.yCoord, this.zCoord, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord - 1, SirenMod.ProximitySensor);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord + 1, SirenMod.ProximitySensor);

		}
	}

	public void updateClientTileEntity() {
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("isDetecting", this.isDetecting);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.isDetecting = nbt.getBoolean("isDetecting");
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