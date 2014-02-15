package com.kilobolt.Screens;


import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10; 
import com.kilobolt.GameWorld.GameWorld;
import com.kilobolt.GameWorld.GameRenderer;
import com.kilobolt.ZCHelpers.InputHandler;



// Game screen should only do one thing 
// updating the game objects will be the responsibility of 
//   helper class, GameWorld
// rendering the game objects will be the responsibility of 
//   help class, GameRenderer



public class GameScreen implements Screen {

	private GameWorld mWorld; 
	private GameRenderer mRenderer; 
	private float mRunTime = 0; 
	
	public GameScreen(){ 
		
		
		System.out.println("Game screen constructor!");
		// we assume the game is 136 units wide
		// we can retrieve game width and height with 
		// Gdx.graphics.getWidth() & Gdx.graphics.getHeight()
		
		float screenWidth = Gdx.graphics.getWidth(); 
		float screenHeight = Gdx.graphics.getHeight(); 
		float gameWidth = 136; 
		
		// scale. if width is 272 (i.e. 2x 136)
	    //        and height is 400, then scale dimensions
		//        are 200 x 136
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		int midPointY = (int)(gameHeight / 2); 
	
		mWorld = new GameWorld(midPointY); 
		
		System.out.println("mWorld" + mWorld.worldString()); 
		System.out.println("mWorld.getCat()" + mWorld.getCat().catString()); 

		mRenderer = new GameRenderer(mWorld, (int)gameHeight, midPointY); 
	
		Gdx.input.setInputProcessor(new InputHandler(mWorld.getCat()));
		
		System.out.println("Gamescreen Attached"); 
	}
	
	@Override
	public void render(float delta) {
		// 
		mRunTime += delta; 
		
		mWorld.update(delta); 
		mRenderer.render(mRunTime); 
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		System.out.println("gamescreen -resizing");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Gamescreen -show called"); 
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		System.out.println("Gamescreen -hide called"); 
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("Gamescreen - pause called");
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("Gamescreen  - resume called"); 
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
