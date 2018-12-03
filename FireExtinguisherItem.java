package TheRealMcrafter.SirenMod.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class FireExtinguisherItem extends Item {

	public String textureName;
	private final String name = textureName;

	public FireExtinguisherItem(String textureName) {
		super();
		GameRegistry.registerItem(this, name);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
		this.setMaxStackSize(1);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Vec3 look = player.getLookVec();
		Random rand = new Random();

		world.playSoundEffect(player.posX, player.posY, player.posZ, "sirenmod:fireExtinguisher", 1.0F, 1.0F);
		for (int i = 0; i < 17; i++) {
			player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, player.posX, player.posY, player.posZ,
					look.xCoord + rand.nextGaussian() / 12, look.yCoord + rand.nextGaussian() / 12,
					look.zCoord + rand.nextGaussian() / 12);
		}

		if (!world.isRemote) {
			for (int i = -3; i < 3; i++) {
				for (int j = -3; j < 3; j++) {
					for (int k = -3; k < 3; k++) {
						Block block = player.worldObj
								.getBlockState(new BlockPos((int) (player.posX + look.xCoord + i),
										(int) (player.posY + look.yCoord + j), (int) (player.posZ + look.zCoord + k)))
								.getBlock();
						if (block == Blocks.fire) {
							if (rand.nextBoolean()) {
								player.worldObj.setBlockToAir(new BlockPos((int) (player.posX + look.xCoord + i),
										(int) (player.posY + look.yCoord + j), (int) (player.posZ + look.zCoord + k)));
							}
						}
					}
				}
			}
		}
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float blockHitX, float blockHitY, float blockHitZ) {
		if (player.isSneaking()) {
			Block block = world.getBlockState(pos).getBlock();
			if (block == Blocks.snow_layer
					&& (world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) & 7) < 1) {
				side = 1;
			} else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
				if (side == 0) {
					--y;
				}
				if (side == 1) {
					++y;
				}
				if (side == 2) {
					--z;
				}
				if (side == 3) {
					++z;
				}
				if (side == 4) {
					--x;
				}
				if (side == 5) {
					++x;
				}
			}

			if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
				return false;
			} else if (itemstack.stackSize == 0) {
				return false;
			} else {
				if (world.canPlaceEntityOnSide(SirenMod.FireExtinguisher, x, y, z, false, side, (Entity) null,
						itemstack)) {
					int i1 = SirenMod.FireExtinguisher.onBlockPlaced(world, x, y, z, side, blockHitX, blockHitY,
							blockHitZ, 0);

					if (world.setBlock(x, y, z, SirenMod.FireExtinguisher, i1, 3)) {

					}

					if (world.getBlock(x, y, z) == SirenMod.FireExtinguisher) {
						SirenMod.FireExtinguisher.onBlockPlacedBy(world, x, y, z, player, itemstack);
						SirenMod.FireExtinguisher.onPostBlockPlaced(world, x, y, z, i1);
					}
					world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
							(double) ((float) z + 0.5F), SirenMod.FireExtinguisher.stepSound.func_150496_b(),
							(SirenMod.FireExtinguisher.stepSound.getVolume() + 1.0F) / 2.0F,
							SirenMod.FireExtinguisher.stepSound.getPitch() * 0.8F);
					--itemstack.stackSize;

				}

				return true;
			}
		}

		return false;
	}

}
