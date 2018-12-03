package TheRealMcrafter.SirenMod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import TheRealMcrafter.SirenMod.TileEntity.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.TileEntity.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.packet.SirenModStopSoundsMessage;

public class Wrench extends Item {

	public String textureName;
	private final String name = textureName;

	public Wrench(String textureName) {
		super();
		this.textureName = textureName;
		GameRegistry.registerItem(this, name);
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float blockHitX, float blockHitY, float blockHitZ) {
		TileEntity tile = world.getTileEntity(pos);

		if (player.capabilities.isCreativeMode
				&& MinecraftServer.getServer().getConfigurationManager().canSendCommands(player.getGameProfile())) {

			if (tile != null) {
				if (tile instanceof GeneralSirenTileEntity) {
					((GeneralSirenTileEntity) tile).setShouldStop(true);
					SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(),
							world.provider.getDimensionId(), pos.getX(), pos.getY(), pos.getZ(), 500000);
					return true;
				} else if (tile instanceof NuclearSirenTileEntity) {
					((NuclearSirenTileEntity) tile).setShouldStop(true);
					SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(),
							world.provider.getDimensionId(), pos.getX(), pos.getY(), pos.getZ(), 500000);
					return true;
				} else if (tile instanceof FireAlarmTileEntity) {
					((FireAlarmTileEntity) tile).setShouldStop(true);
					SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(),
							world.provider.getDimensionId(), pos.getX(), pos.getY(), pos.getZ(), 500000);
					return true;
				} else if (tile instanceof BurglarSirenTileEntity) {
					((BurglarSirenTileEntity) tile).setShouldStop(true);
					SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(),
							world.provider.getDimensionId(), pos.getX(), pos.getY(), pos.getZ(), 500000);
					return true;
				} else if (tile instanceof AmericanSignalT121TileEntity) {
					((AmericanSignalT121TileEntity) tile).setShouldStop(true);
					SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(),
							world.provider.getDimensionId(), pos.getX(), pos.getY(), pos.getZ(), 500000);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
