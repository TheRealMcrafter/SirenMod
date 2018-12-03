package TheRealMcrafter.SirenMod.blocks;

//Imports
import java.lang.ref.Reference;
import java.util.Random;

import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenPoleTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//Class Declaration 
public class NuclearSiren extends BlockContainer {

	public String textureName;

	public NuclearSiren(String textureName) {
		super(Material.piston);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		this.setBlockBounds(0.35F, 0F, 0.35F, 0.65F, 0.65F, 0.65F);
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

	public TileEntity createNewTileEntity(World world, int var2) {
		return new NuclearSirenTileEntity();
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int integer) {
		NuclearSirenTileEntity tile = (NuclearSirenTileEntity) world.getTileEntity(new BlockPos(x, y, z));
		tile.setShouldStop(true);
		world.removeTileEntity(new BlockPos(x, y, z));
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, new BlockPos(x, y, z), (IBlockState) this);
		NuclearSirenTileEntity tile = (NuclearSirenTileEntity) world.getTileEntity(new BlockPos(x, y, z));
		TileEntity tile1 = world.getTileEntity(new BlockPos(x, y - 1, z));

		if (!world.isRemote) {
			if (tile1 != null && tile1 instanceof SirenPoleTileEntity) {
				((SirenPoleTileEntity) tile1).updateClientRender();
				if (((SirenPoleTileEntity) tile1).getIsPowered()) {

				} else if (!(world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0)) {
					tile.setShouldStop(true);
				} else if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
					tile.setShouldStart(true);
				}
			} else {
				if (!(world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0)) {
					tile.setShouldStop(true);
				}

				if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
					tile.setShouldStart(true);
				}
			}

			tile.updateClientTileEntity();
		}

	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		NuclearSirenTileEntity tile = (NuclearSirenTileEntity) world.getTileEntity(new BlockPos(x, y, z));
		TileEntity tile1 = world.getTileEntity(new BlockPos(x, y - 1, z));

		if (!world.isRemote) {
			if (tile1 != null && tile1 instanceof SirenPoleTileEntity) {
				((SirenPoleTileEntity) tile1).updateClientRender();
				if (((SirenPoleTileEntity) tile1).getIsPowered()) {

				} else if (!(world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0)) {
					tile.setShouldStop(true);
				} else if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
					tile.setShouldStart(true);
				}
			} else {
				if (!(world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0)) {
					tile.setShouldStop(true);
				}

				if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
					tile.setShouldStart(true);
				}
			}

			tile.updateClientTileEntity();
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g,
			float t) {
		NuclearSirenTileEntity tile = ((NuclearSirenTileEntity) world.getTileEntity(new BlockPos(x, y, z)));

		if (!world.isRemote) {
			if (player.isSneaking()) {
				tile.startSingleRotation();
			}
		}
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase,
			ItemStack itemstack) {
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0) {
			world.setBlockState(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 2);
		}
		if (l == 1) {
			world.setBlockState(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 2);
		}
		if (l == 2) {
			world.setBlockState(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 2);
		}
		if (l == 3) {
			world.setBlockState(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 2);
		}
	}

}
