package TheRealMcrafter.SirenMod.packet;

import TheRealMcrafter.SirenMod.client.audio.LoopingAudioHandler;
import TheRealMcrafter.SirenMod.client.audio.SirenLooper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModPlayLoopedSoundMessage implements IMessage{

private int x;
private int y;
private int z;
private String soundName;

	public SirenModPlayLoopedSoundMessage() {}

	public SirenModPlayLoopedSoundMessage(int x, int y, int z, String soundName) {
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

	public static class Handler extends AbstractClientMessageHandler<SirenModPlayLoopedSoundMessage> {

@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModPlayLoopedSoundMessage message, MessageContext ctx) {
    		new LoopingAudioHandler(player.worldObj, message.x, message.y, message.z, message.soundName);
			
			return null;
		}
	}
}