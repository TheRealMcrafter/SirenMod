package TheRealMcrafter.SirenMod.ExtendedEntityProperties;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedEntityProperties implements IExtendedEntityProperties {

	protected EntityLivingBase entity;
	protected World world;
	public double oldX;
	public double oldY;
	public double oldZ;

	public ExtendedEntityProperties(EntityLivingBase entity) {
		this.entity = entity;
	}

	public static final void register(EntityLivingBase entity) {
		entity.registerExtendedProperties("ExtendedEntityProperties", new ExtendedEntityProperties(entity));
	}

	public static final ExtendedEntityProperties get(EntityLivingBase entity) {
		return (ExtendedEntityProperties) entity.getExtendedProperties("ExtendedEntityProperties");
	}

	@Override
	public void saveNBTData(NBTTagCompound parCompound) {
		NBTTagCompound compound = new NBTTagCompound();
		parCompound.setTag("ExtendedEntityProperties", compound);
		compound.setDouble("oldX", this.oldX);
		compound.setDouble("oldY", this.oldY);
		compound.setDouble("oldZ", this.oldZ);

	}

	@Override
	public void loadNBTData(NBTTagCompound parCompound) {
		NBTTagCompound compound = (NBTTagCompound) parCompound.getTag("ExtendedEntityProperties");
		this.oldX = (compound.getDouble("oldX"));
		this.oldY = (compound.getDouble("oldY"));
		this.oldZ = (compound.getDouble("oldZ"));

	}

	@Override
	public void init(Entity entity, World world) {
		this.entity = (EntityLivingBase) entity;
		this.world = world;
	}
}
