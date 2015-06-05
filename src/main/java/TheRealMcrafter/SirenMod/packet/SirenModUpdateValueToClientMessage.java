package TheRealMcrafter.SirenMod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import TheRealMcrafter.SirenMod.tiles.SprinklerTileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SirenModUpdateValueToClientMessage implements IMessage{

private int x;
private int y;
private int z;
private String strValue;
private double dblValue;
private int intValue;
private float fltValue;
private boolean boolValue;

	public SirenModUpdateValueToClientMessage() {}

	public SirenModUpdateValueToClientMessage(int x, int y, int z, String value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.strValue = value;
	}
	
	public SirenModUpdateValueToClientMessage(int x, int y, int z, double value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dblValue = value;
	}
	
	public SirenModUpdateValueToClientMessage(int x, int y, int z, int value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.intValue = value;
	}
	
	public SirenModUpdateValueToClientMessage(int x, int y, int z, float value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.fltValue = value;
	}
	
	public SirenModUpdateValueToClientMessage(int x, int y, int z, boolean value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.boolValue = value;
	}

@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		try {
			this.strValue = ByteBufUtils.readUTF8String(buffer);
			this.dblValue = buffer.readDouble();
			this.intValue = buffer.readInt();
			this.fltValue = buffer.readFloat();
			this.boolValue = buffer.readBoolean();
		} catch (NullPointerException e){
		} catch (IndexOutOfBoundsException e){	
		}
		
	}

@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		try {
			ByteBufUtils.writeUTF8String(buffer, strValue);
			buffer.writeDouble(dblValue);
			buffer.writeInt(intValue);
			buffer.writeFloat(fltValue);
			buffer.writeBoolean(boolValue);
		} catch (NullPointerException e){
		}
		
	}

	public static class Handler extends AbstractClientMessageHandler<SirenModUpdateValueToClientMessage> {

@Override
		public IMessage handleClientMessage(EntityPlayer player, SirenModUpdateValueToClientMessage message, MessageContext ctx) {
			return null;
		}
	}
}