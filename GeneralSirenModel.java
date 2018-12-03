package TheRealMcrafter.SirenMod.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class GeneralSirenModel extends ModelBase {
	// fields
	public ModelRenderer PedestalOne;
	public ModelRenderer PedestalTwo;
	public ModelRenderer PedestalThree;
	public ModelRenderer Stator;
	public ModelRenderer RotorLeft;
	public ModelRenderer RotorRight;
	public ModelRenderer Panel1;
	public ModelRenderer Panel2;
	public ModelRenderer Panel3;
	public ModelRenderer Panel4;
	public ModelRenderer Panel5;
	public ModelRenderer Panel6;
	public ModelRenderer Panel7;
	public ModelRenderer Panel8;

	public GeneralSirenModel() {
		textureWidth = 128;
		textureHeight = 32;

		PedestalOne = new ModelRenderer(this, 31, 11);
		PedestalOne.addBox(0F, 0F, 0F, 11, 2, 11);
		PedestalOne.setRotationPoint(-5.5F, 22F, -5.5F);
		PedestalOne.setTextureSize(128, 32);
		PedestalOne.mirror = true;
		setRotation(PedestalOne, 0F, 0F, 0F);
		PedestalTwo = new ModelRenderer(this, 30, 0);
		PedestalTwo.addBox(0F, 0F, 0F, 8, 2, 8);
		PedestalTwo.setRotationPoint(-4F, 21F, -4F);
		PedestalTwo.setTextureSize(128, 32);
		PedestalTwo.mirror = true;
		setRotation(PedestalTwo, 0F, 0F, 0F);
		PedestalThree = new ModelRenderer(this, 0, 21);
		PedestalThree.addBox(0F, 0F, 0F, 2, 4, 2);
		PedestalThree.setRotationPoint(-1F, 17F, -1F);
		PedestalThree.setTextureSize(128, 32);
		PedestalThree.mirror = true;
		setRotation(PedestalThree, 0F, 0F, 0F);
		Stator = new ModelRenderer(this, 9, 7);
		Stator.addBox(0F, 0F, 0F, 7, 3, 3);
		Stator.setRotationPoint(-3.5F, 16F, -1.5F);
		Stator.setTextureSize(128, 32);
		Stator.mirror = true;
		setRotation(Stator, 0F, 0F, 0F);
		RotorLeft = new ModelRenderer(this, 13, 0);
		RotorLeft.addBox(0F, -1.5F, -1.5F, 3, 3, 3);
		RotorLeft.setRotationPoint(-5F, 17.5F, 0F);
		RotorLeft.setTextureSize(128, 32);
		RotorLeft.mirror = true;
		setRotation(RotorLeft, 0F, 0F, 0F);
		RotorRight = new ModelRenderer(this, 13, 0);
		RotorRight.addBox(-3F, -1.5F, -1.5F, 3, 3, 3);
		RotorRight.setRotationPoint(5F, 17.5F, 0F);
		RotorRight.setTextureSize(128, 32);
		RotorRight.mirror = true;
		setRotation(RotorRight, 0F, 0F, 0F);
		Panel1 = new ModelRenderer(this, 0, 0);
		Panel1.addBox(0F, -2.5F, -1.5F, 3, 1, 3);
		Panel1.setRotationPoint(-5F, 17.5F, 0F);
		Panel1.setTextureSize(128, 32);
		Panel1.mirror = true;
		setRotation(Panel1, 0F, 0F, 0F);
		Panel2 = new ModelRenderer(this, 0, 15);
		Panel2.addBox(0F, 1.5F, -1.5F, 3, 1, 3);
		Panel2.setRotationPoint(-5F, 17.5F, 0F);
		Panel2.setTextureSize(128, 32);
		Panel2.mirror = true;
		setRotation(Panel2, 0F, 0F, 0F);
		Panel3 = new ModelRenderer(this, 0, 5);
		Panel3.addBox(0F, -1.5F, 1.5F, 3, 3, 1);
		Panel3.setRotationPoint(-5F, 17.5F, 0F);
		Panel3.setTextureSize(128, 32);
		Panel3.mirror = true;
		setRotation(Panel3, 0F, 0F, 0F);
		Panel4 = new ModelRenderer(this, 0, 10);
		Panel4.addBox(0F, -1.5F, -2.5F, 3, 3, 1);
		Panel4.setRotationPoint(-5F, 17.5F, 0F);
		Panel4.setTextureSize(128, 32);
		Panel4.mirror = true;
		setRotation(Panel4, 0F, 0F, 0F);
		Panel5 = new ModelRenderer(this, 0, 0);
		Panel5.addBox(-3F, -2.5F, -1.5F, 3, 1, 3);
		Panel5.setRotationPoint(5F, 17.5F, 0F);
		Panel5.setTextureSize(128, 32);
		Panel5.mirror = true;
		setRotation(Panel5, 0F, 0F, 0F);
		Panel6 = new ModelRenderer(this, 0, 15);
		Panel6.addBox(-3F, 1.5F, -1.5F, 3, 1, 3);
		Panel6.setRotationPoint(5F, 17.5F, 0F);
		Panel6.setTextureSize(128, 32);
		Panel6.mirror = true;
		setRotation(Panel6, 0F, 0F, 0F);
		Panel7 = new ModelRenderer(this, 0, 5);
		Panel7.addBox(-3F, -1.5F, 1.5F, 3, 3, 1);
		Panel7.setRotationPoint(5F, 17.5F, 0F);
		Panel7.setTextureSize(128, 32);
		Panel7.mirror = true;
		setRotation(Panel7, 0F, 0F, 0F);
		Panel8 = new ModelRenderer(this, 0, 10);
		Panel8.addBox(-3F, -1.5F, -2.5F, 3, 3, 1);
		Panel8.setRotationPoint(5F, 17.5F, 0F);
		Panel8.setTextureSize(128, 32);
		Panel8.mirror = true;
		setRotation(Panel8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		PedestalOne.render(f5);
		PedestalTwo.render(f5);
		PedestalThree.render(f5);
		Stator.render(f5);
		RotorLeft.render(f5);
		RotorRight.render(f5);
		Panel1.render(f5);
		Panel2.render(f5);
		Panel3.render(f5);
		Panel4.render(f5);
		Panel5.render(f5);
		Panel6.render(f5);
		Panel7.render(f5);
		Panel8.render(f5);
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
