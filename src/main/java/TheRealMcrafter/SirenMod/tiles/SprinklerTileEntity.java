package TheRealMcrafter.SirenMod.tiles;

import java.util.Random;

import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.packet.SirenModSpawnParticleMessage;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class SprinklerTileEntity extends TileEntity {

	private boolean isRunning;
	public boolean shouldSpawn;
	public boolean shouldSend;
	
	
	public void updateEntity(){	
				
		if (worldObj.isRemote && shouldSpawn){
			this.spawnParticles();
		}
		
		if (!worldObj.isRemote){
			if (this.isRunning && this.shouldSend){
				SirenModPacketDispatcher.sendToAllAround(new SirenModSpawnParticleMessage(this.xCoord, this.yCoord, this.zCoord, ""), this.worldObj.provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, 300);
				this.shouldSend = false;
			}
		}
		
		if (!worldObj.isRemote){
			if (!this.isRunning){
				this.shouldSpawn = false;
				this.updateClientTileEntity();
			} else {
				
				Random rand = new Random();
				
				if (rand.nextBoolean()){
					if (rand.nextBoolean()){
						if (rand.nextBoolean()){
							for (int i = -4; i < 4; i++){
								for (int j = -4; j < 4; j++){
									for (int k = -4; k < 4; k++){
										Block block = worldObj.getBlock(this.xCoord + i, this.yCoord + j, this.zCoord + k);

										if (block == Blocks.fire){
											if (rand.nextBoolean()){
												if (rand.nextBoolean()){
													worldObj.setBlockToAir(this.xCoord + i, this.yCoord + j, this.zCoord + k);
												}
											}
										}
										
									}
								}	
							}
						}
					}
				}
				
								
				
				
			}
		}
	}
	
	public void spawnParticles(){
		if (worldObj.isRemote){

			Random rand = new Random();
			if (rand.nextBoolean()){
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, 0.0D, rand.nextGaussian() / 10);
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, 0.0D, rand.nextGaussian() / 10);
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, 0.0D, rand.nextGaussian() / 10);
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, 0.0D, rand.nextGaussian() / 10);
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, 0.0D, rand.nextGaussian() / 10);
				worldObj.spawnParticle("splash", this.xCoord + 0.6D, this.yCoord + 0.8, this.zCoord + 0.6D, rand.nextGaussian() / 10, -0.4D, rand.nextGaussian() / 10);
			}
		}
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
		if (this.isRunning){
			this.shouldSend = true;
		}
	}
	
	public boolean getIsRunning(){
		return this.isRunning;
	}
	
	
	
	 public void updateClientTileEntity(){
			worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
    	super.writeToNBT(nbt);  
    	nbt.setBoolean("isRunning", this.isRunning);
    	nbt.setBoolean("shouldSpawn", this.shouldSpawn);
    	nbt.setBoolean("shouldSend", this.shouldSend);
	}

@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.shouldSpawn = nbt.getBoolean("shouldSpawn");
		this.shouldSend = nbt.getBoolean("shouldSend");
		this.isRunning = nbt.getBoolean("isRunning");
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
