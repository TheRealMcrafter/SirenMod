package TheRealMcrafter.SirenMod.TileEntity;

import net.minecraft.tileentity.TileEntity;

public interface ISirenTileEntity {

	public boolean getIsLinked();

	public void setIsLinked(boolean isLinked);

	public void playSound();

	public void updateClientTileEntity();

	public void setShouldStart(boolean shouldStart);

	public void setShouldStop(boolean shouldStop);

	public boolean isShouldStop();

	public boolean isPlaying();

}
