package TheRealMcrafter.SirenMod.blocks;

//Imports
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.TileEntity.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenPoleTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;

//Class Declaration 
public class SirenPole extends BlockContainer {

	public String textureName;

	public SirenPole(String textureName) {
		super(Material.piston);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		this.setBlockBounds(0.44F, 0F, 0.44F, 0.56F, 1.0F, 0.56F);
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
		return new SirenPoleTileEntity();
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int integer) {
		SirenPoleTileEntity tile = (SirenPoleTileEntity) world.getTileEntity(x, y, z);
		TileEntity tile1 = world.getTileEntity(x, y + 1, z);

		if (!world.isRemote) {
			if (tile1 != null) {
				if (tile1 instanceof SirenPoleTileEntity) {
					((SirenPoleTileEntity) tile1).setIsPowered(false);
				} else if (tile1 instanceof GeneralSirenTileEntity) {
					if (!((GeneralSirenTileEntity) tile1).getIsLinked()) {
						((GeneralSirenTileEntity) tile1).setShouldStop(true);
						((GeneralSirenTileEntity) tile1).updateClientTileEntity();
					}
				} else if (tile1 instanceof NuclearSirenTileEntity) {
					if (!((NuclearSirenTileEntity) tile1).getIsLinked()) {
						((NuclearSirenTileEntity) tile1).setShouldStop(true);
						((NuclearSirenTileEntity) tile1).updateClientTileEntity();
					}
				} else if (tile1 instanceof AmericanSignalT121TileEntity) {
					if (!((AmericanSignalT121TileEntity) tile1).getIsLinked()) {
						((AmericanSignalT121TileEntity) tile1).setShouldStop(true);
						((AmericanSignalT121TileEntity) tile1).updateClientTileEntity();
					}
				}
			}
		}

		world.removeTileEntity(x, y, z);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		SirenPoleTileEntity tile = (SirenPoleTileEntity) world.getTileEntity(x, y, z);

		if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
			tile.setIsPowered(false);
		}

		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			tile.setIsPowered(true);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		SirenPoleTileEntity tile = (SirenPoleTileEntity) world.getTileEntity(x, y, z);

		if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
			tile.setIsPowered(false);
		}

		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			tile.setIsPowered(true);
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
		blockIcon = iconRegister.registerIcon("SirenMod:SirenPole");
	}
}
