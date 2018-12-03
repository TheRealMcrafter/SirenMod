package TheRealMcrafter.SirenMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import TheRealMcrafter.SirenMod.TileEntity.NuclearSirenTileEntity;
import TheRealMcrafter.SirenMod.models.NuclearSirenModel;

public class NuclearSirenRenderer extends TileEntitySpecialRenderer {

	// The model of your block
	final NuclearSirenModel model;

	public NuclearSirenRenderer() {
		this.model = new NuclearSirenModel();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef(270, 0F, 1F, 0F);

		IBlockState blockState = tileentity.getWorld().getBlockState(
				new BlockPos(tileentity.getPos().getX(), tileentity.getPos().getY(), tileentity.getPos().getZ()));
		int meta = blockState.getBlock().getMetaFromState(blockState);

		if (meta == 5)
			meta = 1;
		else if (meta == 2)
			meta = 0;
		if (meta == 4)
			meta = 3;
		else if (meta == 3)
			meta = 2;
		GL11.glRotatef(90 * meta, 0F, 1F, 0F);

		ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/NuclearSirenModel.png"));
		this.bindTexture(textures);

		((NuclearSirenTileEntity) tileentity).updateClientTileEntity();

		model.MainHub.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Hub.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece1.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece2.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece3.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece4.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece5.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece6.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece7.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece8.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece9.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece10.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece11.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece12.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();
		model.Piece13.rotateAngleY = ((NuclearSirenTileEntity) tileentity).getRotation();

		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
		Tessellator tess = Tessellator.getInstance();
		float brightness = block.getLightValue((IBlockAccess) block, new BlockPos(i, j, k));
		float skyLight = world.getLightBrightness(new BlockPos(i, j, k));
		float modulousModifier = skyLight % 65536;
		float divModifier = skyLight / 65536;
		tess.getWorldRenderer().setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
	}
}