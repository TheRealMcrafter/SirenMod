package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BurglarSirenModel extends ModelBase {
	// fields
	ModelRenderer Main;
	ModelRenderer Main2;
	ModelRenderer BorderTop;
	ModelRenderer BorderBottom;
	ModelRenderer BorderRight;
	ModelRenderer BorderLeft;
	ModelRenderer Main3;

	public BurglarSirenModel() {
		textureWidth = 64;
		textureHeight = 32;

		Main = new ModelRenderer(this, 0, 7);
		Main.addBox(0F, 0F, 0F, 7, 7, 1);
		Main.setRotationPoint(-3.5F, 12F, 7F);
		Main.setTextureSize(64, 32);
		Main.mirror = true;
		setRotation(Main, 0F, 0F, 0F);
		Main2 = new ModelRenderer(this, 0, 0);
		Main2.addBox(0F, 0F, 0F, 3, 3, 1);
		Main2.setRotationPoint(-1.5F, 14F, 6F);
		Main2.setTextureSize(64, 32);
		Main2.mirror = true;
		setRotation(Main2, 0F, 0F, 0F);
		BorderTop = new ModelRenderer(this, 0, 0);
		BorderTop.addBox(0F, 0F, 0F, 2, 1, 1);
		BorderTop.setRotationPoint(-1F, 13.6F, 6F);
		BorderTop.setTextureSize(64, 32);
		BorderTop.mirror = true;
		setRotation(BorderTop, 0F, 0F, 0F);
		BorderBottom = new ModelRenderer(this, 0, 0);
		BorderBottom.addBox(0F, 0F, 0F, 2, 1, 1);
		BorderBottom.setRotationPoint(-1F, 16.5F, 6F);
		BorderBottom.setTextureSize(64, 32);
		BorderBottom.mirror = true;
		setRotation(BorderBottom, 0F, 0F, 0F);
		BorderRight = new ModelRenderer(this, 0, 0);
		BorderRight.addBox(0F, 0F, 0F, 1, 2, 1);
		BorderRight.setRotationPoint(1F, 14.5F, 6F);
		BorderRight.setTextureSize(64, 32);
		BorderRight.mirror = true;
		setRotation(BorderRight, 0F, 0F, 0F);
		BorderLeft = new ModelRenderer(this, 0, 0);
		BorderLeft.addBox(0F, 0F, 0F, 1, 2, 1);
		BorderLeft.setRotationPoint(-2F, 14.5F, 6F);
		BorderLeft.setTextureSize(64, 32);
		BorderLeft.mirror = true;
		setRotation(BorderLeft, 0F, 0F, 0F);
		Main3 = new ModelRenderer(this, 16, 7);
		Main3.addBox(0F, 0F, 0F, 5, 5, 1);
		Main3.setRotationPoint(-2.5F, 13F, 6.5F);
		Main3.setTextureSize(64, 32);
		Main3.mirror = true;
		setRotation(Main3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Main.render(f5);
		Main2.render(f5);
		BorderTop.render(f5);
		BorderBottom.render(f5);
		BorderRight.render(f5);
		BorderLeft.render(f5);
		Main3.render(f5);
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
