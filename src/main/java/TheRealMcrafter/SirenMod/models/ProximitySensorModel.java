package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ProximitySensorModel extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Pillar;
    ModelRenderer Face1;
    ModelRenderer Face2;
    ModelRenderer Face3;
    ModelRenderer Face4;
    ModelRenderer Cap;
  
  public ProximitySensorModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 16);
      Base.addBox(0F, 0F, 0F, 6, 1, 6);
      Base.setRotationPoint(-3F, 23F, -3F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Pillar = new ModelRenderer(this, 0, 9);
      Pillar.addBox(0F, 0F, 0F, 2, 4, 2);
      Pillar.setRotationPoint(-1F, 19F, -1F);
      Pillar.setTextureSize(128, 64);
      Pillar.mirror = true;
      setRotation(Pillar, 0F, 0F, 0F);
      Face1 = new ModelRenderer(this, 0, 0);
      Face1.addBox(-2F, 0F, 1F, 4, 3, 1);
      Face1.setRotationPoint(0F, 17F, 0F);
      Face1.setTextureSize(128, 64);
      Face1.mirror = true;
      setRotation(Face1, 0F, 0F, 0F);
      Face2 = new ModelRenderer(this, 0, 0);
      Face2.addBox(-2F, 0F, -2F, 4, 3, 1);
      Face2.setRotationPoint(0F, 17F, 0F);
      Face2.setTextureSize(128, 64);
      Face2.mirror = true;
      setRotation(Face2, 0F, 0F, 0F);
      Face3 = new ModelRenderer(this, 0, 0);
      Face3.addBox(-2F, 0F, 1F, 4, 3, 1);
      Face3.setRotationPoint(0F, 17F, 0F);
      Face3.setTextureSize(128, 64);
      Face3.mirror = true;
      setRotation(Face3, 0F, 1.570796F, 0F);
      Face4 = new ModelRenderer(this, 0, 0);
      Face4.addBox(-2F, 0F, 1F, 4, 3, 1);
      Face4.setRotationPoint(0F, 17F, 0F);
      Face4.setTextureSize(128, 64);
      Face4.mirror = true;
      setRotation(Face4, 0F, -1.570796F, 0F);
      Cap = new ModelRenderer(this, 0, 5);
      Cap.addBox(-1F, 0F, -1F, 2, 1, 2);
      Cap.setRotationPoint(0F, 17F, 0F);
      Cap.setTextureSize(128, 64);
      Cap.mirror = true;
      setRotation(Cap, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Pillar.render(f5);
    Face1.render(f5);
    Face2.render(f5);
    Face3.render(f5);
    Face4.render(f5);
    Cap.render(f5);
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
