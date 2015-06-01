package TheRealMcrafter.SirenMod.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.packet.SirenModStopSoundsMessage;
import TheRealMcrafter.SirenMod.tiles.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.NuclearSirenTileEntity;

public class Wrench extends Item {		
	
	public String textureName;
			
	public Wrench(String textureName) {
		super();
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}
	
@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float blockHitX, float blockHitY, float blockHitZ){
		TileEntity tile = world.getTileEntity(x, y, z);
				
		if (player.capabilities.isCreativeMode && MinecraftServer.getServer().getConfigurationManager().func_152596_g(player.getGameProfile())){
		if (tile != null){
			if (tile instanceof GeneralSirenTileEntity){
				((GeneralSirenTileEntity) tile).setShouldStop(true);
				SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(), world.provider.dimensionId, x, y, z, 500000);
				return true;
			} else if (tile instanceof NuclearSirenTileEntity){
				((NuclearSirenTileEntity) tile).setShouldStop(true);
				SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(), world.provider.dimensionId, x, y, z, 500000);
				return true;
			} else if (tile instanceof FireAlarmTileEntity){
				((FireAlarmTileEntity) tile).setShouldStop(true);
				SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(), world.provider.dimensionId, x, y, z, 500000);
				return true;
			} else if (tile instanceof BurglarSirenTileEntity){
				((BurglarSirenTileEntity) tile).setShouldStop(true);
				SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(), world.provider.dimensionId, x, y, z, 500000);
				return true;
			} else if (tile instanceof AmericanSignalT121TileEntity){
				((AmericanSignalT121TileEntity) tile).setShouldStop(true);
				SirenModPacketDispatcher.sendToAllAround(new SirenModStopSoundsMessage(), world.provider.dimensionId, x, y, z, 500000);
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
	
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon("SirenMod:Wrench");
	}
}
