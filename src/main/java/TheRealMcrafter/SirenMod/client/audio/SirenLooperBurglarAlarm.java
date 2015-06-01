package TheRealMcrafter.SirenMod.client.audio;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;

public class SirenLooperBurglarAlarm extends MovingSound {
    private final TileEntity tileentity;
    private BurglarSirenTileEntity tileBurglar; 


    public SirenLooperBurglarAlarm(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenBurglar")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileBurglar = (BurglarSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileBurglar.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}