package TheRealMcrafter.SirenMod.blocks;

//Imports
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
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
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenPoleTileEntity;
	
public class GeneralSiren extends BlockContainer{

public String textureName;	

	public GeneralSiren(String textureName) {
		super(Material.piston);
		setBlockName(textureName);
		this.setBlockBounds(0.16F, 0F, 0.16F, 0.84F, 0.57F, 0.84F);
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
		return new ItemStack(SirenMod.GeneralSirenItem, 1, this.getColorCode(world, x, y, z, (GeneralSirenTileEntity) world.getTileEntity(x, y, z)) );
	}
	

	
	//Stops sound when block is broken
		public void breakBlock(World world, int x, int y, int z, Block block, int integer){			
			if (!world.isRemote){
				GeneralSirenTileEntity tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z);
				tile.setShouldStop(true);
		        world.removeTileEntity(x, y, z);

			}
		}
		
		public int getColorCode(World world, int x, int y, int z, GeneralSirenTileEntity tile){
			tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z);
			
			if (tile.getColor().equals("lightGray")){
				return 0;			
			} else if (tile.getColor().equals("red")){
				return 1;
			} else if (tile.getColor().equals("green")){
				return 2;
			} else if (tile.getColor().equals("brown")){
				return 3;
			} else if (tile.getColor().equals("blue")){
				return 4;
			} else if (tile.getColor().equals("purple")){
				return 5;
			} else if (tile.getColor().equals("cyan")){
				return 6;
			} else if (tile.getColor().equals("black")){
				return 7;
			} else if (tile.getColor().equals("gray")){
				return 8;
			} else if (tile.getColor().equals("pink")){
				return 9;
			} else if (tile.getColor().equals("lime")){
				return 10;
			} else if (tile.getColor().equals("yellow")){
				return 11;
			} else if (tile.getColor().equals("lightBlue")){
				return 12;
			} else if (tile.getColor().equals("magenta")){
				return 13;
			} else if (tile.getColor().equals("orange")){
				return 14;
			} else if (tile.getColor().equals("white")){
				return 15;
			} else {
				return 0;
			}
		}
	
		//Checks if there is a redstone signal upon placement of the siren
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);		
			GeneralSirenTileEntity tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z); 			
			TileEntity tile1 = world.getTileEntity(x, y - 1, z);
			
			if (!world.isRemote){
				if (tile1 != null && tile1 instanceof SirenPoleTileEntity){
					((SirenPoleTileEntity) tile1).updateClientRender();
					if (((SirenPoleTileEntity) tile1).getIsPowered()){
						
					} else if (!world.isBlockIndirectlyGettingPowered(x, y, z)){ 
						tile.setShouldStop(true);
					} else if (world.isBlockIndirectlyGettingPowered(x, y, z)){ 
						tile.setShouldStart(true);
					}
				} else {
					if (!world.isBlockIndirectlyGettingPowered(x, y, z)){
						tile.setShouldStop(true);
					}
					
					if (world.isBlockIndirectlyGettingPowered(x, y, z)){
						tile.setShouldStart(true);
					}
				}
	        
				tile.updateClientRender();
			}
		
		}


		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
			GeneralSirenTileEntity tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z); 
			TileEntity tile1 = world.getTileEntity(x, y - 1, z);
			
			if (!world.isRemote){
				if (tile1 != null && tile1 instanceof SirenPoleTileEntity){
					((SirenPoleTileEntity) tile1).updateClientRender();
					if (((SirenPoleTileEntity) tile1).getIsPowered()){
						
					} else if (!world.isBlockIndirectlyGettingPowered(x, y, z)){ 
						tile.setShouldStop(true);
					} else if (world.isBlockIndirectlyGettingPowered(x, y, z)){ 
						tile.setShouldStart(true);
					}
				} else {
					if (!world.isBlockIndirectlyGettingPowered(x, y, z)){
						tile.setShouldStop(true);
					}
					
					if (world.isBlockIndirectlyGettingPowered(x, y, z)){
						tile.setShouldStart(true);
					}
				}
	        
				tile.updateClientRender();
			}
		
		}


		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			GeneralSirenTileEntity tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z); 			
			
			if (!world.isRemote){
				if (player.isSneaking()){
					tile.startSingleRotation();
				} else {
					if (player.getHeldItem() != null && player.getHeldItem().getItem() == Items.dye){
						if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 0){
							if (!tile.getColor().equals("black")){
								player.getHeldItem().stackSize--;}
							tile.setColor("black");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 1){
							if (!tile.getColor().equals("red")){
								player.getHeldItem().stackSize--;}
							tile.setColor("red");	
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 2){
							if (!tile.getColor().equals("green")){
								player.getHeldItem().stackSize--;}
							tile.setColor("green");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 3){
							if (!tile.getColor().equals("brown")){
								player.getHeldItem().stackSize--;}
							tile.setColor("brown");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 4){
							if (!tile.getColor().equals("blue")){
								player.getHeldItem().stackSize--;}
							tile.setColor("blue");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 5){
							if (!tile.getColor().equals("purple")){
								player.getHeldItem().stackSize--;}
							tile.setColor("purple");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 6){
							if (!tile.getColor().equals("cyan")){
								player.getHeldItem().stackSize--;}
							tile.setColor("cyan");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 7){
							if (!tile.getColor().equals("lightGray")){
								player.getHeldItem().stackSize--;}
							tile.setColor("lightGray");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 8){
							if (!tile.getColor().equals("gray")){
								player.getHeldItem().stackSize--;}
							tile.setColor("gray");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 9){
							if (!tile.getColor().equals("pink")){
								player.getHeldItem().stackSize--;}
							tile.setColor("pink");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 10){
							if (!tile.getColor().equals("lime")){
								player.getHeldItem().stackSize--;}
							tile.setColor("lime");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 11){
							if (!tile.getColor().equals("yellow")){
								player.getHeldItem().stackSize--;}
							tile.setColor("yellow");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 12){
							if (!tile.getColor().equals("lightBlue")){
								player.getHeldItem().stackSize--;}
							tile.setColor("lightBlue");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 13){
							if (!tile.getColor().equals("magenta")){
								player.getHeldItem().stackSize--;}
							tile.setColor("magenta");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 14){
							if (!tile.getColor().equals("orange")){
								player.getHeldItem().stackSize--;}
							tile.setColor("orange");
						} else if (player.getHeldItem().getItem().getDamage(player.getHeldItem()) == 15){
							if (!tile.getColor().equals("white")){
								player.getHeldItem().stackSize--;}
							tile.setColor("white");
						}
						tile.updateClientRender();
					}
				}
				}
			
			return true;
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
		this.blockIcon = iconRegister.registerIcon("sirenmod:GeneralSiren");	
	}


public TileEntity createNewTileEntity(World world, int meta) {
		return new GeneralSirenTileEntity();
}


}
