package com.az.mygdxgame;

import com.badlogic.gdx.Game;
import com.kilobolt.Screens.GameScreen; 
import com.kilobolt.ZCHelpers.AssetLoader; 


// We need to provide an ApplicationInterface
// By extending Game, ZCGame becomes the interface betwen our code
// and our target platform.


public class ZCGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("ZCGame Creates!");
		
		AssetLoader.load();
		
		System.out.println("ZCGame created, Assets Loaded"); 
			
		// we want to set the current screen in our game 
		// to the screen we just created
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){ 
		super.dispose(); 
		AssetLoader.dispose(); 
	}
	
}
