package TheRealMcrafter.SirenMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.TileEntity.MotionDetectorTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class MotionDetector extends Block implements ITileEntityProvider {

	public String textureName;

	public MotionDetector(String textureName) {
		super(Material.piston);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new MotionDetectorTileEntity();
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);

		if (meta == 4) {
			this.setBlockBounds(1.0F, 0.32F, 0.37F, 0.9F, 0.7F, 0.63F);
		} else if (meta == 3) {
			this.setBlockBounds(0.37F, 0.32F, 0.0F, 0.63F, 0.7F, 0.1F);
		} else if (meta == 2) {
			this.setBlockBounds(0.37F, 0.32F, 0.9F, 0.63F, 0.7F, 1.0F);
		} else if (meta == 5) {
			this.setBlockBounds(0.0F, 0.32F, 0.37F, 0.1F, 0.7F, 0.63F);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int integer) {
		world.removeTileEntity(x, y, z);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (world.getBlockMetadata(x, y, z) == 5) {
			Block block = world.getBlock(x - 1, y, z);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 2) {
			Block block = world.getBlock(x, y, z + 1);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 4) {
			Block block = world.getBlock(x + 1, y, z);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 3) {
			Block block = world.getBlock(x, y, z - 1);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else {
		}
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		MotionDetectorTileEntity tile = (MotionDetectorTileEntity) world.getTileEntity(x, y, z);

		if (tile.isDetecting) {
			return 15;
		} else {
			return 0;
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block1) {
		if (world.getBlockMetadata(x, y, z) == 5) {
			Block block = world.getBlock(x - 1, y, z);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 2) {
			Block block = world.getBlock(x, y, z + 1);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 4) {
			Block block = world.getBlock(x + 1, y, z);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else if (world.getBlockMetadata(x, y, z) == 3) {
			Block block = world.getBlock(x, y, z - 1);
			if (!block.isNormalCube() || block == Blocks.air) {
				world.setBlockToAir(x, y, z);
				ItemStack itemstack = new ItemStack(SirenMod.MotionDetector);
				Entity entity = new EntityItem(world, x, y, z, itemstack);
				world.spawnEntityInWorld(entity);
			}
		} else {
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g,
			float t) {
		return false;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase,
			ItemStack itemstack) {
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:MotionDetector");
	}

}
