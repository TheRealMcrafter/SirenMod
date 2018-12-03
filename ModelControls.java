package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelControls extends ModelBase {
	// fields
	ModelRenderer Base;
	ModelRenderer Button1;
	ModelRenderer Button3;
	ModelRenderer Button2;

	public ModelControls() {
		textureWidth = 64;
		textureHeight = 32;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(0F, 0F, 0F, 8, 1, 4);
		Base.setRotationPoint(-4F, 23F, -2F);
		Base.setTextureSize(64, 32);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Button1 = new ModelRenderer(this, 0, 7);
		Button1.addBox(5.5F, -0.2F, 1F, 2, 1, 2);
		Button1.setRotationPoint(-4F, 23F, -2F);
		Button1.setTextureSize(64, 32);
		Button1.mirror = true;
		setRotation(Button1, 0F, 0F, 0F);
		Button3 = new ModelRenderer(this, 18, 7);
		Button3.addBox(0.5F, -0.2F, 1F, 2, 1, 2);
		Button3.setRotationPoint(-4F, 23F, -2F);
		Button3.setTextureSize(64, 32);
		Button3.mirror = true;
		setRotation(Button3, 0F, 0F, 0F);
		Button2 = new ModelRenderer(this, 9, 7);
		Button2.addBox(3F, -0.2F, 1F, 2, 1, 2);
		Button2.setRotationPoint(-4F, 23F, -2F);
		Button2.setTextureSize(64, 32);
		Button2.mirror = true;
		setRotation(Button2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base.render(f5);
		Button1.render(f5);
		Button3.render(f5);
		Button2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
