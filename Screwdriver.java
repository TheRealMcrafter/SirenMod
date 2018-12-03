package TheRealMcrafter.SirenMod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import TheRealMcrafter.SirenMod.TileEntity.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.TileEntity.SirenControllerTileEntity;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class Screwdriver extends Item {

	public String textureName;
	private final String name = textureName;

	public Screwdriver(String textureName) {
		super();
		this.textureName = textureName;
		GameRegistry.registerItem(this, name);
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}

	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if (stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());

		stack.getTagCompound().setInteger("x", 0);
		stack.getTagCompound().setInteger("y", 0);
		stack.getTagCompound().setInteger("z", 0);

	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float blockHitX, float blockHitY, float blockHitZ) {
		if (!world.isRemote) {
			TileEntity tileentity = world.getTileEntity(pos);
			if (itemstack.getTagCompound() == null)
				itemstack.setTagCompound(new NBTTagCompound());

			if (tileentity != null) {
				if (tileentity instanceof SirenControllerTileEntity) {
					if (itemstack.getTagCompound().getInteger("x") == 0
							&& itemstack.getTagCompound().getInteger("y") == 0
							&& itemstack.getTagCompound().getInteger("z") == 0) {
					} else {
						SirenControllerTileEntity tile = (SirenControllerTileEntity) tileentity;
						tile.sirensX.add(itemstack.getTagCompound().getInteger("x"));
						tile.sirensY.add(itemstack.getTagCompound().getInteger("y"));
						tile.sirensZ.add(itemstack.getTagCompound().getInteger("z"));
						tile.updateClientTileEntity();

						itemstack.getTagCompound().setInteger("x", 0);
						itemstack.getTagCompound().setInteger("y", 0);
						itemstack.getTagCompound().setInteger("z", 0);

					}
				} else if (tileentity instanceof GeneralSirenTileEntity) {
					itemstack.getTagCompound().setInteger("x", pos.getX());
					itemstack.getTagCompound().setInteger("y", pos.getY());
					itemstack.getTagCompound().setInteger("z", pos.getZ());
				} else if (tileentity instanceof NuclearSirenTileEntity) {
					itemstack.getTagCompound().setInteger("x", pos.getX());
					itemstack.getTagCompound().setInteger("y", pos.getY());
					itemstack.getTagCompound().setInteger("z", pos.getZ());
				} else if (tileentity instanceof AmericanSignalT121TileEntity) {
					itemstack.getTagCompound().setInteger("x", pos.getX());
					itemstack.getTagCompound().setInteger("y", pos.getY());
					itemstack.getTagCompound().setInteger("z", pos.getZ());
				}
			}
		}
		return false;
	}

}
