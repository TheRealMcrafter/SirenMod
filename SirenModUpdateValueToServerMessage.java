package TheRealMcrafter.SirenMod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import TheRealMcrafter.SirenMod.TileEntity.SprinklerTileEntity;

public class SirenModUpdateValueToServerMessage implements IMessage {

	private int x;
	private int y;
	private int z;
	private String strValue;
	private double dblValue;
	private int intValue;
	private float fltValue;
	private boolean boolValue;
	private int type;

	public SirenModUpdateValueToServerMessage() {
	}

	public SirenModUpdateValueToServerMessage(int x, int y, int z, String value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.strValue = value;
		this.type = 1;
	}

	public SirenModUpdateValueToServerMessage(int x, int y, int z, double value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dblValue = value;
		this.type = 2;
	}

	public SirenModUpdateValueToServerMessage(int x, int y, int z, int value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.intValue = value;
		this.type = 3;
	}

	public SirenModUpdateValueToServerMessage(int x, int y, int z, float value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.fltValue = value;
		this.type = 4;
	}

	public SirenModUpdateValueToServerMessage(int x, int y, int z, boolean value) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.boolValue = value;
		this.type = 5;
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.type = buffer.readInt();

		switch (this.type) {
		case 1:
			this.strValue = ByteBufUtils.readUTF8String(buffer);
			break;
		case 2:
			this.dblValue = buffer.readDouble();
			break;
		case 3:
			this.intValue = buffer.readInt();
			break;
		case 4:
			this.fltValue = buffer.readFloat();
			break;
		case 5:
			this.boolValue = buffer.readBoolean();

			break;
		}
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(type);

		switch (this.type) {
		case 1:
			ByteBufUtils.writeUTF8String(buffer, strValue);
			break;
		case 2:
			buffer.writeDouble(dblValue);
			break;
		case 3:
			buffer.writeInt(intValue);
			break;
		case 4:
			buffer.writeFloat(fltValue);
			break;
		case 5:
			buffer.writeBoolean(boolValue);
			break;
		}
	}

	public static class Handler extends AbstractServerMessageHandler<SirenModUpdateValueToServerMessage> {

		@Override
		public IMessage handleServerMessage(EntityPlayer player, SirenModUpdateValueToServerMessage message,
				MessageContext ctx) {
			TileEntity tile = player.worldObj.getTileEntity(new BlockPos(message.x, message.y, message.z));

			if (tile instanceof SprinklerTileEntity) {
				((SprinklerTileEntity) tile).shouldSpawn = message.boolValue;
			}

			return null;
		}
	}
}