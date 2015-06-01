package TheRealMcrafter.SirenMod.tiles;

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

	public class NuclearSirenTileEntity extends SirenTileEntity{
		
		private float rotation = 0;
		public double timer;
		public boolean isOn;
		private boolean isPlaying = false;
		private boolean shouldStart = false; 
	    private boolean shouldStop = false;
	    private float increment;
	    private boolean toggle;
		private boolean wasPlaying;
		
					
		public void updateEntity(){			
			if (worldObj.isRemote) return;
			
			if (isOn){
				if (timer > 69){
					timer = 0;
					isOn = false;
					this.rotation = 0;
					this.updateClientRender();
				} else {
					timer++;
					increment = 0.089F;
					this.rotation = this.rotation + increment;
					this.updateClientRender();
				}
			}
			
			if (this.isPlaying){
				List l = this.worldObj.getEntitiesWithinAABB(EntityVillager.class, AxisAlignedBB.getBoundingBox(this.xCoord - 20, this.yCoord - 20, this.zCoord - 20, this.xCoord + 20, this.yCoord + 20, this.zCoord + 20));
				
				if (!l.isEmpty()){
					for (int i = 0; i < l.size(); i++){
						EntityVillager villager = (EntityVillager) l.get(i);
						ExtendedVillager props = ExtendedVillager.get(villager);
						props.setIsScared(true);
					}
				}
			}
			
			if (!isPlaying && shouldStart){
				shouldStart = false; 
		        shouldStop = false; 
		        isPlaying = true; 
		        this.updateClientRender();
				SirenModPacketDispatcher.sendToAllAround(new SirenModPlayLoopedSoundMessage(xCoord, yCoord, zCoord, "nuclearSiren"), this.worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50000000);
			}
				
			if (isPlaying){
				this.wasPlaying = true;
				this.rotation = this.rotation + 0.089F;
				this.updateClientRender();
			} else {
				if (wasPlaying){
					if (timer > 40 && rotation % 6.3 <= 3){
						timer = 0;
						wasPlaying = false;
						this.rotation = 0;
						this.updateClientRender();
					} else if (timer < 40) {
						timer ++;
						this.rotation = this.rotation + 0.089F;
						this.updateClientRender();
					} else {
						timer ++;
						this.rotation = this.rotation + 0.05F;
						this.updateClientRender();
					}
				}
			}
		}
		
		
		public float getRotation(){
			return this.rotation;
		}
		
		public void startSingleRotation(){
			worldObj.playSoundEffect(xCoord, yCoord, zCoord, "sirenmod:nuclearSiren", 8.0F, 1.0F);
			this.isOn = true;
		}
		
		public void updateClientRender(){
			worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
		}
		
		public boolean isShouldStop(){
	        return shouldStop;}

		public void setShouldStart(boolean shouldStart){
	    	if (shouldStart == true){
	    		this.shouldStop = false;
	    	} else {
	    		this.shouldStop = true;
	    	}
	        this.shouldStart = shouldStart;
	    }

	    public void setShouldStop(boolean shouldStop){
	    	if (shouldStop){
	    		if (isPlaying){
	    			isPlaying = false; 
	    			this.shouldStop = true;
	    		}
	    	} else {
	    		this.shouldStop = shouldStop;
	    	}
	    }

	    public boolean isPlaying(){
	        return isPlaying;
	    }
	    
	    
	    @Override
		public void writeToNBT(NBTTagCompound nbt){
	    	super.writeToNBT(nbt);  
	    	nbt.setFloat("rotation", this.rotation);
	    	nbt.setBoolean("shouldStop", this.shouldStop);
	    	nbt.setBoolean("shouldStart", this.shouldStart);
	    	nbt.setBoolean("toggle", this.toggle);
	    	nbt.setBoolean("isPlaying", this.isPlaying);
	    	nbt.setFloat("increment", this.increment);
	    	nbt.setBoolean("wasPlaying", this.wasPlaying);
		}

	@Override
		public void readFromNBT(NBTTagCompound nbt){
			super.readFromNBT(nbt);
			this.rotation = nbt.getFloat("rotation");
			this.shouldStop = nbt.getBoolean("shouldStop");
			this.shouldStart = nbt.getBoolean("shouldStart");
			this.toggle = nbt.getBoolean("toggle");
			this.isPlaying = nbt.getBoolean("isPlaying");
			this.increment = nbt.getFloat("increment");
			this.wasPlaying = nbt.getBoolean("wasPlaying");
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