package TheRealMcrafter.SirenMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import TheRealMcrafter.SirenMod.TileEntity.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.models.GeneralSirenModel;

public class GeneralSirenRenderer extends TileEntitySpecialRenderer {

	// Block Model
	private final GeneralSirenModel model;

	public GeneralSirenRenderer() {
		this.model = new GeneralSirenModel();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		int meta = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);

		if (meta == 5)
			meta = 1;
		else if (meta == 2)
			meta = 0;
		if (meta == 4)
			meta = 3;
		else if (meta == 3)
			meta = 2;
		GL11.glRotatef(90 * meta, 0F, 1F, 0F);

		tileentity.getWorldObj().scheduleBlockUpdate((int) tileentity.xCoord, (int) tileentity.yCoord,
				(int) tileentity.zCoord, tileentity.getBlockType(), 10);

		if (((GeneralSirenTileEntity) tileentity).getColor().equals("lightGray")) {
			ResourceLocation textures = (new ResourceLocation("SirenMod:textures/blocks/SirenModelLightGrey.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("black")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelBlack.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("white")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelWhite.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("blue")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelBlue.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("cyan")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelCyan.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("purple")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelPurple.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("lightBlue")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelLightBlue.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("magenta")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelMagenta.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("yellow")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelYellow.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("orange")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelOrange.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("green")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelGreen.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("lime")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelLime.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("brown")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelBrown.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("gray")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelGrey.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("red")) {
			ResourceLocation textures = (new ResourceLocation("SirenMod:textures/blocks/SirenModelRed.png"));
			this.bindTexture(textures);
		} else if (((GeneralSirenTileEntity) tileentity).getColor().equals("pink")) {
			ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/SirenModelPink.png"));
			this.bindTexture(textures);
		} else {
		}

		((GeneralSirenTileEntity) tileentity).updateClientTileEntity();
		model.RotorLeft.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.RotorRight.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel1.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel2.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel3.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel4.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel5.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel6.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel7.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();
		model.Panel8.rotateAngleX = ((GeneralSirenTileEntity) tileentity).getRotation();

		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
		Tessellator tess = Tessellator.instance;
		float brightness = block.getLightValue(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
	}
}