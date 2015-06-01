package TheRealMcrafter.SirenMod.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.client.render.AmericanSignalT121Renderer;
import TheRealMcrafter.SirenMod.client.render.BurglarSirenRenderer;
import TheRealMcrafter.SirenMod.client.render.FireAlarmRenderer;
import TheRealMcrafter.SirenMod.client.render.GeneralSirenRenderer;
import TheRealMcrafter.SirenMod.client.render.MotionDetectorRenderer;
import TheRealMcrafter.SirenMod.client.render.NuclearSirenRenderer;
import TheRealMcrafter.SirenMod.client.render.ProximitySensorRenderer;
import TheRealMcrafter.SirenMod.client.render.SirenControllerRenderer;
import TheRealMcrafter.SirenMod.client.render.SirenPoleRenderer;
import TheRealMcrafter.SirenMod.client.render.SprinklerRenderer;
import TheRealMcrafter.SirenMod.common.SirenModCommonProxy;
import TheRealMcrafter.SirenMod.tiles.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.MotionDetectorTileEntity;
import TheRealMcrafter.SirenMod.tiles.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.ProximitySensorTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenControllerTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenPoleTileEntity;
import TheRealMcrafter.SirenMod.tiles.SprinklerTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModClientProxy extends SirenModCommonProxy {

	public void registerRenderInformation(){
		ClientRegistry.bindTileEntitySpecialRenderer(GeneralSirenTileEntity.class, new GeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(NuclearSirenTileEntity.class, new NuclearSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BurglarSirenTileEntity.class, new BurglarSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FireAlarmTileEntity.class, new FireAlarmRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AmericanSignalT121TileEntity.class, new AmericanSignalT121Renderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SirenPoleTileEntity.class, new SirenPoleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ProximitySensorTileEntity.class, new ProximitySensorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SirenControllerTileEntity.class, new SirenControllerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(MotionDetectorTileEntity.class, new MotionDetectorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SprinklerTileEntity.class, new SprinklerRenderer());

	}
	

    public void playSound(World world, int x, int y, int z, String soundName) {
    	Minecraft.getMinecraft().theWorld.playSound(x, y, z, soundName, 3.0F, 1.0F, true);
    }
    
@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
	
}
