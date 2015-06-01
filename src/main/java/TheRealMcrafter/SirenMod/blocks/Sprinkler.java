package TheRealMcrafter.SirenMod.blocks;

import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.tiles.MotionDetectorTileEntity;
import TheRealMcrafter.SirenMod.tiles.SprinklerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Sprinkler extends Block implements ITileEntityProvider{

	public Sprinkler(String texturename) {
		super(Material.piston);
		this.textureName = texturename;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setBlockName(textureName);
		this.setBlockBounds(0.4F, 0.75F, 0.4F, 0.6F, 1.0F, 0.6F);
	}
		

	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	
	

		public void breakBlock(World world, int x, int y, int z, Block block, int integer){		
	        world.removeTileEntity(x, y, z);
		}
		
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
			
			if (!world.isRemote){
				SprinklerTileEntity tile = (SprinklerTileEntity) world.getTileEntity(x, y, z);
				if (world.isBlockIndirectlyGettingPowered(x, y, z)){
					tile.setRunning(true);
				} else {
					tile.setRunning(false);
				}
			}
		}
		
		
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
			if (!world.isRemote){
				SprinklerTileEntity tile = (SprinklerTileEntity) world.getTileEntity(x, y, z);
				if (world.isBlockIndirectlyGettingPowered(x, y, z)){
					tile.setRunning(true);
				} else {
					tile.setRunning(false);
				}
			}
		}
		

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			if (!world.isRemote){
				SprinklerTileEntity tile = (SprinklerTileEntity) world.getTileEntity(x, y, z);
			}
			return true;
		}

		
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
			 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		        if (l == 0){world.setBlockMetadataWithNotify(x, y, z, 2, 2);}
		        if (l == 1){world.setBlockMetadataWithNotify(x, y, z, 5, 2);}
		        if (l == 2){world.setBlockMetadataWithNotify(x, y, z, 3, 2);}
		        if (l == 3){world.setBlockMetadataWithNotify(x, y, z, 4, 2);}
		}
			
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:Sprinkler");
	}


	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new SprinklerTileEntity();
	}

}
