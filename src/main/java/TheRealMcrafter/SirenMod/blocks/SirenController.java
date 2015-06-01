package TheRealMcrafter.SirenMod.blocks;

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
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.tiles.SirenControllerTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenPoleTileEntity;

public class SirenController extends Block implements ITileEntityProvider {
	
	public String textureName;
	
	public SirenController(String textureName) {
			super(Material.piston);
			this.textureName = textureName;
			this.setCreativeTab(SirenMod.SirenModCreativeTab);
			setBlockName(textureName);
	}
	

public int getRenderType(){
	return -1;}
public boolean isOpaqueCube(){
	return false;}
public boolean renderAsNormalBlock(){
	return false;}
public TileEntity createNewTileEntity(World world, int meta) {
	return new SirenControllerTileEntity();}


	public void breakBlock(World world, int x, int y, int z, Block block, int integer){		
        world.removeTileEntity(x, y, z);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		
		if (!world.isRemote){
			SirenControllerTileEntity tile = (SirenControllerTileEntity) world.getTileEntity(x, y, z);
			Block blockBelow = world.getBlock(x, y - 1, z);
		
			if (blockBelow != null){
				if (blockBelow == Blocks.air){
					tile.setRenderValue((byte) 1);
				} else {
					tile.setRenderValue((byte) 0);
				}
			}
			
			tile.updateClientTileEntity();
		}	
	}
	

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		SirenControllerTileEntity tile = (SirenControllerTileEntity) world.getTileEntity(x, y, z);
		
		if (tile.getRenderValue() == 1){
			if (meta == 4){
				this.setBlockBounds(1.0F, 0.064F, 0.064F, 0.874F, 0.936F, 0.936F);
			} else if (meta == 3){
				this.setBlockBounds(0.064F, 0.064F, 0.0F, 0.936F, 0.936F, 0.125F);
			} else if (meta == 2){
				this.setBlockBounds(0.064F, 0.064F, 0.874F, 0.936F, 0.936F, 1.0F);
			} else if (meta == 5){
				this.setBlockBounds(0.0F, 0.064F, 0.064F, 0.125F, 0.936F, 0.936F);
			}	
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		}	
	}
	
	
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float blockPosX, float blockPosY, float blockPosZ){
		if (!world.isRemote){
			SirenControllerTileEntity tile = (SirenControllerTileEntity) world.getTileEntity(x, y, z);
			
			tile.updateClientTileEntity();
			
			if (tile.getRenderValue() == 0){
				if (world.getBlockMetadata(x, y, z) == 5){
					if (blockPosX < 0.87 && blockPosX > 0.72 && blockPosY == 0.75 && blockPosZ < 0.8 && blockPosZ > 0.74){
						tile.buttonPress("red");
					} else if (blockPosX < 0.87 && blockPosX > 0.72 && blockPosY == 0.75 && blockPosZ < 0.25 && blockPosZ > 0.16){
						tile.buttonPress("green");
					} else if (blockPosX < 0.87 && blockPosX > 0.72 && blockPosY == 0.75 && blockPosZ < 0.56 && blockPosZ > 0.43){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 2){
					if (blockPosX < 0.81 && blockPosX > 0.75 && blockPosY == 0.75 && blockPosZ < 0.28 && blockPosZ > 0.13){
						tile.buttonPress("red");
					} else if (blockPosX < 0.24 && blockPosX > 0.19 && blockPosY == 0.75 && blockPosZ < 0.26 && blockPosZ > 0.13){
						tile.buttonPress("green");
					} else if (blockPosX < 0.56 && blockPosX > 0.43 && blockPosY == 0.75 && blockPosZ < 0.27 && blockPosZ > 0.13){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 4){
					if (blockPosX < 0.27 && blockPosX > 0.13 && blockPosY == 0.75 && blockPosZ < 0.24 && blockPosZ > 0.18){
						tile.buttonPress("red");
					} else if (blockPosX < 0.27 && blockPosX > 0.13 && blockPosY == 0.75 && blockPosZ < 0.81 && blockPosZ > 0.75){
						tile.buttonPress("green");
					} else if (blockPosX < 0.27 && blockPosX > 0.13 && blockPosY == 0.75 && blockPosZ < 0.56 && blockPosZ > 0.44){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 3){
					if (blockPosX < 0.25 && blockPosX > 0.18  && blockPosY == 0.75 && blockPosZ < 0.87 && blockPosZ > 0.73){
						tile.buttonPress("red");
					} else if (blockPosX < 0.80 && blockPosX > 0.75 && blockPosY == 0.75 && blockPosZ < 0.87 && blockPosZ > 0.75){
						tile.buttonPress("green");
					} else if (blockPosX < 0.56 && blockPosX > 0.44 && blockPosY == 0.75 && blockPosZ < 0.87 && blockPosZ > 0.75){
						tile.buttonPress("blue");
					}
				}
			
			} else if (tile.getRenderValue() == 1){
			
				if (world.getBlockMetadata(x, y, z) == 5){
					if (blockPosY < 0.37 && blockPosY > 0.30 && blockPosZ < 0.44 && blockPosZ > 0.31){
						tile.buttonPress("red");
					} else if (blockPosY < 0.25 && blockPosY > 0.18 && blockPosZ < 0.44 && blockPosZ > 0.31){
						tile.buttonPress("green");
					} else if (blockPosY < 0.30 && blockPosY > 0.25 && blockPosZ < 0.44 && blockPosZ > 0.31){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 2){
					if (blockPosX < 0.44 && blockPosX > 0.31 && blockPosY < 0.37 && blockPosY > 0.30){
						tile.buttonPress("red");
					} else if (blockPosX < 0.44 && blockPosX > 0.31 && blockPosY < 0.25 && blockPosY > 0.20){
						tile.buttonPress("green");
					} else if (blockPosX < 0.44 && blockPosX > 0.31 && blockPosY < 0.30 && blockPosY > 0.25){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 4){
					if (blockPosY < 0.38 && blockPosY > 0.30 && blockPosZ < 0.685 && blockPosZ > 0.56){
						tile.buttonPress("red");
					} else if (blockPosY < 0.25 && blockPosY > 0.20 && blockPosZ < 0.685 && blockPosZ > 0.56){
						tile.buttonPress("green");
					} else if (blockPosY < 0.30 && blockPosY > 0.25 && blockPosZ < 0.685 && blockPosZ > 0.56){
						tile.buttonPress("blue");
					}
				} else if (world.getBlockMetadata(x, y, z) == 3){
					if (blockPosX < 0.68 && blockPosX > 0.56  && blockPosY < 0.37 && blockPosY > 0.31){
						tile.buttonPress("red");
					} else if (blockPosX < 0.68 && blockPosX > 0.56  && blockPosY < 0.25 && blockPosY > 0.17){
						tile.buttonPress("green");
					} else if (blockPosX < 0.68 && blockPosX > 0.56  && blockPosY < 0.31 && blockPosY > 0.25){
						tile.buttonPress("blue");
					}
				}
			}
			
			System.err.println(blockPosX + ":" + blockPosY + ":" + blockPosZ);
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
		blockIcon = iconRegister.registerIcon("SirenMod:SirenController");
	}
	
}



