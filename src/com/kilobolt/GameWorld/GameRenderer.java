package com.kilobolt.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10; 

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer; 
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType; 

import com.kilobolt.GameObjects.Cat; 
import com.kilobolt.ZCHelpers.AssetLoader;


public class GameRenderer {
	
	private GameWorld mMyWorld; 
	private OrthographicCamera mCam; 
	private ShapeRenderer mShapeRenderer; 

	private SpriteBatch mBatcher; 
	
	private int mMidPointY; 
	private int mGameHeight; 
	
	private Cat mCat; 
	private TextureRegion mBg, mGrass; 
	private Animation mCatAnimation; 
	private TextureRegion mCatMid, mCatDown, mCatUp;
	private TextureRegion mSkullUp, mSkullDown, mBar; 
	
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointY){ 
		
		System.out.println("GR1"); 
		
		mMyWorld = world; 
		this.mGameHeight = gameHeight; 
		this.mMidPointY = midPointY; 
		
		
		mCam = new OrthographicCamera(); 
		
		// @param1:  do you want orthographic projection
		// @param2:  width
		// @param3:  height


		mCam.setToOrtho(true, 136, mGameHeight); 
		// attach mBatcher to camera
		mBatcher = new SpriteBatch(); 
		mBatcher.setProjectionMatrix(mCam.combined);
	
		// get an instance of the shape renderer
		mShapeRenderer = new ShapeRenderer(); 
		// attach the shape renderer to the camera
		mShapeRenderer.setProjectionMatrix(mCam.combined); 
		
		// call helper methods to initialize instance variables
		initGameObjects(); 
		initAssets(); 

	}
	
	private void initGameObjects(){ 
		mCat = mMyWorld.getCat(); 
	}
	
	private void initAssets(){ 
		mBg = AssetLoader.mBg; 
		mGrass = AssetLoader.mGrass; 
		mCatAnimation = AssetLoader.mCatAnimation; 
		mCatMid	 = AssetLoader.mCat; 
		mCatDown = AssetLoader.mCatDown; 
		mCatUp = AssetLoader.mCatUp; 
		mSkullUp = AssetLoader.mSkullUp; 
		mSkullDown = AssetLoader.mSkullDown; 
		mBar = AssetLoader.mBar; 
	}
	
	// 
	// @param1: runTime is used to determine which frame of the 
	//          animation to display
	
	public void render(float runTime){
		
		System.out.println("GameRenderer - render"); 
		
		
		// draw a black background. prevents flickerinng
		Gdx.gl.glClearColor(0, 0, 0, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		
		// tells shapeRender to begin drawing filled shapes
		mShapeRenderer.begin(ShapeType.Filled);
		
		
		// draw background color
		mShapeRenderer.setColor(55/255.0f, 80/255.0f, 100/255.0f, 1); 
		mShapeRenderer.rect(0,0,136, mMidPointY + 66); 
		
		// draw grass
		mShapeRenderer.setColor(111/255.0f,186/255.0f, 45/255.0f, 1); 
		mShapeRenderer.rect(0,mMidPointY + 66, 136,11); 
		
		// draw dirt
		mShapeRenderer.setColor(147/255.0f, 80/255.0f,27/255.0f,1); 
		mShapeRenderer.rect(0,mMidPointY + 77, 136,52); 
			
		// tells the shape renderer to finish renderering
		// must be done every time
		mShapeRenderer.end(); 
		
		
		// Begin spritebatch
		mBatcher.begin(); 
		
		// disable transparency
		// this is good for performance if you don't need transparencty
		mBatcher.disableBlending(); 
		mBatcher.draw(AssetLoader.mBg,0,mMidPointY +23, 136,43); 
		
		// cat needs transparency so turn back on
		mBatcher.enableBlending(); 
		
		// draw cat at its coordinates. Retrieve the Animation object
		// from Asset loader
		// pass in the runTime variable to get the current frame
		if(mCat.shouldntFlap()){ 
			mBatcher.draw(mCatMid, mCat.getX(), mCat.getY(), 
					mCat.getWidth() / 2.0f, 
					mCat.getHeight() / 2.0f, 
					mCat.getWidth(), mCat.getHeight(), 1,1, mCat.getRotation()); 
		} else { 
			mBatcher.draw(mCatAnimation.getKeyFrame(runTime),
					mCat.getX(), mCat.getY(), 
					mCat.getWidth() / 2.0f, 
					mCat.getHeight() / 2.0f, 
					mCat.getWidth(), 
					mCat.getHeight(), 
					1,1,mCat.getRotation()); 
		}
		
		// end sprite
		mBatcher.end(); 
	}

}
