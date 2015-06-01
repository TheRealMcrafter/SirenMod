package TheRealMcrafter.SirenMod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import TheRealMcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SiliconOre extends Block {

	public String textureName;
	public int bonus;


	public SiliconOre(String textureName){
		super(Material.rock);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setBlockName(textureName);
		this.setHarvestLevel("pickaxe", 1);
		
	}


	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return (SirenMod.SiliconShard);
    }

	public int quantityDropped(Random par1Random){
		
		int bonus = (int) (Math.random() * (4 - 0)) + 0;
		return (bonus + 3);
	}
	
	

public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("sirenmod:SiliconOre");
	}
}
