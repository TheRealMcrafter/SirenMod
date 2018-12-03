package TheRealMcrafter.SirenMod.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class IntegratedCircuit extends Item {

	public String textureName;

	public IntegratedCircuit(String textureName) {
		super();
		this.textureName = textureName;
		final String name = textureName;
		GameRegistry.registerItem(this, name);
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}
}
