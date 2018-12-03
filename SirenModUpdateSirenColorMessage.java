package TheRealMcrafter.SirenMod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;

public class SirenModUpdateSirenColorMessage implements IMessage {

	private int x, y, z;
	private String color;

	public SirenModUpdateSirenColorMessage() {
	}

	public SirenModUpdateSirenColorMessage(int x, int y, int z, String color) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = color;
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.color = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		ByteBufUtils.writeUTF8String(buffer, color);
	}

	public static class Handler extends AbstractServerMessageHandler<SirenModUpdateSirenColorMessage> {

		@Override
		public IMessage handleServerMessage(EntityPlayer player, SirenModUpdateSirenColorMessage message,
				MessageContext ctx) {
			GeneralSirenTileEntity tile = (GeneralSirenTileEntity) player.worldObj
					.getTileEntity(new BlockPos(message.x, message.y, message.z));

			tile.setColor(message.color);
			return null;
		}
	}
}