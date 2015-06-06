package TheRealMcrafter.SirenMod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.tiles.FireExtinguisherTileEntity;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenPoleTileEntity;
	
public class FireExtinguisher extends Block implements ITileEntityProvider{

public String textureName;	

	public FireExtinguisher(String textureName) {
		super(Material.piston);
		setBlockName(textureName);
		this.setBlockBounds(0.4F, 0F, 0.4F, 0.6F, 0.8F, 0.6F);
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
	}
	
	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	
	public Item getItemDropped(int amount, Random rand, int fortune){
		return null;
	}
	
@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(SirenMod.FireExtinguisherItem);
	}
	

	
		public void breakBlock(World world, int x, int y, int z, Block block, int integer){			
			if (!world.isRemote){
				FireExtinguisherTileEntity tile = (FireExtinguisherTileEntity) world.getTileEntity(x, y, z);
		        world.removeTileEntity(x, y, z);

			}
		}
		
	
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);		
		}


		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		}


		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			if (player.isSneaking()){
				if (!world.isRemote){
					if (!player.capabilities.isCreativeMode){
						player.inventory.addItemStackToInventory(new ItemStack(SirenMod.FireExtinguisherItem, 1));
						player.inventoryContainer.detectAndSendChanges();
					}
					
					world.setBlockToAir(x, y, z);
				}
				return true;
			} else {
				return false;
			}
		}
		
	
//Handles block orientation
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
		 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        if (l == 0){
	            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	        }

	        if (l == 1){
	        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	        }

	        if (l == 2){
	        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	        }

	        if (l == 3){
	        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	        }
	}
	
@Override
	public void registerBlockIcons(IIconRegister iconRegister) { 
		this.blockIcon = iconRegister.registerIcon("SirenMod:FireExtinguisher");	
	}


public TileEntity createNewTileEntity(World world, int meta) {
		return new FireExtinguisherTileEntity();
}


}
