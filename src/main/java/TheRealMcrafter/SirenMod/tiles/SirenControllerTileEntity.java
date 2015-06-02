package TheRealMcrafter.SirenMod.tiles;

import java.util.ArrayList;

import scala.reflect.internal.Trees.Throw;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SirenControllerTileEntity extends TileEntity {

	private byte renderValue = -1;
	public String state = "";
	public int ticksExisted;
	public ArrayList<Integer> sirensX = new ArrayList<Integer>();
	public ArrayList<Integer> sirensY = new ArrayList<Integer>();
	public ArrayList<Integer> sirensZ = new ArrayList<Integer>();
	public boolean isUpdated;
	
	
	public void updateEntity(){
		if (!worldObj.isRemote){
			if (!this.isUpdated){
				this.updateClientTileEntity();
				this.isUpdated = true;
			}
						
			for (int i = 0; i < sirensX.size(); i++){
				TileEntity tile = worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
				
				if (tile != null && tile instanceof SirenTileEntity){
				} else {
					sirensX.remove(i);
					sirensY.remove(i);
					sirensZ.remove(i);
				}
			}
			
			if (sirensX.isEmpty()){
				this.state = "";
				this.updateClientTileEntity();
			} else {
				if (this.state == ""){
					this.state = "waiting";
					this.updateClientTileEntity();
				} else if (this.state == "red"){
					if (this.ticksExisted > 60){
						this.state = "waiting";
						this.ticksExisted = 0;
						this.updateClientTileEntity();
					}
					this.ticksExisted++;
				} else if (this.state == "blue"){
					if (this.ticksExisted > 200){
						this.state = "waiting";
						this.ticksExisted = 0;
						this.updateClientTileEntity();
					}
					this.ticksExisted++;
				}
			}
		}
	}
	
	public void setRenderValue(byte renderValue){
		this.renderValue = renderValue;
	}
	
	public byte getRenderValue(){
		return this.renderValue;
	}
	
	public void buttonPress(String button){
		if (this.state == ""){
			return;
		}
		
		if (button == "red"){
			this.state = "red";
			
			for (int i = 0; i < sirensX.size(); i++){
				TileEntity tilee = worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
				if (tilee instanceof GeneralSirenTileEntity){
					GeneralSirenTileEntity tile = (GeneralSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStop(true);
				} else if (tilee instanceof NuclearSirenTileEntity){
					NuclearSirenTileEntity tile = (NuclearSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStop(true);
				} else if (tilee instanceof AmericanSignalT121TileEntity){
					AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStop(true);
				}
			}

			
		} else if (button == "blue"){
			this.state = "blue";
			
			for (int i = 0; i < sirensX.size(); i++){
				TileEntity tilee = worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
				if (tilee instanceof GeneralSirenTileEntity){
					GeneralSirenTileEntity tile = (GeneralSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.startSingleRotation();
				} else if (tilee instanceof NuclearSirenTileEntity){
					NuclearSirenTileEntity tile = (NuclearSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.startSingleRotation();
				} else if (tilee instanceof AmericanSignalT121TileEntity){
					AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.startSingleRotation();
				}
			}
			
		} else if (button == "green"){
			this.state = "green";
			
			for (int i = 0; i < sirensX.size(); i++){
				TileEntity tilee = worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
				if (tilee instanceof GeneralSirenTileEntity){
					GeneralSirenTileEntity tile = (GeneralSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStart(true);
				} else if (tilee instanceof NuclearSirenTileEntity){
					NuclearSirenTileEntity tile = (NuclearSirenTileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStart(true);
				} else if (tilee instanceof AmericanSignalT121TileEntity){
					AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) worldObj.getTileEntity(sirensX.get(i), sirensY.get(i), sirensZ.get(i));
					tile.setShouldStart(true);
				}
			}
		} else {
			System.err.println("Unexpected Exception in SirenControllerTileEntity(39) String 'button' is an unknown value: '" + button + "'");
		}
		
		this.updateClientTileEntity();
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
    	nbt.setByte("renderValue", this.renderValue);
    	nbt.setString("state", this.state);
    	nbt.setInteger("ticksExisted", this.ticksExisted);
    	
    	NBTTagCompound siren = new NBTTagCompound();

    	for (int i = 0; i < sirensX.size(); i++){
        	siren.setInteger("x" + i, sirensX.get(i));
        	siren.setInteger("y" + i, sirensY.get(i));
        	siren.setInteger("z" + i, sirensZ.get(i));
        	siren.setInteger("listSize", i);
    	}
    	

    	NBTTagList list = new NBTTagList();
    	
    	list.appendTag(siren);
    	
    	nbt.setTag("sirens", list);
	}

@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.renderValue = nbt.getByte("renderValue");
		this.state = nbt.getString("state");
		this.ticksExisted = nbt.getInteger("ticksExisted");
		
		NBTTagList list = (NBTTagList) nbt.getTag("sirens"); 
		NBTTagCompound siren = list.getCompoundTagAt(0);
		
		for (int i = 0; i < siren.getInteger("listSize") + 1; i ++){
			sirensX.add(siren.getInteger("x" + i));
			sirensY.add(siren.getInteger("y" + i));
			sirensZ.add(siren.getInteger("z" + i));
		}
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
