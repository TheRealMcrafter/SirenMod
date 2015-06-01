package TheRealMcrafter.SirenMod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import TheRealMcrafter.SirenMod.common.SirenMod;

public class Speaker extends Item {
	
	public String textureName;
	
		public Speaker(String textureName){
			super();
			this.textureName = textureName;
			this.setCreativeTab(SirenMod.SirenModCreativeTab);
			setUnlocalizedName(textureName);
		}
		
		public void registerIcons(IIconRegister register){
			this.itemIcon = register.registerIcon("SirenMod:Speaker");
		}
	

}
