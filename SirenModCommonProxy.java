package TheRealMcrafter.SirenMod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.oredict.OreDictionary;
import TheRealMcrafter.SirenMod.TileEntity.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.TileEntity.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.FireExtinguisherTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.MotionDetectorTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.ProximitySensorTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenControllerTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenPoleTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SprinklerTileEntity;
import TheRealMcrafter.SirenMod.blocks.AmericanSignalT121;
import TheRealMcrafter.SirenMod.blocks.BurglarSiren;
import TheRealMcrafter.SirenMod.blocks.FireAlarm;
import TheRealMcrafter.SirenMod.blocks.FireExtinguisher;
import TheRealMcrafter.SirenMod.blocks.GeneralSiren;
import TheRealMcrafter.SirenMod.blocks.MotionDetector;
import TheRealMcrafter.SirenMod.blocks.NuclearSiren;
import TheRealMcrafter.SirenMod.blocks.ProximitySensor;
import TheRealMcrafter.SirenMod.blocks.SiliconOre;
import TheRealMcrafter.SirenMod.blocks.SirenController;
import TheRealMcrafter.SirenMod.blocks.SirenPole;
import TheRealMcrafter.SirenMod.blocks.Sprinkler;
import TheRealMcrafter.SirenMod.items.FireExtinguisherItem;
import TheRealMcrafter.SirenMod.items.GeneralSirenItem;
import TheRealMcrafter.SirenMod.items.IntegratedCircuit;
import TheRealMcrafter.SirenMod.items.Screwdriver;
import TheRealMcrafter.SirenMod.items.SiliconShard;
import TheRealMcrafter.SirenMod.items.Speaker;
import TheRealMcrafter.SirenMod.items.Wrench;

public class SirenModCommonProxy implements IGuiHandler {

	public void registerRenderInformation() {

	}

	/**
	 * Returns a side-appropriate EntityPlayer for use during message handling
	 */
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { // For
																										// GUI's
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { // For
																										// GUI's
		return null;
	}

	public void registerTiles() {
		GameRegistry.registerTileEntity(NuclearSirenTileEntity.class, "NuclearSirenTileEntity");
		GameRegistry.registerTileEntity(GeneralSirenTileEntity.class, "GeneralSirenTileEntity");
		GameRegistry.registerTileEntity(BurglarSirenTileEntity.class, "BurglarSirenTileEntity");
		GameRegistry.registerTileEntity(FireAlarmTileEntity.class, "FireAlarmTileEntity");
		GameRegistry.registerTileEntity(AmericanSignalT121TileEntity.class, "AmericanSignalT121TileEntity");
		GameRegistry.registerTileEntity(SirenPoleTileEntity.class, "SirenPoleTileEntity");
		GameRegistry.registerTileEntity(SirenControllerTileEntity.class, "SirenControllerTileEntity");
		GameRegistry.registerTileEntity(ProximitySensorTileEntity.class, "ProximitySensorTileEntity");
		GameRegistry.registerTileEntity(MotionDetectorTileEntity.class, "MotionDetectorTileEntity");
		GameRegistry.registerTileEntity(SprinklerTileEntity.class, "SprinklerTileEntity");
		GameRegistry.registerTileEntity(FireExtinguisherTileEntity.class, "FireExtinguisherTileEntity");

	}

	public void registerBlocks() {
		SirenMod.GeneralSiren = new GeneralSiren("General Siren").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.GeneralSiren, "General Siren");
		LanguageRegistry.addName(SirenMod.GeneralSiren, "General Siren");

		SirenMod.NuclearSiren = new NuclearSiren("Nuclear Siren").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.NuclearSiren, "Nuclear Siren");
		LanguageRegistry.addName(SirenMod.NuclearSiren, "Nuclear Siren");

