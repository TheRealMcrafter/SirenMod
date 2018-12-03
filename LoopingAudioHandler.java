package TheRealMcrafter.SirenMod.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class LoopingAudioHandler {

	public LoopingAudioHandler(World world, int x, int y, int z, String soundName) {
		SirenLooper looper = new SirenLooper(world.getTileEntity(new BlockPos(x, y, z)), soundName);
		Minecraft.getMinecraft().getSoundHandler().playSound(looper);
	}
}
