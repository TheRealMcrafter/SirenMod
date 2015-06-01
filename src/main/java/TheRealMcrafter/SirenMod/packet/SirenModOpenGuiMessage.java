package TheRealMcrafter.SirenMod.packet;

import TheRealMcrafter.SirenMod.common.SirenMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModOpenGuiMessage implements IMessage {
	 private int id;

	 public SirenModOpenGuiMessage() {}

	 public SirenModOpenGuiMessage(int id) {
		 this.id = id;
	 }

@Override
	public void fromBytes(ByteBuf buffer) {
		id = buffer.readInt();
	}

@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(id);
	}
	 
	public static class Handler extends AbstractServerMessageHandler<SirenModOpenGuiMessage> {
	 
@Override
		public IMessage handleServerMessage(EntityPlayer player, SirenModOpenGuiMessage message, MessageContext ctx) {
	 		// because we sent the gui's id with the packet, we can handle all cases with one line:
	 		player.openGui(SirenMod.instance, message.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	 		return null;
	 	}
	}
}