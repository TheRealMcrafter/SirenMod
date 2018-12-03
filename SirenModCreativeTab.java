package TheRealMcrafter.SirenMod.CreativeTabs;

//Imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import TheRealMcrafter.SirenMod.common.SirenMod;

public final class SirenModCreativeTab extends CreativeTabs {

	public SirenModCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.dirt);
	}

	public String getTranslatedTabLabel() {
		return "TheRealMcrafter's Siren Mod";
	}

}