package TheRealMcrafter.SirenMod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class SiliconOre extends Block {

	public String textureName;
	public int bonus;

	public SiliconOre(String textureName) {
		super(Material.rock);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		this.setHarvestLevel("pickaxe", 1);

	}

	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_) {
		return (SirenMod.SiliconShard);
	}

	public int quantityDropped(Random par1Random) {

		int bonus = (int) (Math.random() * (4 - 0)) + 0;
		return (bonus + 3);
	}
}
