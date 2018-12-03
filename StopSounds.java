package TheRealMcrafter.SirenMod.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;

public class StopSounds {

	public StopSounds() {
		Minecraft.getMinecraft().getSoundHandler().stopSounds();
	}
}
