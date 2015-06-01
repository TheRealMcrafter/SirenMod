package TheRealMcrafter.SirenMod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.ProximitySensorTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenPoleTileEntity;

public class ProximitySensor extends Block implements ITileEntityProvider{
		
	public String textureName;
		
	public ProximitySensor(String textureName) {
		super(Material.piston);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setBlockName(textureName);
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.45F, 0.7F);
	}
		

	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	public TileEntity createNewTileEntity(World world, int meta) {
		return new ProximitySensorTileEntity();}


		public void breakBlock(World world, int x, int y, int z, Block block, int integer){		
	        world.removeTileEntity(x, y, z);
		}
		
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
		}
		
@Override
		public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
			ProximitySensorTileEntity tile = (ProximitySensorTileEntity) world.getTileEntity(x, y, z);
			
			if (tile.isDetecting){
					return 15;
			} else {
				return 0;
			}
		}


		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
			
		}
		

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			return false;
		}

		
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
			 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		        if (l == 0){world.setBlockMetadataWithNotify(x, y, z, 2, 2);}
		        if (l == 1){world.setBlockMetadataWithNotify(x, y, z, 5, 2);}
		        if (l == 2){world.setBlockMetadataWithNotify(x, y, z, 3, 2);}
		        if (l == 3){world.setBlockMetadataWithNotify(x, y, z, 4, 2);}
		}
			
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:ProximitySensor");
	}

}
