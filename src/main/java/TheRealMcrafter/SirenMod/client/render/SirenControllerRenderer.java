package TheRealMcrafter.SirenMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import TheRealMcrafter.SirenMod.models.MountedSirenControllerModel;
import TheRealMcrafter.SirenMod.models.SirenControllerModel;
import TheRealMcrafter.SirenMod.tiles.SirenControllerTileEntity;

public class SirenControllerRenderer extends TileEntitySpecialRenderer {
    
    //The model of your block
    private final SirenControllerModel model;
    private final MountedSirenControllerModel mounted;
    
    
    public SirenControllerRenderer() {
            this.model = new SirenControllerModel();
            this.mounted = new MountedSirenControllerModel();
            

    }
    
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
    {
       GL11.glPushMatrix();
       GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
       GL11.glRotatef(180, 0F, 0F, 1F);

       int meta = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);	   
       
       if (meta==5) meta = 1;
          else if (meta==2) meta=0; 
       if (meta==4) meta = 3;
          else if (meta==3) meta=2;
       GL11.glRotatef(90 * meta, 0F, 1F, 0F);
       
       
       tileentity.getWorldObj().scheduleBlockUpdate((int)tileentity.xCoord, (int)tileentity.yCoord, (int)tileentity.zCoord, tileentity.getBlockType(), 20);       

       
       SirenControllerTileEntity tile = (SirenControllerTileEntity) tileentity;
       
       
       if (tile.getRenderValue() == 0){
    	   if (tile.state.equals("")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenController/SirenControllerNoSiren.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("red")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenController/SirenControllerDisarmed.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("green")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenController/SirenControllerArmed.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("blue")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenController/SirenControllerTesting.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("waiting")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenController/SirenControllerWaiting.png"));
    		   this.bindTexture(textures);
    	   }
    	   
    	   this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
       } else if (tile.getRenderValue() == 1) {
    	   if (tile.state.equals("")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/MountedSirenController/MountedSirenControllerNoSiren.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("red")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/MountedSirenController/MountedSirenControllerDisarmed.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("green")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/MountedSirenController/MountedSirenControllerArmed.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("blue")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/MountedSirenController/MountedSirenControllerTesting.png"));
        	   this.bindTexture(textures);
    	   } else if (tile.state.equals("waiting")){
    		   ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/MountedSirenController/MountedSirenControllerWaiting.png"));
        	   this.bindTexture(textures);
    	   }
    	   
    	   this.mounted.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
       }
       
       GL11.glPopMatrix();
    }
    
      
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
            Tessellator tess = Tessellator.instance;
            float brightness = block.getLightValue(world, i, j, k);
            int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int modulousModifier = skyLight % 65536;
            int divModifier = skyLight / 65536;
            tess.setColorOpaque_F(brightness, brightness, brightness);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }
}
