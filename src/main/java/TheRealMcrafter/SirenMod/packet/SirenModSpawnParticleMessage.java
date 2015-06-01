package TheRealMcrafter.SirenMod.packet;

import TheRealMcrafter.SirenMod.client.audio.LoopingAudioHandler;
import TheRealMcrafter.SirenMod.client.audio.SirenLooper;
import TheRealMcrafter.SirenMod.tiles.SprinklerTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModSpawnParticleMessage implements IMessage{

private int x;
private int y;
private int z;
private String particleName;

	public SirenModSpawnParticleMessage() {}

	public SirenModSpawnParticleMessage(int x, int y, int z, String particleName) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.particleName = particleName;
	}

@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.particleName = ByteBufUtils.readUTF8String(buffer);
	}

@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		ByteBufUtils.writeUTF8String(buffer, particleName);
	}

	public static class Handler extends AbstractClientMessageHandler<SirenModSpawnParticleMessage> {

@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModSpawnParticleMessage message, MessageContext ctx) {
			SprinklerTileEntity tile = (SprinklerTileEntity) player.worldObj.getTileEntity(message.x, message.y, message.z);
			tile.shouldSpawn = true;
			return null;
		}
	}
}