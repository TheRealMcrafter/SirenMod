package TheRealMcrafter.SirenMod.client.audio;

import TheRealMcrafter.SirenMod.tiles.AmericanSignalT121TileEntity;
import TheRealMcrafter.SirenMod.tiles.BurglarSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.FireAlarmTileEntity;
import TheRealMcrafter.SirenMod.tiles.GeneralSirenTileEntity;
import TheRealMcrafter.SirenMod.tiles.NuclearSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooper extends MovingSound {
public TileEntity tile;


    public SirenLooper(TileEntity tile, String soundName){ 
        super(new ResourceLocation("SirenMod:" + soundName));  
        this.tile = tile;
        this.repeat = true; 
        if (tile instanceof NuclearSirenTileEntity){
            volume = 5.0F;
    	} else if (tile instanceof GeneralSirenTileEntity){
            volume = 10.0F;
    	} else if (tile instanceof BurglarSirenTileEntity){
            volume = 5.0F;
    	} else if (tile instanceof FireAlarmTileEntity){
            volume = 5.0F;
    	} else if (tile instanceof AmericanSignalT121TileEntity){
            volume = 20.0F;

    	} else {
            volume = 5.0F;
    	}
        this.xPosF = tile.xCoord;
        this.yPosF = tile.yCoord;
        this.zPosF = tile.zCoord;
    }


    public void update(){ 
    	if (tile instanceof GeneralSirenTileEntity){
    		if (((GeneralSirenTileEntity) tile).isShouldStop() || ((GeneralSirenTileEntity) tile).isInvalid()){  
                this.donePlaying = true;}
    	} else if (tile instanceof NuclearSirenTileEntity){
    		if (((NuclearSirenTileEntity) tile).isShouldStop() || ((NuclearSirenTileEntity) tile).isInvalid()){    
                this.donePlaying = true;}
    	} else if (tile instanceof BurglarSirenTileEntity){
    		if (((BurglarSirenTileEntity) tile).isShouldStop() || ((BurglarSirenTileEntity) tile).isInvalid()){    
                this.donePlaying = true;}
    	} else if (tile instanceof FireAlarmTileEntity){
    		if (((FireAlarmTileEntity) tile).isShouldStop() || ((FireAlarmTileEntity) tile).isInvalid()){    
                this.donePlaying = true;}
    	} else if (tile instanceof AmericanSignalT121TileEntity){
    		if (((AmericanSignalT121TileEntity) tile).isShouldStop() || ((AmericanSignalT121TileEntity) tile).isInvalid()){    
                this.donePlaying = true;}
    	} else {
    		throw new ClassCastException();
    	}   
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}