package TheRealMcrafter.SirenMod.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GeneralSirenItem extends Item {

	public String textureName;
	public Block blockToPlace;

	public GeneralSirenItem(String textureName) {
		super();
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
		this.blockToPlace = SirenMod.GeneralSiren;
		this.setMaxStackSize(64);
		this.setMaxDamage(15);
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float blockHitX, float blockHitY, float blockHitZ) {
		Block block = world.getBlock(x, y, z);

		if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1) {
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
			if (world.canPlaceEntityOnSide(this.blockToPlace, x, y, z, false, side, (Entity) null, itemstack)) {
				int i1 = this.blockToPlace.onBlockPlaced(world, x, y, z, side, blockHitX, blockHitY, blockHitZ, 0);

				if (world.setBlock(x, y, z, this.blockToPlace, i1, 3)) {
					GeneralSirenTileEntity tile = (GeneralSirenTileEntity) world.getTileEntity(x, y, z);

					switch (itemstack.getItemDamage()) {
					case 0:
						tile.setColor("lightGray");
						break;
					case 1:
						tile.setColor("red");
						break;
					case 2:
						tile.setColor("green");
						break;
					case 3:
						tile.setColor("brown");
						break;
					case 4:
						tile.setColor("blue");
						break;
					case 5:
						tile.setColor("purple");
						break;
					case 6:
						tile.setColor("cyan");
						break;
					case 7:
						tile.setColor("black");
						break;
					case 8:
						tile.setColor("gray");
						break;
					case 9:
						tile.setColor("pink");
						break;
					case 10:
						tile.setColor("lime");
						break;
					case 11:
						tile.setColor("yellow");
						break;
					case 12:
						tile.setColor("lightBlue");
						break;
					case 13:
						tile.setColor("magenta");
						break;
					case 14:
						tile.setColor("orange");
						break;
					case 15:
						tile.setColor("white");
						break;
					}

					if (world.getBlock(x, y, z) == this.blockToPlace) {
						this.blockToPlace.onBlockPlacedBy(world, x, y, z, player, itemstack);
						this.blockToPlace.onPostBlockPlaced(world, x, y, z, i1);
					}
					world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
							(double) ((float) z + 0.5F), this.blockToPlace.stepSound.func_150496_b(),
							(this.blockToPlace.stepSound.getVolume() + 1.0F) / 2.0F,
							this.blockToPlace.stepSound.getPitch() * 0.8F);
					--itemstack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		iconArray = new IIcon[16];

		for (int i = 0; i < iconArray.length; ++i) {
			switch (i) {
			case 0:
				iconArray[i] = register.registerIcon("SirenMod:LightGreyGeneralSiren");
				break;
			case 1:
				iconArray[i] = register.registerIcon("SirenMod:RedGeneralSiren");
				break;
			case 2:
				iconArray[i] = register.registerIcon("SirenMod:GreenGeneralSiren");
				break;
			case 3:
				iconArray[i] = register.registerIcon("SirenMod:BrownGeneralSiren");
				break;
			case 4:
				iconArray[i] = register.registerIcon("SirenMod:BlueGeneralSiren");
				break;
			case 5:
				iconArray[i] = register.registerIcon("SirenMod:PurpleGeneralSiren");
				break;
			case 6:
				iconArray[i] = register.registerIcon("SirenMod:CyanGeneralSiren");
				break;
			case 7:
				iconArray[i] = register.registerIcon("SirenMod:BlackGeneralSiren");
				break;
			case 8:
				iconArray[i] = register.registerIcon("SirenMod:GreyGeneralSiren");
				break;
			case 9:
				iconArray[i] = register.registerIcon("SirenMod:PinkGeneralSiren");
				break;
			case 10:
				iconArray[i] = register.registerIcon("SirenMod:LimeGeneralSiren");
				break;
			case 11:
				iconArray[i] = register.registerIcon("SirenMod:YellowGeneralSiren");
				break;
			case 12:
				iconArray[i] = register.registerIcon("SirenMod:LightBlueGeneralSiren");
				break;
			case 13:
				iconArray[i] = register.registerIcon("SirenMod:MagentaGeneralSiren");
				break;
			case 14:
				iconArray[i] = register.registerIcon("SirenMod:OrangeGeneralSiren");
				break;
			case 15:
				iconArray[i] = register.registerIcon("SirenMod:WhiteGeneralSiren");
				break;
			}

		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		switch (this.getDamage(stack)) {
		case 0:
			return iconArray[0];
		case 1:
			return iconArray[1];
		case 2:
			return iconArray[2];
		case 3:
			return iconArray[3];
		case 4:
			return iconArray[4];
		case 5:
			return iconArray[5];
		case 6:
			return iconArray[6];
		case 7:
			return iconArray[7];
		case 8:
			return iconArray[8];
		case 9:
			return iconArray[9];
		case 10:
			return iconArray[10];
		case 11:
			return iconArray[11];
		case 12:
			return iconArray[12];
		case 13:
			return iconArray[13];
		case 14:
			return iconArray[14];
		case 15:
			return iconArray[15];
		default:
			return iconArray[0];
		}
	}

	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public IIcon getIcon(ItemStack stack, int meta){
	 * switch(this.getDamage(stack)){ case 0: return iconArray[0]; case 1:
	 * return iconArray[1]; case 2: return iconArray[2]; case 3: return
	 * iconArray[3]; case 4: return iconArray[4]; case 5: return iconArray[5];
	 * case 6: return iconArray[6]; case 7: return iconArray[7]; case 8: return
	 * iconArray[8]; case 9: return iconArray[9]; case 10: return iconArray[10];
	 * case 11: return iconArray[11]; case 12: return iconArray[12]; case 13:
	 * return iconArray[13]; case 14: return iconArray[14]; case 15: return
	 * iconArray[15]; default: return iconArray[0]; } }
	 * 
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		switch (this.getDamage(stack)) {
		case 0:
			return iconArray[0];
		case 1:
			return iconArray[1];
		case 2:
			return iconArray[2];
		case 3:
			return iconArray[3];
		case 4:
			return iconArray[4];
		case 5:
			return iconArray[5];
		case 6:
			return iconArray[6];
		case 7:
			return iconArray[7];
		case 8:
			return iconArray[8];
		case 9:
			return iconArray[9];
		case 10:
			return iconArray[10];
		case 11:
			return iconArray[11];
		case 12:
			return iconArray[12];
		case 13:
			return iconArray[13];
		case 14:
			return iconArray[14];
		case 15:
			return iconArray[15];
		default:
			return iconArray[0];
		}
	}
}
