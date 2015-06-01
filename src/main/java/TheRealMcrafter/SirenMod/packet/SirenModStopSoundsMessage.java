package TheRealMcrafter.SirenMod.packet;

import TheRealMcrafter.SirenMod.client.audio.LoopingAudioHandler;
import TheRealMcrafter.SirenMod.client.audio.SirenLooper;
import TheRealMcrafter.SirenMod.client.audio.StopSounds;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModStopSoundsMessage implements IMessage{


	public SirenModStopSoundsMessage() {}

@Override
	public void fromBytes(ByteBuf buffer) {
		
	}

@Override
	public void toBytes(ByteBuf buffer) {
		
	}

	public static class Handler extends AbstractClientMessageHandler<SirenModStopSoundsMessage> {

@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModStopSoundsMessage message, MessageContext ctx) {
			new StopSounds();
			return null;
		}
	}
}