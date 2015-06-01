package TheRealMcrafter.SirenMod.tiles;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedEntityProperties;
import TheRealMcrafter.SirenMod.common.SirenMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MotionDetectorTileEntity extends TileEntity {

	public boolean isDetecting;
	private List list;
	
	public void updateEntity(){		
		if (!worldObj.isRemote){			
			switch (this.getBlockMetadata()){
				case 5:
					list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord - 3, this.zCoord - 10, this.xCoord + 10, this.yCoord + 3, this.zCoord + 10));
					break;
				case 2:
					list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 3, this.zCoord - 10, this.xCoord + 10, this.yCoord + 3, this.zCoord));					
					break;
				case 4:
					list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 3, this.zCoord - 10, this.xCoord, this.yCoord + 3, this.zCoord + 10));					
					break;
				case 3:
					list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 3, this.zCoord, this.xCoord + 10, this.yCoord + 3, this.zCoord + 10));					
					break;
				default:
					list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord - 10, this.yCoord - 10, this.zCoord - 10, this.xCoord + 10, this.yCoord + 10, this.zCoord + 10));					
					break;
			}
			
			if (list.isEmpty()){
				this.isDetecting = false;
			} else {
				for (int i = 0; i < list.size(); i ++){
					EntityLivingBase entity = (EntityLivingBase) list.get(i);
					ExtendedEntityProperties props = ExtendedEntityProperties.get(entity);
					
					
					if (this.canEntityBeSeen(entity)){
						if (props.oldX - entity.posX > 0.07D || props.oldX - entity.posX < -0.07D || props.oldY - entity.posY > 0.02D || props.oldY - entity.posY < -0.02D || props.oldZ - entity.posZ > 0.07D || props.oldZ - entity.posZ < -0.07D){
							this.isDetecting = true;
						} else {
							this.isDetecting = false;
						}
					} else {
						this.isDetecting = false;
					}
					
					
					props.oldX = entity.posX;
					props.oldY = entity.posY;
					props.oldZ = entity.posZ;			
				}
			}
			
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord + 1, this.zCoord, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord - 1, this.yCoord, this.zCoord, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord + 1, this.yCoord, this.zCoord, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord - 1, SirenMod.MotionDetector);
			worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord + 1, SirenMod.MotionDetector);
			
			this.updateClientTileEntity();

		}
	}
	
	public boolean canEntityBeSeen(Entity entity){
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D), Vec3.createVectorHelper(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ)) == null;
	}
	
	
	
	public void updateClientTileEntity(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
	
	
@Override
@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox(){
		return INFINITE_EXTENT_AABB;
	}
	
@Override
	public void writeToNBT(NBTTagCompound nbt){
    	super.writeToNBT(nbt);  
    	nbt.setBoolean("isDetecting", this.isDetecting);
	}

@Override
	public void readFromNBT(NBTTagCompound nbt){
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
