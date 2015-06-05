package TheRealMcrafter.SirenMod.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import TheRealMcrafter.SirenMod.common.SirenMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class SirenModPacketDispatcher{
 private static byte packetId = 0;

//credit to coolAlias for his awesome tutorial on packets, my entire framework is based on his tutorial.
 /**
 * The SimpleNetworkWrapper instance is used both to register and send packets.
 * Since I will be adding wrapper methods, this field is private, but you should
 * make it public if you plan on using it directly.
 */
 private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(SirenMod.modID);

 /**
 * Call this during pre-init or loading and register all of your packets (messages) here
 */
 	public static final void registerPackets() {
 		SirenModPacketDispatcher.registerMessage(SirenModOpenGuiMessage.Handler.class, SirenModOpenGuiMessage.class, Side.SERVER);
 		SirenModPacketDispatcher.registerMessage(SirenModPlayLoopedSoundMessage.Handler.class, SirenModPlayLoopedSoundMessage.class, Side.CLIENT);
 		SirenModPacketDispatcher.registerMessage(SirenModUpdateSirenColorMessage.Handler.class, SirenModUpdateSirenColorMessage.class, Side.SERVER);
 		SirenModPacketDispatcher.registerMessage(SirenModStopSoundsMessage.Handler.class, SirenModStopSoundsMessage.class, Side.CLIENT);
 		SirenModPacketDispatcher.registerMessage(SirenModSpawnParticleMessage.Handler.class, SirenModSpawnParticleMessage.class, Side.CLIENT);
 		SirenModPacketDispatcher.registerMessage(SirenModPlaySoundMessage.Handler.class, SirenModPlaySoundMessage.class, Side.CLIENT);
 		SirenModPacketDispatcher.registerMessage(SirenModUpdateValueToClientMessage.Handler.class, SirenModUpdateValueToClientMessage.class, Side.CLIENT);
 		SirenModPacketDispatcher.registerMessage(SirenModUpdateValueToServerMessage.Handler.class, SirenModUpdateValueToServerMessage.class, Side.SERVER);

 	}

 /**
 * Registers a message and message handler
 */
 	private static final void registerMessage(Class handlerClass, Class messageClass, Side side) {
 		SirenModPacketDispatcher.dispatcher.registerMessage(handlerClass, messageClass, packetId++, side);
 	}

 	
 
 /**
 * Send this message to the specified player.
 * See {@link SimpleNetworkWrapper#sendTo(IMessage, EntityPlayerMP)}
 */
 	public static final void sendTo(IMessage message, EntityPlayerMP player) {
 		SirenModPacketDispatcher.dispatcher.sendTo(message, player);
 	}

 /**
 * Send this message to everyone within a certain range of a point.
 * See {@link SimpleNetworkWrapper#sendToDimension(IMessage, NetworkRegistry.TargetPoint)}
 */
 	public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
 		SirenModPacketDispatcher.dispatcher.sendToAllAround(message, point);
 	}

 /**
 * Sends a message to everyone within a certain range of the coordinates in the same dimension.
 */
 	public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
 		SirenModPacketDispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
 	}

 /**
 * Sends a message to everyone within a certain range of the player provided.
 */
 	public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
 		SirenModPacketDispatcher.sendToAllAround(message, player.worldObj.provider.dimensionId, player.posX, player.posY, player.posZ, range);
 	}

 /**
 * Send this message to everyone within the supplied dimension.
 * See {@link SimpleNetworkWrapper#sendToDimension(IMessage, int)}
 */
 	public static final void sendToDimension(IMessage message, int dimensionId) {
 		SirenModPacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
 	}

 /**
 * Send this message to the server.
 * See {@link SimpleNetworkWrapper#sendToServer(IMessage)}
 */
 	public static final void sendToServer(IMessage message) {
 		SirenModPacketDispatcher.dispatcher.sendToServer(message);
 	}
}
