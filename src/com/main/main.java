package com.main;



//import javax.imageio.ImageIO;


import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.ZoomCamera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.input.touch.detector.ScrollDetector;
import org.anddev.andengine.input.touch.detector.SurfaceScrollDetector;
import org.anddev.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.entity.sprite.Sprite;

import com.commons.gameCommons;
import com.models.gamePlayer;
import com.parts.gameAnimatedPart;

public class main extends BaseGameActivity implements IScrollDetectorListener, IOnSceneTouchListener  {

	private ZoomCamera mCamera;
	private Sprite background;
	private gamePlayer singlePlayer;
	
	private long startTime=System.currentTimeMillis();
	
	// Definicion de objetos del motor AndEngine
	public Engine onLoadEngine() 
	{	
		
		this.mCamera = new ZoomCamera(0, 0, gameCommons.cCamera_width , gameCommons.cCamera_height );
		this.mCamera.setBounds(0, gameCommons.cCamera_width, 0, gameCommons.cCamera_height);
		this.mCamera.setBoundsEnabled(true);
		
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(gameCommons.cCamera_width , gameCommons.cCamera_height ), this.mCamera).setNeedsMusic(true).setNeedsSound(true));
	}

	// Carga i asignacion de texturas i objetos.
	public void onLoadResources() {

		gameCommons.loadStatusArea(this.mEngine);
		
		TextureRegion TBackground = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameCommons.BackgroundAtlas, this,"images/background.png", 0, 0); // 1024x640
		background = new Sprite(0,0,TBackground);
		
		// Crear personaje con cuerpo
		singlePlayer = new gamePlayer(0,220,130,"warrior",gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_body.png", 0, 0, 7, 1, this)); //448x64
		
		// Adds parts
		singlePlayer.parts.add(new gameAnimatedPart(singlePlayer.body.getX(),singlePlayer.body.getY(),7,gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_helmet.png", 449, 0, 7, 1, this)));
		singlePlayer.parts.add(new gameAnimatedPart(singlePlayer.body.getX(),singlePlayer.body.getY(),6,gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_armour.png", 0, 65, 7, 1, this)));
		singlePlayer.parts.add(new gameAnimatedPart(singlePlayer.body.getX(),singlePlayer.body.getY(),6,gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_pants.png", 449, 65, 7, 1, this)));
		singlePlayer.parts.add(new gameAnimatedPart(singlePlayer.body.getX(),singlePlayer.body.getY(),8,gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_shield.png", 0, 130, 7, 1, this)));
		singlePlayer.parts.add(new gameAnimatedPart(singlePlayer.body.getX(),singlePlayer.body.getY(),7,gameCommons.loadToSpriteMap(gameCommons.WarriorAtlas,"images/warrior_belt.png", 449, 130, 7, 1, this)));
		
		
		this.mEngine.getTextureManager().loadTextures(gameCommons.WarriorAtlas,gameCommons.BackgroundAtlas);
		
	}

	public Scene onLoadScene() {
		
        this.mEngine.registerUpdateHandler(new FPSLogger());
		
		//*** Iniciamos escena ***//
		@SuppressWarnings("deprecation")
		final Scene scene = new Scene(1);	
        
		// Asignamos color de fondo
        scene.setBackground(new ColorBackground(0, 0, 0.8784f));
		
		// Background
		scene.attachChild(background);
		// Texto de status
		scene.getLastChild().attachChild(gameCommons.cStatus);
		
		
		// Por todas las partes del Single player ....
		for (gameAnimatedPart curr_part : singlePlayer.parts)
    	{
			scene.getLastChild().attachChild(curr_part);
    	}
		
		// Ordena por layers
		scene.getLastChild().sortChildren();
        
        return scene;
	}


	public void onLoadComplete() 
	{
    	// Añadimos todos los objetos en pantalla
		final Scene scene = this.mEngine.getScene();
		
		scene.registerUpdateHandler(new IUpdateHandler() 
        {

			public void onUpdate(float pSecondsElapsed) {
				
				 singlePlayer.move(40);
				 
				 if (System.currentTimeMillis() - startTime >= 200 ) 
		    	    {
						singlePlayer.rotate(20);
		    	        startTime=System.currentTimeMillis();
		    	    }				 
			}

			public void reset() {
			}
        });
	}

	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onScroll(ScrollDetector pScollDetector, TouchEvent pTouchEvent,
			float pDistanceX, float pDistanceY) {
		// TODO Auto-generated method stub
		
	}


}
