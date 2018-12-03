package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MountedSirenControllerModel extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Screen;
	ModelRenderer Case1;
	ModelRenderer Case3;
	ModelRenderer Case2;
	ModelRenderer ControlPanel;
	ModelRenderer TestButton;
	ModelRenderer ArmButton;
	ModelRenderer DisarmButton;

	public MountedSirenControllerModel() {
		textureWidth = 128;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 14, 14, 1);
		Shape1.setRotationPoint(-7F, 9F, 7F);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Screen = new ModelRenderer(this, 31, 16);
		Screen.addBox(0F, 0F, 0F, 8, 4, 1);
		Screen.setRotationPoint(-4F, 12F, 6.2F);
		Screen.setTextureSize(128, 64);
		Screen.mirror = true;
		setRotation(Screen, 0F, 0F, 0F);
		Case1 = new ModelRenderer(this, 0, 0);
		Case1.addBox(0F, 0F, 0F, 14, 3, 1);
		Case1.setRotationPoint(-7F, 9F, 6F);
		Case1.setTextureSize(128, 64);
		Case1.mirror = true;
		setRotation(Case1, 0F, 0F, 0F);
		Case3 = new ModelRenderer(this, 22, 16);
		Case3.addBox(0F, 0F, 0F, 3, 11, 1);
		Case3.setRotationPoint(4F, 12F, 6F);
		Case3.setTextureSize(128, 64);
		Case3.mirror = true;
		setRotation(Case3, 0F, 0F, 0F);
		Case2 = new ModelRenderer(this, 0, 16);
		Case2.addBox(0F, 0F, 0F, 3, 11, 1);
		Case2.setRotationPoint(-7F, 12F, 6F);
		Case2.setTextureSize(128, 64);
		Case2.mirror = true;
		setRotation(Case2, 0F, 0F, 0F);
		ControlPanel = new ModelRenderer(this, 6, 29);
		ControlPanel.addBox(0F, 0F, 0F, 8, 7, 1);
		ControlPanel.setRotationPoint(-4F, 16F, 6F);
		ControlPanel.setTextureSize(128, 64);
		ControlPanel.mirror = true;
		setRotation(ControlPanel, 0F, 0F, 0F);
		TestButton = new ModelRenderer(this, 31, 4);
		TestButton.addBox(0F, 0F, 0F, 2, 1, 1);
		TestButton.setRotationPoint(1F, 19F, 5.5F);
		TestButton.setTextureSize(128, 64);
		TestButton.mirror = true;
		setRotation(TestButton, 0F, 0F, 0F);
		ArmButton = new ModelRenderer(this, 31, 7);
		ArmButton.addBox(0F, 0F, 0F, 2, 1, 1);
		ArmButton.setRotationPoint(1F, 20F, 5.5F);
		ArmButton.setTextureSize(128, 64);
		ArmButton.mirror = true;
		setRotation(ArmButton, 0F, 0F, 0F);
		DisarmButton = new ModelRenderer(this, 31, 0);
		DisarmButton.addBox(0F, 0F, 0F, 2, 1, 1);
		DisarmButton.setRotationPoint(1F, 18F, 5.5F);
		DisarmButton.setTextureSize(128, 64);
		DisarmButton.mirror = true;
		setRotation(DisarmButton, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Screen.render(f5);
		Case1.render(f5);
		Case3.render(f5);
		Case2.render(f5);
		ControlPanel.render(f5);
		TestButton.render(f5);
		ArmButton.render(f5);
		DisarmButton.render(f5);
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
