package TheRealMcrafter.SirenMod.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TheRealMcrafter.SirenMod.common.SirenMod;
import TheRealMcrafter.SirenMod.packet.SirenModPacketDispatcher;
import TheRealMcrafter.SirenMod.packet.SirenModStopSoundsMessage;
import TheRealMcrafter.SirenMod.tiles.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.SirenControllerTileEntity;
import TheRealMcrafter.SirenMod.tiles.ISirenTileEntity;

public class Screwdriver extends Item {		
	
	public String textureName;
			
	public Screwdriver(String textureName) {
		super();
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}
	
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
    	if(stack.stackTagCompound == null )
            stack.setTagCompound(new NBTTagCompound());
    	
    	stack.stackTagCompound.setInteger("x", 0);
    	stack.stackTagCompound.setInteger("y", 0);
    	stack.stackTagCompound.setInteger("z", 0);

	}
	
	
	
@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float blockHitX, float blockHitY, float blockHitZ){
		if (!world.isRemote){
			TileEntity tileentity = world.getTileEntity(x, y, z);
			if(itemstack.stackTagCompound == null )
	            itemstack.setTagCompound(new NBTTagCompound());
			
			if (tileentity != null){
				if (tileentity instanceof SirenControllerTileEntity){
					if (itemstack.stackTagCompound.getInteger("x") == 0 && itemstack.stackTagCompound.getInteger("y") == 0 && itemstack.stackTagCompound.getInteger("z") == 0){
					} else {
						SirenControllerTileEntity tile = (SirenControllerTileEntity) tileentity;
						tile.sirensX.add(itemstack.stackTagCompound.getInteger("x"));
						tile.sirensY.add(itemstack.stackTagCompound.getInteger("y"));
						tile.sirensZ.add(itemstack.stackTagCompound.getInteger("z"));
						tile.updateClientTileEntity();
						
						itemstack.stackTagCompound.setInteger("x", 0);
						itemstack.stackTagCompound.setInteger("y", 0);
						itemstack.stackTagCompound.setInteger("z", 0);
	
					}
				} else if (tileentity instanceof GeneralSirenTileEntity){
					itemstack.stackTagCompound.setInteger("x", x);
					itemstack.stackTagCompound.setInteger("y", y);
					itemstack.stackTagCompound.setInteger("z", z);
				} else if (tileentity instanceof NuclearSirenTileEntity){
					itemstack.stackTagCompound.setInteger("x", x);
					itemstack.stackTagCompound.setInteger("y", y);
					itemstack.stackTagCompound.setInteger("z", z);
				} else if (tileentity instanceof AmericanSignalT121TileEntity){
					itemstack.stackTagCompound.setInteger("x", x);
					itemstack.stackTagCompound.setInteger("y", y);
					itemstack.stackTagCompound.setInteger("z", z);
				}
			}
		}
		return false;
	}				
		
		
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon("SirenMod:Screwdriver");
	}
}
