package TheRealMcrafter.SirenMod.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class Speaker extends Item {

	public String textureName;
	private final String name = textureName;

	public Speaker(String textureName) {
		super();
		this.textureName = textureName;
		GameRegistry.registerItem(this, name);
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);

	}

}
