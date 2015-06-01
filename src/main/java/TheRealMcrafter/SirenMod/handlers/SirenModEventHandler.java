package TheRealMcrafter.SirenMod.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedEntityProperties;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedVillager;
import TheRealMcrafter.SirenMod.blocks.GeneralSiren;
import TheRealMcrafter.SirenMod.blocks.MotionDetector;
import TheRealMcrafter.SirenMod.blocks.Sprinkler;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.entity.ai.VillagerAIPanic;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SirenModEventHandler{
	
@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if (event.entity instanceof EntityVillager && ExtendedVillager.get((EntityVillager) event.entity) == null){
			ExtendedVillager.register((EntityVillager) event.entity);
		}
		
		if (event.entity instanceof EntityLivingBase && ExtendedEntityProperties.get((EntityLivingBase) event.entity) == null){
			ExtendedEntityProperties.register((EntityLivingBase) event.entity);
		}
	}

@SubscribeEvent
	public void breakEvent(BreakEvent event){
		if (event.block instanceof GeneralSiren){
			if (!event.getPlayer().capabilities.isCreativeMode){
				GeneralSirenTileEntity tile = (GeneralSirenTileEntity) event.world.getTileEntity(event.x, event.y, event.z);
				Entity item = new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(SirenMod.GeneralSirenItem, 1, ((GeneralSiren) event.block).getColorCode(event.world, event.x, event.y, event.z, tile)));
				event.world.spawnEntityInWorld(item);
			}
		}
	}

@SubscribeEvent
	public void blockPlaceEvent(PlaceEvent event){
		Block block = event.block;
		Block blockAbove = event.world.getBlock(event.x, event.y + 1, event.z);
		
		if (block instanceof Sprinkler){
			if (blockAbove == Blocks.air){
				event.setCanceled(true);
			} else if (!blockAbove.isSideSolid(event.world, event.x, event.y + 1, event.z, ForgeDirection.DOWN)){
				event.setCanceled(true);
			}
		}	
	}

@SubscribeEvent
	public void entityJoinWorldEvent(EntityJoinWorldEvent event){
		if (event.entity instanceof EntityVillager){
			((EntityCreature) event.entity).tasks.addTask(11, new VillagerAIPanic((EntityCreature) event.entity, 0.97D));
		}
	}


}