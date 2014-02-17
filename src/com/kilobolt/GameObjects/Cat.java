package com.kilobolt.GameObjects;


import com.badlogic.gdx.math.Vector2; 

public class Cat {

	private Vector2 mPosition; 
	private Vector2 mVelocity; 
	private Vector2 mAcceleration; 
	
	private float mRotation; 
	private int mWidth; 
	private int mHeight; 
	
	public Cat(float x, float y, int width, int height){ 
		this.mWidth = width; 
		this.mHeight = height; 
		mPosition = new Vector2(x,y); 
		mVelocity = new Vector2(0,0); 
		mAcceleration = new Vector2(0,460); 
	}
	
	public void update(float delta){ 
		mVelocity.add(mAcceleration.cpy().scl(delta)); 
		
		if (mVelocity.y > 200){ 
			mVelocity.y = 200; 
		}
		
		mPosition.add(mVelocity.cpy().scl(delta)); 
		
		
		// rotate counterclockwise
		if(mVelocity.y < 0){ 
			mRotation -= 600 * delta; 
			if(mRotation < -20){ 
				mRotation = -20; 
			}
		}
		
		// rotate clockwise
		if(isFalling()){ 
			mRotation += 480 * delta; 
			if (mRotation > 90){ 
				mRotation = 90; 
			}
		}
	
	}
	
	public boolean isFalling(){ 
		return mVelocity.y > 110; 
	}
	
	public boolean shouldntFlap(){ 
		return mVelocity.y > 70;
	}
	
	public void onClick() { 
		mVelocity.y = -140; 
	}
	
	public float getX() { 
		return mPosition.x; 
	}
	
	public float getY(){ 
		return mPosition.y; 
	}
	
	public float getWidth(){ 
		return mWidth; 
	}
	
	public float getHeight(){ 
		return mHeight; 
	}
	
	public float getRotation(){ 
		return mRotation; 
	}
	
	public String catString(){ 
		return "Width: " + this.mWidth + " height: " + this.mHeight; 
	}	

}
