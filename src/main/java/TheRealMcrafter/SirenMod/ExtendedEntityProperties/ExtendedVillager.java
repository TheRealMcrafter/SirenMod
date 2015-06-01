package TheRealMcrafter.SirenMod.ExtendedEntityProperties;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedVillager implements IExtendedEntityProperties{

	protected EntityVillager villager;
	protected World world;
	private boolean isScared;
	
	
	
	public ExtendedVillager(EntityVillager villager){
		this.villager = villager;
	}

	public static final void register(EntityVillager villager){
		villager.registerExtendedProperties("ExtendedVillager", new ExtendedVillager(villager));
	}

	public static final ExtendedVillager get(EntityVillager villager){
		return (ExtendedVillager) villager.getExtendedProperties("ExtendedVillager");
	}
	
@Override
    public void saveNBTData(NBTTagCompound parCompound){
        NBTTagCompound compound = new NBTTagCompound();
        parCompound.setTag("ExtendedVillagerProperties", compound);
        compound.setBoolean("isScared", this.isScared);
    }

    @Override
    public void loadNBTData(NBTTagCompound parCompound){
        NBTTagCompound compound = (NBTTagCompound) 
        parCompound.getTag("ExtendedVillagerProperties");
        this.isScared = (compound.getBoolean("isScared"));
   }

   @Override
   public void init(Entity entity, World world){
        villager = (EntityVillager)entity;
        this.world = world;
    }

   public void setIsScared(boolean isScared) {
	   this.isScared = isScared;
   }
   
   public boolean getIsScared(){
	   return this.isScared;
   }
}

