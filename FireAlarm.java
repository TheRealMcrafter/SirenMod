package TheRealMcrafter.SirenMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.TileEntity.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class FireAlarm extends BlockContainer {

	public String textureName;

	public FireAlarm(String textureName) {
		super(Material.piston);
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

	@Override
	public boolean canProvidePower() {
		return true;
	}

	public TileEntity createNewTileEntity(World world, int var2) {
		return new FireAlarmTileEntity();
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int integer) {
		FireAlarmTileEntity tile = (FireAlarmTileEntity) world.getTileEntity(x, y, z);
		tile.setShouldStop(true);

		world.notifyBlocksOfNeighborChange(x, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
		world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
		world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
		tile.activated = false;
		world.removeTileEntity(x, y, z);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x - 1, y, z, EAST, true) || world.isSideSolid(x + 1, y, z, WEST, true)
				|| world.isSideSolid(x, y, z - 1, SOUTH, true) || world.isSideSolid(x, y, z + 1, NORTH, true);
	}

	protected boolean checkIfWall(World world, int x, int y, int z) {
		if (!this.canPlaceBlockAt(world, x, y, z)) {
			if (world.getBlock(x, y, z) == this) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);
			}

			return false;
		} else {
			return true;
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g,
			float t) {
		if (!world.isRemote && player.isSneaking()) {
			FireAlarmTileEntity tile = (FireAlarmTileEntity) world.getTileEntity(x, y, z);

			if (tile.activated) {
				tile.rotation = 0.0F;
				tile.activated = false;
				tile.setShouldStop(true);
				tile.updateClientRender();
			} else {
				tile.rotation = 1.75F;
				tile.activated = true;
				tile.setShouldStart(true);
				tile.updateClientRender();
			}
		}

		world.notifyBlocksOfNeighborChange(x, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
		world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
		world.notifyBlocksOfNeighborChange(x, y, z + 1, this);

		return true;
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
		FireAlarmTileEntity tile = (FireAlarmTileEntity) world.getTileEntity(x, y, z);

		if (tile.activated) {
			return 15;
		}

		return 0;
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

	// Registry
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:FireAlarm");
	}
}
