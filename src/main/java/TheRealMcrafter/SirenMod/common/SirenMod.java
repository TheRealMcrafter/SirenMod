package TheRealMcrafter.SirenMod.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import TheRealMcrafter.SirenMod.CreativeTabs.SirenModCreativeTab;
import TheRealMcrafter.SirenMod.WorldGeneration.SirenModWorldGen;
import TheRealMcrafter.SirenMod.handlers.SirenModEventHandler;
import TheRealMcrafter.SirenMod.items.IntegratedCircuit;
import TheRealMcrafter.SirenMod.items.SiliconShard;
import TheRealMcrafter.SirenMod.items.Speaker;
import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.NuclearSirenTileEntity;

@Mod(modid = SirenMod.modID, version = SirenMod.VERSION, name = "TheRealMcrafter's SirenMod")

public class SirenMod {
	@Instance(value="SirenMod")
	public static SirenMod instance;
	public static final String modID = "SirenMod";
	public static final String VERSION = "4.0.2";
	public static CreativeTabs SirenModCreativeTab = new SirenModCreativeTab(CreativeTabs.getNextID(), "TheRealMcrafter's Siren Mod");
	@SidedProxy(clientSide = "TheRealMcrafter.SirenMod.client.SirenModClientProxy", serverSide = "TheRealMcrafter.SirenMod.common.SirenModCommonProxy") //Tells Forge the location of your proxies
	public static SirenModCommonProxy proxy;
	public static VersionChecker versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;
	
//Config options
	public static boolean generateSiliconOre;
	public static boolean render3DItemsInHand;
	
//Blocks
	public static Block SiliconOre;
	public static Block NuclearSiren;
	public static Block GeneralSiren;
	public static Block BurglarSiren;
	public static Block FireAlarm;
	public static Block AmericanSignalT121;
	public static Block SirenPole;
	public static Block SirenController;
	public static Block ProximitySensor;
	public static Block MotionDetector;
	public static Block Sprinkler;
	public static Block FireExtinguisher;

//Items
	public static Item SiliconShard;
	public static Item IntegratedCircuit;
	public static Item Speaker;
	public static Item GeneralSirenItem;
	public static Item Wrench;
	public static Item Screwdriver;
	public static Item FireExtinguisherItem;

	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		this.generateSiliconOre = config.get(config.CATEGORY_GENERAL, "Generate Silicon Ore?", true).getBoolean(true);	
		config.save();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new SirenModEventHandler());
		GameRegistry.registerWorldGenerator(new SirenModWorldGen(), 0);

		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerOres();
		proxy.registerTiles();
		proxy.registerRenderInformation();
		
		
		
		
		//Recipes
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.Wrench), 				" I ", 
															   				" II",
															   				"I  ",
		        'I', Items.IRON_INGOT);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.IntegratedCircuit), 	"RSR",
																		  	"SES", 
																		  	"RSR",
		        'R', Items.REDSTONE, 'S', SirenMod.SiliconShard, 'E', Items.ENDER_PEARL);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.Speaker), 			"III", 
																			"ICI", 
																			"III",
		        'I', Items.IRON_INGOT, 'C', SirenMod.IntegratedCircuit);
		
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.GeneralSirenItem),	"SIS", 
																			"PPP",
				'I', Items.IRON_INGOT, 'S', SirenMod.Speaker, 'P', Blocks.STONE_SLAB);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.NuclearSiren),		"SI ", 
																			" I ",
																			"PPP",
				'I', Items.IRON_INGOT, 'S', SirenMod.Speaker, 'P', Blocks.STONE_SLAB);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.AmericanSignalT121),	"SIS", 
																			"SIS",
																			"PPP",
				'I', Items.IRON_INGOT, 'S', SirenMod.Speaker, 'P', Blocks.STONE_SLAB);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.BurglarSiren),		"III", 
																			"ISI",
																			"III",
				'I', Items.IRON_INGOT, 'S', SirenMod.Speaker);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.FireAlarm),			"ISI", 
																			"IGI",
																			"III",
				'I', Items.IRON_INGOT, 'S', SirenMod.Speaker, 'G', Blocks.GLASS);
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.SirenPole),			"I", 
																			"I",
																			"I",
				'I', Items.IRON_INGOT);
			
		SirenModPacketDispatcher.registerPackets();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}


	public static void registerItem(Item item, String name, String unlocalizedName) {
		GameRegistry.registerItem(item, SirenMod.modID + unlocalizedName);
    LanguageRegistry.addName(item, name);}

	public static void registerBlock(Block block, String name, String unlocalizedName) {
		GameRegistry.registerBlock(block, SirenMod.modID + unlocalizedName);
	LanguageRegistry.addName(block, name);}

}