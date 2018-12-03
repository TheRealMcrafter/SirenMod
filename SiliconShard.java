package TheRealMcrafter.SirenMod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class SiliconShard extends Item {

	public String textureName;

	public SiliconShard(String textureName) {
		super();
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}

	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon("sirenmod:SiliconShard");
	}

}
