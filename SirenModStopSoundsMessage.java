package TheRealMcrafter.SirenMod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import TheRealMcrafter.SirenMod.client.audio.StopSounds;

public class SirenModStopSoundsMessage implements IMessage {

	public SirenModStopSoundsMessage() {
	}

	@Override
	public void fromBytes(ByteBuf buffer) {

	}

	@Override
	public void toBytes(ByteBuf buffer) {

	}

	public static class Handler extends AbstractClientMessageHandler<SirenModStopSoundsMessage> {

		@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModStopSoundsMessage message,
				MessageContext ctx) {
			new StopSounds();
			return null;
		}
	}
}