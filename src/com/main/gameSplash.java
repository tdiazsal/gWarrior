package com.main;

import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.ui.activity.BaseSplashActivity;

import android.app.Activity;

public class gameSplash extends BaseSplashActivity {

	// define el numero de segundos del splash
	private static final int SPLASH_DURATION = 3;
	private static final float SPLASH_SCALE_FROM = 1f;
	
	@Override
	protected ScreenOrientation getScreenOrientation() 
	{
		//debemos devolver la orientación de la pantalla, en este caso es apaisada.
		return ScreenOrientation.LANDSCAPE;
	}

	@Override
    protected IBitmapTextureAtlasSource onGetSplashTextureAtlasSource() {
            return new AssetBitmapTextureAtlasSource(this, "images/splash.png");
    }
	
	@Override
	protected float getSplashDuration() 
	{
		//método getSplashDuration(), devolvemos la constante
		return SPLASH_DURATION;
	}

	//Ojo, porque esto no se ve bien aqui, dejadlo como Eclipse lo genera
	@Override
	protected Class<? extends Activity> getFollowUpActivity() 
	{
		//lo que debemos devolver es la Actividad que se va a ejecutar después del splash. En este caso main.
		return main.class ;
	}

	protected float getSplashScaleFrom() 
	{
		return SPLASH_SCALE_FROM;
	}

}
