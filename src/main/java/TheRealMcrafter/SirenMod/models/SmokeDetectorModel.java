package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SmokeDetectorModel extends ModelBase
{
  //fields
    ModelRenderer SmokeDetector;
  
  public SmokeDetectorModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      SmokeDetector = new ModelRenderer(this, 0, 0);
      SmokeDetector.addBox(0F, 0F, 0F, 3, 1, 3);
      SmokeDetector.setRotationPoint(-1.5F, 8F, -1.5F);
      SmokeDetector.setTextureSize(128, 64);
      SmokeDetector.mirror = true;
      setRotation(SmokeDetector, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    SmokeDetector.render(f5);
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
