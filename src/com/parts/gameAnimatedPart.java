package com.parts;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.perpixelperfectcollision.IPixelPerfectShape;
import com.perpixelperfectcollision.PixelPerfectBitMask;

public class gameAnimatedPart extends AnimatedSprite implements IPixelPerfectShape{

	public PhysicsHandler oPhysicsHandler;
	
	public gameAnimatedPart(float pX, float pY,int tZ,TiledTextureRegion pTiledTextureRegion) {
		super(pX, pY, pTiledTextureRegion);
		this.setZIndex(tZ);
		//**************** VELOCITAT INICIAL ***********************
	    oPhysicsHandler = new PhysicsHandler(this);
		this.registerUpdateHandler(oPhysicsHandler);
		this.oPhysicsHandler.setVelocity(0);
	}

	// Iteracion en classe
	@Override
    protected void onManagedUpdate(final float pSecondsElapsed) {
		if (!this.isAnimationRunning())
		{
		   	this.animate(50, true);
		}    
        super.onManagedUpdate(pSecondsElapsed);
    }
	
	public PixelPerfectBitMask getMask() {
		// TODO Auto-generated method stub
		return null;
	}


}
