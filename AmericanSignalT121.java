package TheRealMcrafter.SirenMod.blocks;

import TheRealMcrafter.SirenMod.TileEntity.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenPoleTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class AmericanSignalT121 extends BlockContainer {

	public static final PropertyInteger meta = PropertyInteger.create("meta", 0, 15);

	public AmericanSignalT121(String textureName) {
		super(Material.PISTON);
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

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new AmericanSignalT121TileEntity();
	}

	@Override
	public void breakBlock(World world, BlockPos blockPos, IBlockState blockState) {
		AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) world.getTileEntity(blockPos);
		tile.setShouldStop(true);
		world.removeTileEntity(blockPos);
	}

	@Override
	public void onBlockAdded(World world, BlockPos blockPos, IBlockState blockState) {
		super.onBlockAdded(world, blockPos, blockState);
		AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) world.getTileEntity(blockPos);
		TileEntity tile1 = world.getTileEntity(blockPos.up());

		if (!world.isRemote) {
			if (tile1 != null && tile1 instanceof SirenPoleTileEntity) {
				((SirenPoleTileEntity) tile1).updateClientRender();
				if (((SirenPoleTileEntity) tile1).getIsPowered()) {

				} else if (world.isBlockIndirectlyGettingPowered(blockPos) < 15) {
					tile.setShouldStop(true);
				} else if (world.isBlockIndirectlyGettingPowered(blockPos) == 15) {
					tile.setShouldStart(true);
				}
			} else {
				if (world.isBlockIndirectlyGettingPowered(blockPos) < 15) {
					tile.setShouldStop(true);
				}

				if (world.isBlockIndirectlyGettingPowered(blockPos) == 15) {
					tile.setShouldStart(true);
				}
			}

			tile.updateClientTileEntity();
		}

	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState blockState, Block neighbourBlock) {
		AmericanSignalT121TileEntity tile = (AmericanSignalT121TileEntity) world.getTileEntity(pos);
		TileEntity tile1 = world.getTileEntity(pos.down());
		if (!world.isRemote) {
			if (tile1 != null && tile1 instanceof SirenPoleTileEntity) {
				((SirenPoleTileEntity) tile1).updateClientRender();
				if (((SirenPoleTileEntity) tile1).getIsPowered()) {

				} else if (world.isBlockIndirectlyGettingPowered(pos) < 15) {
					tile.setShouldStop(true);
				} else if (world.isBlockIndirectlyGettingPowered(pos) == 15) {
					tile.setShouldStart(true);
				}
			} else {
				if (world.isBlockIndirectlyGettingPowered(pos) < 15) {
					tile.setShouldStop(true);
				}

				if (world.isBlockIndirectlyGettingPowered(pos) == 15) {
					tile.setShouldStart(true);
				}
			}

			tile.updateClientTileEntity();
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState blockState, EntityPlayer player,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		AmericanSignalT121TileEntity tile = ((AmericanSignalT121TileEntity) world.getTileEntity(pos));
		/*
		 * if (!world.isRemote){ if (player.isSneaking()){ tile.playSound(); } }
		 * return true;
		 */
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState blockState, EntityLivingBase entityLivingBase,
			ItemStack itemstack) {
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0) {
			world.setBlockState(pos, blockState.withProperty(meta, Integer.valueOf(2)), 2);
		}
		if (l == 1) {
			world.setBlockState(pos, blockState.withProperty(meta, Integer.valueOf(5)), 2);
		}
		if (l == 2) {
			world.setBlockState(pos, blockState.withProperty(meta, Integer.valueOf(3)), 2);
		}
		if (l == 3) {
			world.setBlockState(pos, blockState.withProperty(meta, Integer.valueOf(4)), 2);
		}
	}
}
