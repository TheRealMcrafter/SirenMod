package TheRealMcrafter.SirenMod.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedEntityProperties;
import TheRealMcrafter.SirenMod.ExtendedEntityProperties.ExtendedVillager;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.blocks.FireExtinguisher;
import TheRealMcrafter.SirenMod.blocks.GeneralSiren;
import TheRealMcrafter.SirenMod.blocks.Sprinkler;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.entity.ai.VillagerAIPanic;

public class SirenModEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		// if (event.entity instanceof EntityVillager &&
		// ExtendedVillager.get((EntityVillager) event.entity) == null){
		// ExtendedVillager.register((EntityVillager) event.entity);
		// }

		// if (event.entity instanceof EntityLivingBase &&
		// ExtendedEntityProperties.get((EntityLivingBase) event.entity) ==
		// null){
		// ExtendedEntityProperties.register((EntityLivingBase) event.entity);
		// }
	}

	@SubscribeEvent
	public void breakEvent(BreakEvent event) {
		if (event.state.getBlock() instanceof GeneralSiren) {
			if (!event.getPlayer().capabilities.isCreativeMode) {
				GeneralSirenTileEntity tile = (GeneralSirenTileEntity) event.world.getTileEntity(event.pos);
				Entity item = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(),
						new ItemStack(SirenMod.GeneralSirenItem, 1,
								((GeneralSiren) event.world.getBlockState(event.pos).getBlock()).getColorCode(
										event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), tile)));
				event.world.spawnEntityInWorld(item);
			}
		} else if (event.state.getBlock() instanceof FireExtinguisher) {
			if (!event.getPlayer().capabilities.isCreativeMode) {
				Entity item = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(),
						new ItemStack(SirenMod.FireExtinguisherItem, 1));
				event.world.spawnEntityInWorld(item);
			}
		}
	}

	@SubscribeEvent
	public void blockPlaceEvent(PlaceEvent event) {
		Block block = event.state.getBlock();
		Block blockAbove = event.world.getBlockState(event.pos.up()).getBlock();

		if (block instanceof Sprinkler) {
			if (blockAbove == Blocks.air) {
				event.setCanceled(true);
			} else if (!blockAbove.isSideSolid(event.world, event.pos, EnumFacing.DOWN)) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void entityJoinWorldEvent(EntityJoinWorldEvent event) {
		// if (event.entity instanceof EntityVillager){
		// ((EntityCreature) event.entity).tasks.addTask(11, new
		// VillagerAIPanic((EntityCreature) event.entity, 0.97D));
		// }

		/*
		 * if (event.entity instanceof EntityPlayer){ if
		 * (!SirenMod.haveWarnedVersionOutOfDate &&
		 * event.entity.worldObj.isRemote &&
		 * !SirenMod.versionChecker.isLatestVersion()){ ClickEvent
		 * versionCheckChatClickEvent = new
		 * ClickEvent(ClickEvent.Action.OPEN_URL,
		 * "http://sirenmod.wikia.com/wiki/Category:Downloads"); ChatStyle
		 * clickableChatStyle = new
		 * ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
		 * ChatComponentText versionWarningChatComponent = new
		 * ChatComponentText("There is a new version of SirenMod available! Click here to go to the downloads page."
		 * ); versionWarningChatComponent.setChatStyle(clickableChatStyle);
		 * ((EntityPlayer)
		 * event.entity).addChatMessage(versionWarningChatComponent);
		 * SirenMod.haveWarnedVersionOutOfDate = true; } }
		 * 
		 */

	}
}