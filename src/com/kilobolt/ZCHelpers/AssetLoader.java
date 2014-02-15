package com.kilobolt.ZCHelpers;

import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.graphics.Texture; 
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	// full of static methods and instances
	// i.e. we will not be creating instances, 
	//      there will be only one copy
	
	public static Texture mTexture; 
	public static TextureRegion mBg, mGrass; 
	
	public static Animation mCatAnimation; 
	public static TextureRegion mCat, mCatDown, mCatUp; 
	
	public static TextureRegion mSkullUp, mSkullDown, mBar; 
	
	public static void load() { 
		
		System.out.println("AssetLoader load!");
		
		mTexture = new Texture(Gdx.files.internal("data/texture.png")); 
		
		// sets the minification / magnification filters (used when resizing to 
		// smaller / larger images) to enum constant TextureFilter.Nearest
		// Important so that when our small pixel art is stretched to larger 
		// size each pixel will retain its shape
		mTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest); 
		
		// we can use our mTexture to create TextureRegion ojbects
		// TextureRegion objects require 5 arguments
		// @param1:    the pertinent texture object
		// @param2-5:  the rectangular boundries of the desired region on that texture
		//             given as x,y, width, height
		//             starting from top left
		// 
		// Texture regions must be flipped because libGDX assumes Y Up coordinate 
		// system by default and our mTexture is Y Down
		mBg = new TextureRegion(mTexture, 0,0,136,43); 
		mBg.flip(false, true); 
		
		mGrass = new TextureRegion(mTexture, 0,43,143,11); 
		mGrass.flip(false, true); 
		
		mCatDown = new TextureRegion(mTexture, 136, 0,17,12); 
		mCatDown.flip(false, true); 
		
		mCat = new TextureRegion(mTexture, 153, 0,17,12); 
		mCat.flip(false, true); 
		
		mCatUp = new TextureRegion(mTexture, 170,0,17,12); 
		mCatUp.flip(false, true); 
		
		// Animation
		// we can create an array of textureRegion objects and pass it 
		// into the constructor of a new Animation object
		
		// creates and array of TextureRegions
		TextureRegion[] cats = { mCatDown, mCat, mCatUp}; 
		// creates new Animation in which each frame is 0.06 seconds
		// we gave it 3 frames
		mCatAnimation = new Animation(0.06f, cats); 
		// set play mode to be ping pong in which we will see a bounce
		mCatAnimation.setPlayMode(Animation.LOOP_PINGPONG); 
		
		mSkullUp = new TextureRegion(mTexture, 192, 0,24,14); 
		// create by flipping existing skullUp
		mSkullDown = new TextureRegion(mSkullUp); 
		mSkullDown.flip(false, true); 
		
		mBar = new TextureRegion(mTexture, 136, 16, 22,2); 
		mBar.flip(false, true); 
		
		System.out.println("AssetLoader loading complete!"); 
		
	}
	
	public static void dispose(){
		// must dispose of texture when we're finished
		mTexture.dispose(); 
	}

}
