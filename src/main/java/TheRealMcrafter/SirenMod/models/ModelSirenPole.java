package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSirenPole extends ModelBase{
	//fields
    ModelRenderer Pole;
  
    public ModelSirenPole(){
    	textureWidth = 64;
    	textureHeight = 32;
    
    	Pole = new ModelRenderer(this, 0, 0);
    	Pole.addBox(0F, 0F, 0F, 2, 16, 2);
    	Pole.setRotationPoint(-1F, 8F, -1F);
    	Pole.setTextureSize(64, 32);
    	Pole.mirror = true;
    	setRotation(Pole, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	Pole.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z){
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
  
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity){
    	super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
