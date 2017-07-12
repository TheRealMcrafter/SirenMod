package TheRealMcrafter.SirenMod.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class LoopingAudioHandler {
	
	public LoopingAudioHandler(World world, int x, int y, int z, String soundName){
		if (world.getTileEntity(x, y, z), soundName != null) {
			SirenLooper looper = new SirenLooper(world.getTileEntity(x, y, z), soundName);
			Minecraft.getMinecraft().getSoundHandler().playSound(looper);
		}
	}
}
