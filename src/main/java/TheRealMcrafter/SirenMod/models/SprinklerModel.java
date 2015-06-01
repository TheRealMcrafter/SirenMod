package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SprinklerModel extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Pole;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
  
  public SprinklerModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 3, 1, 3);
      Base.setRotationPoint(-1.5F, 8F, -1.5F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Pole = new ModelRenderer(this, 0, 5);
      Pole.addBox(0F, 0F, 0F, 1, 3, 1);
      Pole.setRotationPoint(-0.5F, 8.2F, -0.5F);
      Pole.setTextureSize(128, 64);
      Pole.mirror = true;
      setRotation(Pole, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 6, 5);
      Arm1.addBox(0F, 0F, 0F, 2, 1, 1);
      Arm1.setRotationPoint(-0.5F, 10F, 1F);
      Arm1.setTextureSize(128, 64);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 1.570796F, 0F);
      Arm2 = new ModelRenderer(this, 6, 8);
      Arm2.addBox(0F, 0F, 0F, 2, 1, 1);
      Arm2.setRotationPoint(-1F, 10F, -0.5F);
      Arm2.setTextureSize(128, 64);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Pole.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
