package TheRealMcrafter.SirenMod.client.audio;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;

public class SirenLooperFireAlarm extends MovingSound {
    private final TileEntity tileentity;
    private FireAlarmTileEntity tileFire; 


    public SirenLooperFireAlarm(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenFire")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileFire = (FireAlarmTileEntity) tileentity;
    }


    public void update(){  
        if (tileFire.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}