package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FireExtinguisherModel extends ModelBase
{
  //fields
    ModelRenderer Core;
    ModelRenderer Shell4;
    ModelRenderer Shell1;
    ModelRenderer Shell3;
    ModelRenderer Shell2;
    ModelRenderer Top;
    ModelRenderer Stem;
    ModelRenderer Nozzle;
    ModelRenderer Handle;
  
  public FireExtinguisherModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Core = new ModelRenderer(this, 21, 0);
      Core.addBox(0F, 0F, 0F, 4, 10, 4);
      Core.setRotationPoint(-2F, 14F, -2F);
      Core.setTextureSize(128, 64);
      Core.mirror = true;
      setRotation(Core, 0F, 0F, 0F);
      Shell4 = new ModelRenderer(this, 0, 39);
      Shell4.addBox(0F, 0F, 0F, 3, 10, 1);
      Shell4.setRotationPoint(-1.5F, 14F, 1.1F);
      Shell4.setTextureSize(128, 64);
      Shell4.mirror = true;
      setRotation(Shell4, 0F, 0F, 0F);
      Shell1 = new ModelRenderer(this, 0, 25);
      Shell1.addBox(0F, 0F, 0F, 1, 10, 3);
      Shell1.setRotationPoint(1.1F, 14F, -1.5F);
      Shell1.setTextureSize(128, 64);
      Shell1.mirror = true;
      setRotation(Shell1, 0F, 0F, 0F);
      Shell3 = new ModelRenderer(this, 0, 51);
      Shell3.addBox(0F, 0F, 0F, 1, 10, 3);
      Shell3.setRotationPoint(-2.1F, 14F, -1.5F);
      Shell3.setTextureSize(128, 64);
      Shell3.mirror = true;
      setRotation(Shell3, 0F, 0F, 0F);
      Shell2 = new ModelRenderer(this, 0, 13);
      Shell2.addBox(0F, 0F, 0F, 3, 10, 1);
      Shell2.setRotationPoint(-1.5F, 14F, -2.1F);
      Shell2.setTextureSize(128, 64);
      Shell2.mirror = true;
      setRotation(Shell2, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 0, 8);
      Top.addBox(0F, 0F, 0F, 3, 1, 3);
      Top.setRotationPoint(-1.5F, 13.5F, -1.5F);
      Top.setTextureSize(128, 64);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      Stem = new ModelRenderer(this, 0, 3);
      Stem.addBox(0F, 0F, 0F, 1, 3, 1);
      Stem.setRotationPoint(-0.5F, 11F, -0.5F);
      Stem.setTextureSize(128, 64);
      Stem.mirror = true;
      setRotation(Stem, 0F, 0F, 0F);
      Nozzle = new ModelRenderer(this, 11, 0);
      Nozzle.addBox(0F, 0F, 0F, 3, 1, 1);
      Nozzle.setRotationPoint(-0.5F, 11.5F, -0.5F);
      Nozzle.setTextureSize(128, 64);
      Nozzle.mirror = true;
      setRotation(Nozzle, 0F, 0F, 0F);
      Handle = new ModelRenderer(this, 0, 0);
      Handle.addBox(-3F, 0F, 0F, 3, 1, 1);
      Handle.setRotationPoint(-0.5F, 11.5F, -0.5F);
      Handle.setTextureSize(128, 64);
      Handle.mirror = true;
      setRotation(Handle, 0F, 0F, -0.3839724F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Core.render(f5);
    Shell4.render(f5);
    Shell1.render(f5);
    Shell3.render(f5);
    Shell2.render(f5);
    Top.render(f5);
    Stem.render(f5);
    Nozzle.render(f5);
    Handle.render(f5);
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
