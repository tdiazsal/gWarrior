package com.perpixelperfectcollision;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.graphics.Bitmap;

public class PixelPerfectTiledTextureRegion extends TiledTextureRegion{
    protected PixelPerfectBitMask[] bitMasks;
    protected int tileCols;
    protected int tileRows;
    
    public PixelPerfectBitMask getMask(int idx){
        return bitMasks[idx];
    }
    
    public PixelPerfectTiledTextureRegion(Texture pTexture, IBitmapTextureAtlasSource textureSource,
                                     int pTexturePositionX, int pTexturePositionY, 
                                     int pWidth, int pHeight,
                                     int tileCols, int tileRows
                                     ) {
        super(pTexture, pTexturePositionX, pTexturePositionY, pWidth, pHeight, tileCols, tileRows);
        Bitmap bmp = textureSource.onLoadBitmap(Bitmap.Config.ARGB_4444);

        int tileWidth = pWidth / tileCols;
        int tileHeight = pHeight / tileRows;
        bitMasks = new PixelPerfectBitMask[tileRows * tileCols];
        for(int row=0; row<tileRows; row++){
            for(int col=0; col<tileCols; col++){
                bitMasks[row * tileCols + col] = new PixelPerfectBitMask(bmp, col * tileWidth, row * tileHeight, tileWidth, tileHeight);
            }
        }
    }
}
