package com.commons;

import java.util.ArrayList;
import java.util.List;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLayer;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLoader;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXProperties;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXTile;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXTileProperty;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXTiledMap;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.anddev.andengine.entity.layer.tiled.tmx.util.exception.TMXLoadException;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;
import android.graphics.Typeface;

import com.perpixelperfectcollision.PixelPerfectTextureRegionFactory;
import com.perpixelperfectcollision.PixelPerfectTiledTextureRegion;

public class gameCommons {

	private static final int sprite_map_with=1024;
	private static final int sprite_map_height=1024;
	
	// Creamos variables para definir sobre que resolucion vamos a trabajar 
	public static int cCamera_width = 480;
	public static int cCamera_height = 320;
	
	// TAG que vamos a usar para los mensajes de Log que estan en DEBUG
	public static String cTag = "AndEngineTest";
	
	
	// Texto de Status 
	private static BitmapTextureAtlas cStatus_FontTexture;
	private static Font cStatus_t;
	public static ChangeableText cStatus;
	
	// Sprite Map al que concatenamos imagenes
	public static BitmapTextureAtlas WarriorAtlas = new BitmapTextureAtlas(sprite_map_with, sprite_map_height,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	public static BitmapTextureAtlas BackgroundAtlas = new BitmapTextureAtlas(sprite_map_with, sprite_map_height,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	
	public static PixelPerfectTiledTextureRegion loadToSpriteMap(BitmapTextureAtlas tAtlas,String tpath,int initial_posX_SpriteMap,int initial_posY_SpriteMap,int total_rows,int total_cols,BaseGameActivity oactivity)
	{   
		// Ponemos la relacion de imagenes de la animacion en el sprite map comun
		PixelPerfectTiledTextureRegion tTex= PixelPerfectTextureRegionFactory.createTiledFromAsset(tAtlas, oactivity, tpath,initial_posX_SpriteMap, initial_posY_SpriteMap, total_rows, total_cols);
	    return tTex;
	}
	
	public static void loadStatusArea(Engine tEngine)
	{
		// *** INICIALIZAMOS TEXTO DE STATUS EN PANTALLA ***/
        cStatus_FontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        cStatus_t = new Font(cStatus_FontTexture, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL ), 12, true, Color.WHITE );
        
        tEngine.getTextureManager().loadTexture(cStatus_FontTexture);
        tEngine.getFontManager().loadFont(cStatus_t);
        
        cStatus = new ChangeableText(10, 15, cStatus_t, "",100);
	}

}
