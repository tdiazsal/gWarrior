package com.parts;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.perpixelperfectcollision.IPixelPerfectShape;
import com.perpixelperfectcollision.PixelPerfectBitMask;

public class gameSpritePart extends Sprite implements IPixelPerfectShape{
	
	public PhysicsHandler oPhysicsHandler;
	
	public gameSpritePart(float pX, float pY,int tZ, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		this.setZIndex(tZ);
	
		//**************** VELOCITAT INICIAL ***********************
	    oPhysicsHandler = new PhysicsHandler(this);
		this.registerUpdateHandler(oPhysicsHandler);
		this.oPhysicsHandler.setVelocity(0);
		
	}

	public PixelPerfectBitMask getMask() {
		// TODO Auto-generated method stub
		return null;
	}

}
