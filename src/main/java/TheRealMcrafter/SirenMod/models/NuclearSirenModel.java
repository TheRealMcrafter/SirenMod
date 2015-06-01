package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NuclearSirenModel extends ModelBase
{
  //fields
	public ModelRenderer Base;
	public ModelRenderer Pole;
    public ModelRenderer MainHub;
    public ModelRenderer Piece1;
    public ModelRenderer Hub;
    public ModelRenderer Piece2;
    public ModelRenderer Piece3;
    public ModelRenderer Piece4;
    public ModelRenderer Piece5;
    public ModelRenderer Piece6;
    public ModelRenderer Piece7;
    public ModelRenderer Piece8;
    public ModelRenderer Piece9;
    public ModelRenderer Piece10;
    public ModelRenderer Piece11;
    public ModelRenderer Piece12;
    public ModelRenderer Piece13;
  
  public NuclearSirenModel(){
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 20, 58);
      Base.addBox(0F, 0F, 0F, 4, 2, 4);
      Base.setRotationPoint(-2F, 22F, -2F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Pole = new ModelRenderer(this, 0, 34);
      Pole.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      Pole.setRotationPoint(0F, 18F, 0F);
      Pole.setTextureSize(64, 64);
      Pole.mirror = true;
      setRotation(Pole, 0F, 0F, 0F);
      MainHub = new ModelRenderer(this, 6, 57);
      MainHub.addBox(-1.5F, -1.5F, -1.5F, 3, 4, 3);
      MainHub.setRotationPoint(0F, 16.5F, 0F);
      MainHub.setTextureSize(64, 64);
      MainHub.mirror = true;
      setRotation(MainHub, 0F, 0F, 0F);
      Piece1 = new ModelRenderer(this, 0, 0);
      Piece1.addBox(-4.5F, -2F, 2.5F, 1, 5, 1);
      Piece1.setRotationPoint(0F, 16.5F, 0F);
      Piece1.setTextureSize(64, 64);
      Piece1.mirror = true;
      setRotation(Piece1, 0F, 0F, 0F);
      Hub = new ModelRenderer(this, 0, 0);
      Hub.addBox(-2.5F, -1.5F, -1.5F, 1, 3, 3);
      Hub.setRotationPoint(0F, 17F, 0F);
      Hub.setTextureSize(64, 64);
      Hub.mirror = true;
      setRotation(Hub, 0F, 0F, 0F);
      Piece2 = new ModelRenderer(this, 0, 0);
      Piece2.addBox(-3.5F, -2F, -2.5F, 1, 5, 5);
      Piece2.setRotationPoint(0F, 16.5F, 0F);
      Piece2.setTextureSize(64, 64);
      Piece2.mirror = true;
      setRotation(Piece2, 0F, 0F, 0F);
      Piece3 = new ModelRenderer(this, 0, 0);
      Piece3.addBox(-4.5F, -3F, -3.5F, 1, 1, 7);
      Piece3.setRotationPoint(0F, 16.5F, 0F);
      Piece3.setTextureSize(64, 64);
      Piece3.mirror = true;
      setRotation(Piece3, 0F, 0F, 0F);
      Piece4 = new ModelRenderer(this, 0, 0);
      Piece4.addBox(-4.5F, 3F, -3.5F, 1, 1, 7);
      Piece4.setRotationPoint(0F, 16.5F, 0F);
      Piece4.setTextureSize(64, 64);
      Piece4.mirror = true;
      setRotation(Piece4, 0F, 0F, 0F);
      Piece5 = new ModelRenderer(this, 0, 0);
      Piece5.addBox(-4.5F, -2F, -3.5F, 1, 5, 1);
      Piece5.setRotationPoint(0F, 16.5F, 0F);
      Piece5.setTextureSize(64, 64);
      Piece5.mirror = true;
      setRotation(Piece5, 0F, 0F, 0F);
      Piece6 = new ModelRenderer(this, 0, 0);
      Piece6.addBox(-5.5F, -3F, 3.5F, 1, 7, 1);
      Piece6.setRotationPoint(0F, 16.5F, 0F);
      Piece6.setTextureSize(64, 64);
      Piece6.mirror = true;
      setRotation(Piece6, 0F, 0F, 0F);
      Piece7 = new ModelRenderer(this, 0, 0);
      Piece7.addBox(-7.5F, -4F, 4.5F, 2, 9, 1);
      Piece7.setRotationPoint(0F, 16.5F, 0F);
      Piece7.setTextureSize(64, 64);
      Piece7.mirror = true;
      setRotation(Piece7, 0F, 0F, 0F);
      Piece8 = new ModelRenderer(this, 0, 0);
      Piece8.addBox(-5.5F, 4F, -4.5F, 1, 1, 9);
      Piece8.setRotationPoint(0F, 16.5F, 0F);
      Piece8.setTextureSize(64, 64);
      Piece8.mirror = true;
      setRotation(Piece8, 0F, 0F, 0F);
      Piece9 = new ModelRenderer(this, 0, 0);
      Piece9.addBox(-5.5F, -3F, -4.5F, 1, 7, 1);
      Piece9.setRotationPoint(0F, 16.5F, 0F);
      Piece9.setTextureSize(64, 64);
      Piece9.mirror = true;
      setRotation(Piece9, 0F, 0F, 0F);
      Piece10 = new ModelRenderer(this, 0, 0);
      Piece10.addBox(-5.5F, -4F, -4.5F, 1, 1, 9);
      Piece10.setRotationPoint(0F, 16.5F, 0F);
      Piece10.setTextureSize(64, 64);
      Piece10.mirror = true;
      setRotation(Piece10, 0F, 0F, 0F);
      Piece11 = new ModelRenderer(this, 0, 0);
      Piece11.addBox(-7.5F, -5F, -4.5F, 2, 1, 9);
      Piece11.setRotationPoint(0F, 16.5F, 0F);
      Piece11.setTextureSize(64, 64);
      Piece11.mirror = true;
      setRotation(Piece11, 0F, 0F, 0F);
      Piece12 = new ModelRenderer(this, 0, 0);
      Piece12.addBox(-7.5F, 5F, -4.5F, 2, 1, 9);
      Piece12.setRotationPoint(0F, 16.5F, 0F);
      Piece12.setTextureSize(64, 64);
      Piece12.mirror = true;
      setRotation(Piece12, 0F, 0F, 0F);
      Piece13 = new ModelRenderer(this, 0, 0);
      Piece13.addBox(-7.5F, -4F, -5.5F, 2, 9, 1);
      Piece13.setRotationPoint(0F, 16.5F, 0F);
      Piece13.setTextureSize(64, 64);
      Piece13.mirror = true;
      setRotation(Piece13, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Pole.render(f5);
    MainHub.render(f5);
    Piece1.render(f5);
    Hub.render(f5);
    Piece2.render(f5);
    Piece3.render(f5);
    Piece4.render(f5);
    Piece5.render(f5);
    Piece6.render(f5);
    Piece7.render(f5);
    Piece8.render(f5);
    Piece9.render(f5);
    Piece10.render(f5);
    Piece11.render(f5);
    Piece12.render(f5);
    Piece13.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
