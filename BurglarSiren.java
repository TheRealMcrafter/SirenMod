package TheRealMcrafter.SirenMod.blocks;

import TheRealMcrafter.SirenMod.TileEntity.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;
//Imports
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BurglarSiren extends BlockContainer {

	public String textureName;

	public BurglarSiren(String textureName) {
		super(Material.PISTON);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
	}

	// Rendering details
	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BurglarSirenTileEntity();
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos blockPos) {
		return world.isSideSolid(blockPos.offset(EnumFacing.WEST), EnumFacing.EAST, true)
				|| world.isSideSolid(blockPos.offset(EnumFacing.EAST), EnumFacing.WEST, true)
				|| world.isSideSolid(blockPos.offset(EnumFacing.NORTH), EnumFacing.SOUTH, true)
				|| world.isSideSolid(blockPos.offset(EnumFacing.SOUTH), EnumFacing.NORTH, true);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos blockPos, EnumFacing side) {
		if (!this.canPlaceBlockAt(world, blockPos)) {
			if (world.getBlock(blockPos) == this) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);

			}

			return false;
		} else {
			return true;
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int integer) {
		BurglarSirenTileEntity tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z);
		tile.setShouldStop(true);
	}

	// Checks if there is a redstone signal upon placement of the siren
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		if (!world.isRemote) {
			BurglarSirenTileEntity tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z);

			if (!world.isBlockIndirectlyGettingPowered(x, y, z)) {
				tile.setShouldStop(true);
				tile.updateClientRender();
			}

			if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				tile.setShouldStart(true);
				tile.updateClientRender();
			}
		}
	}

	// Called when a nearby block is updated
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!world.isRemote) {
			BurglarSirenTileEntity tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z);

			if (!world.isBlockIndirectlyGettingPowered(x, y, z)) {
				tile.setShouldStop(true);
				tile.updateClientRender();
			}

			if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				tile.setShouldStart(true);
				tile.updateClientRender();
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g,
			float t) {
		if (!world.isRemote && player.isSneaking()) {
			BurglarSirenTileEntity tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z);
			tile.playSound();
			return true;
		} else {
			return false;
		}
	}

	// Handles block orientation
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

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

		int meta = world.getBlockMetadata(x, y, z);
		this.setBlockBounds(0.29F, 0.32F, 0.9F, 0.72F, 0.74F, 1.0F);

		if (meta == 4) {
			this.setBlockBounds(1.0F, 0.32F, 0.29F, 0.9F, 0.74F, 0.72F);
		}

		if (meta == 3) {
			this.setBlockBounds(0.29F, 0.32F, 0.0F, 0.72F, 0.74F, 0.1F);
		}

		if (meta == 2) {
			this.setBlockBounds(0.29F, 0.32F, 0.9F, 0.72F, 0.74F, 1.0F);
		}

		if (meta == 5) {
			this.setBlockBounds(0.0F, 0.32F, 0.29F, 0.1F, 0.74F, 0.72F);
		}
	}

	// Retrieves meta based on rotation
	private static int getMetadataBasedOnRotation(int rotation) {
		if (rotation >= 315 || rotation < 45) {
			return 1;
		} else if (rotation >= 45 && rotation < 135) {
			return 2;
		} else if (rotation >= 135 && rotation < 225) {
			return 0;
		} else {
			return 3;
		}
	}

	// Registry
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:BurglarSiren");
	}
}