		SirenMod.AmericanSignalT121 = new AmericanSignalT121("AmericanSignalT121").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.AmericanSignalT121, "AmericanSignalT121");
		LanguageRegistry.addName(SirenMod.AmericanSignalT121, "American Signal T-121");

		SirenMod.SiliconOre = new SiliconOre("Silicon Ore").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.SiliconOre, "Silicon Ore");
		LanguageRegistry.addName(SirenMod.SiliconOre, "Silicon Ore");

		SirenMod.BurglarSiren = new BurglarSiren("Burglar Alarm").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.BurglarSiren, "Burglar Alarm");
		LanguageRegistry.addName(SirenMod.BurglarSiren, "Burglar Alarm");

		SirenMod.FireAlarm = new FireAlarm("Fire Alarm").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.FireAlarm, "Fire Alarm");
		LanguageRegistry.addName(SirenMod.FireAlarm, "Fire Alarm");

		SirenMod.SirenPole = new SirenPole("Siren Pole").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.SirenPole, "Siren Pole");
		LanguageRegistry.addName(SirenMod.SirenPole, "Siren Pole");

		SirenMod.SirenController = new SirenController("Siren Controller").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.SirenController, "Siren Controller");
		LanguageRegistry.addName(SirenMod.SirenController, "Siren Controller");

		SirenMod.ProximitySensor = new ProximitySensor("Proximity Sensor").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.ProximitySensor, "Proximity Sensor");
		LanguageRegistry.addName(SirenMod.ProximitySensor, "Proximity Sensor");

		SirenMod.MotionDetector = new MotionDetector("Motion Detector").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.MotionDetector, "Motion Detector");
		LanguageRegistry.addName(SirenMod.MotionDetector, "Motion Detector");

		SirenMod.Sprinkler = new Sprinkler("Sprinkler").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.Sprinkler, "Sprinkler");
		LanguageRegistry.addName(SirenMod.Sprinkler, "Sprinkler");

		SirenMod.FireExtinguisher = new FireExtinguisher("FireExtinguisher").setHardness(0.3F);
		GameRegistry.registerBlock(SirenMod.FireExtinguisher, "Fire Extinguisher");
		LanguageRegistry.addName(SirenMod.FireExtinguisher, "Fire Extinguisher");

	}

	public void registerItems() {
		SirenMod.IntegratedCircuit = new IntegratedCircuit("Integrated Circuit");
		GameRegistry.registerItem(SirenMod.IntegratedCircuit, "Integrated Circuit");
		LanguageRegistry.addName(SirenMod.IntegratedCircuit, "Integrated Circuit");

		// SirenMod.Speaker = new Speaker("Speaker");
		// GameRegistry.registerItem(SirenMod.Speaker, "Speaker");
		// LanguageRegistry.addName(SirenMod.Speaker, "Speaker");

		// SirenMod.SiliconShard = new SiliconShard("Silicon Shard");
		// GameRegistry.registerItem(SirenMod.SiliconShard, "Silicon Shard");
		// LanguageRegistry.addName(SirenMod.SiliconShard, "Silicon Shard");

		// SirenMod.GeneralSirenItem = new GeneralSirenItem("General Siren
		// Item");
		// GameRegistry.registerItem(SirenMod.GeneralSirenItem, "General Siren
		// Item");
		// LanguageRegistry.addName(SirenMod.GeneralSirenItem, "General Siren");

		// SirenMod.Wrench = new Wrench("Wrench");
		// GameRegistry.registerItem(SirenMod.Wrench, "Wrench");
		// LanguageRegistry.addName(SirenMod.Wrench, "Wrench");

		// SirenMod.Screwdriver = new Screwdriver("Screwdriver");
		// GameRegistry.registerItem(SirenMod.Screwdriver, "Screwdriver");
		// LanguageRegistry.addName(SirenMod.Screwdriver, "Screwdriver");

		// SirenMod.FireExtinguisherItem = new
		// FireExtinguisherItem("FireExtinguisherItem");
		// GameRegistry.registerItem(SirenMod.FireExtinguisherItem,
		// "FireExtinguisherItem");
		// LanguageRegistry.addName(SirenMod.FireExtinguisherItem, "Fire
		// Extinguisher");

	}

	public void registerOres() {
		OreDictionary.registerOre("SiliconOre", SirenMod.SiliconOre);
	}

	public void playSound(World world, int x, int y, int z, String soundName) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}