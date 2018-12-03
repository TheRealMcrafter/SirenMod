package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FireAlarmModel extends ModelBase {
	// fields
	public static ModelRenderer Shape1;
	public static ModelRenderer Shape2;
	public static ModelRenderer Shape3;
	public static ModelRenderer Shape4;
	public static ModelRenderer Shape5;
	public static ModelRenderer Shape6;

	public FireAlarmModel() {

		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 19, 8);
		Shape1.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape1.setRotationPoint(-2F, 13F, 7F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 2, 2);
		Shape2.addBox(-1F, -2F, 0F, 2, 2, 0);
		Shape2.setRotationPoint(0F, 17F, 7F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 19, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape3.setRotationPoint(1F, 13F, 7F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 12, 8);
		Shape4.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape4.setRotationPoint(-1F, 17F, 7F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 8, 0);
		Shape5.addBox(0F, 0F, 0F, 4, 6, 1);
		Shape5.setRotationPoint(-2F, 13F, 7.5F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 12, 12);
		Shape6.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape6.setRotationPoint(-1F, 13F, 7F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
