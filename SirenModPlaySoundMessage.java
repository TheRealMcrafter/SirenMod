package TheRealMcrafter.SirenMod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SirenModPlaySoundMessage implements IMessage {

	private int x;
	private int y;
	private int z;
	private String soundName;

	public SirenModPlaySoundMessage() {
	}

	public SirenModPlaySoundMessage(int x, int y, int z, String soundName) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.soundName = soundName;
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.soundName = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		ByteBufUtils.writeUTF8String(buffer, soundName);
	}

	public static class Handler extends AbstractClientMessageHandler<SirenModPlaySoundMessage> {

		@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModPlaySoundMessage message, MessageContext ctx) {
			player.worldObj.playSoundEffect(message.x, message.y, message.z, "fire.ignite", 1.0F, 1.0F);
			return null;
		}
	}
}