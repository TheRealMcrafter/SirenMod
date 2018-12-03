package TheRealMcrafter.SirenMod.entity.ai;

import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedVillager;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.Vec3;

public class VillagerAIPanic extends EntityAIBase {

	private EntityCreature theEntityCreature;
	private double speed;
	private double randPosX;
	private double randPosY;
	private double randPosZ;

	public VillagerAIPanic(EntityCreature creature, double speed) {
		this.theEntityCreature = creature;
		this.speed = speed;
		this.setMutexBits(1);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		if (ExtendedVillager.get((EntityVillager) theEntityCreature).getIsScared()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 10, 4);

		this.randPosX = vec3.xCoord;
		this.randPosY = vec3.yCoord;
		this.randPosZ = vec3.zCoord;

		this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
		ExtendedVillager.get((EntityVillager) theEntityCreature).setIsScared(false);

	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting() {
		if (ExtendedVillager.get((EntityVillager) theEntityCreature).getIsScared()) {
			this.startExecuting();
		}
		return ExtendedVillager.get((EntityVillager) theEntityCreature).getIsScared();
	}
}
