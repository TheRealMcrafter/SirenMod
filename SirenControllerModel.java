package TheRealMcrafter.SirenMod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SirenControllerModel extends ModelBase {
	// fields
	ModelRenderer KeypadAndCase;
	ModelRenderer BackCaseAndTop;
	ModelRenderer MainScreen;
	ModelRenderer RightPanel;
	ModelRenderer LeftPanel;
	ModelRenderer TestButton;
	ModelRenderer ArmButton;
	ModelRenderer DisarmButton;

	public SirenControllerModel() {
		textureWidth = 128;
		textureHeight = 64;

		KeypadAndCase = new ModelRenderer(this, 64, 36);
		KeypadAndCase.addBox(0F, 0F, 0F, 16, 12, 16);
		KeypadAndCase.setRotationPoint(-8F, 12F, -8F);
		KeypadAndCase.setTextureSize(128, 64);
		KeypadAndCase.mirror = true;
		setRotation(KeypadAndCase, 0F, 0F, 0F);
		BackCaseAndTop = new ModelRenderer(this, 84, 13);
		BackCaseAndTop.addBox(0F, 0F, 0F, 16, 16, 6);
		BackCaseAndTop.setRotationPoint(-8F, 8F, 2F);
		BackCaseAndTop.setTextureSize(128, 64);
		BackCaseAndTop.mirror = true;
		setRotation(BackCaseAndTop, 0F, 0F, 0F);
		MainScreen = new ModelRenderer(this, 0, 57);
		MainScreen.addBox(0F, -13F, 0F, 16, 7, 1);
		MainScreen.setRotationPoint(-8F, 15.95F, -8F);
		MainScreen.setTextureSize(128, 64);
		MainScreen.mirror = true;
		setRotation(MainScreen, -0.9599311F, 0F, 0F);
		RightPanel = new ModelRenderer(this, 46, 0);
		RightPanel.addBox(0F, 0F, 0F, 1, 12, 6);
		RightPanel.setRotationPoint(7F, 8F, 2F);
		RightPanel.setTextureSize(128, 64);
		RightPanel.mirror = true;
		setRotation(RightPanel, -0.9599311F, 0F, 0F);
		LeftPanel = new ModelRenderer(this, 30, 0);
		LeftPanel.addBox(0F, 0F, 0F, 1, 12, 6);
		LeftPanel.setRotationPoint(-8F, 8F, 2F);
		LeftPanel.setTextureSize(128, 64);
		LeftPanel.mirror = true;
		setRotation(LeftPanel, -0.9599311F, 0F, 0F);
		TestButton = new ModelRenderer(this, 0, 0);
		TestButton.addBox(0F, 0F, 0F, 2, 2, 2);
		TestButton.setRotationPoint(-1F, 11.5F, -6F);
		TestButton.setTextureSize(128, 64);
		TestButton.mirror = true;
		setRotation(TestButton, 0F, 0F, 0F);
		ArmButton = new ModelRenderer(this, 0, 7);
		ArmButton.addBox(0F, 0F, 0F, 1, 1, 2);
		ArmButton.setRotationPoint(4F, 11.5F, -6F);
		ArmButton.setTextureSize(128, 64);
		ArmButton.mirror = true;
		setRotation(ArmButton, 0F, 0F, 0F);
		DisarmButton = new ModelRenderer(this, 0, 4);
		DisarmButton.addBox(0F, 0F, 0F, 1, 1, 2);
		DisarmButton.setRotationPoint(-5F, 11.5F, -6F);
		DisarmButton.setTextureSize(128, 64);
		DisarmButton.mirror = true;
		setRotation(DisarmButton, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		KeypadAndCase.render(f5);
		BackCaseAndTop.render(f5);
		MainScreen.render(f5);
		RightPanel.render(f5);
		LeftPanel.render(f5);
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
