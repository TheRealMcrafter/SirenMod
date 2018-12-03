package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MotionDetectorModel extends ModelBase {
	// fields
	ModelRenderer Plate;
	ModelRenderer Lens1;
	ModelRenderer Lens2;

	public MotionDetectorModel() {
		textureWidth = 128;
		textureHeight = 64;

		Plate = new ModelRenderer(this, 0, 0);
		Plate.addBox(0F, 0F, 0F, 4, 6, 1);
		Plate.setRotationPoint(-2F, 13F, 7F);
		Plate.setTextureSize(128, 64);
		Plate.mirror = true;
		setRotation(Plate, 0F, 0F, 0F);
		Lens1 = new ModelRenderer(this, 0, 8);
		Lens1.addBox(0F, 0F, 0F, 2, 2, 1);
		Lens1.setRotationPoint(-1F, 14F, 6.7F);
		Lens1.setTextureSize(128, 64);
		Lens1.mirror = true;
		setRotation(Lens1, 0F, 0F, 0F);
		Lens2 = new ModelRenderer(this, 0, 12);
		Lens2.addBox(0F, 0F, 0F, 1, 1, 1);
		Lens2.setRotationPoint(-0.5F, 14.5F, 6.3F);
		Lens2.setTextureSize(128, 64);
		Lens2.mirror = true;
		setRotation(Lens2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Plate.render(f5);
		Lens1.render(f5);
		Lens2.render(f5);
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
