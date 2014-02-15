package com.kilobolt.GameWorld;

import com.badlogic.gdx.math.Rectangle; 
import com.kilobolt.GameObjects.Cat; 

public class GameWorld {
	
	
	private Cat mCat; 
	
	// constructor
	public GameWorld(int midPointY){ 
		
		// width is assumed to be 137
		// @param1:  33 is where cat stays entire time
		// @param2:  cat starts at 5px above midPointY
		// @param3:  17 width
		// @param4:  12 height
		this.mCat = new Cat(33, midPointY - 5, 17, 12); 
	}
	
	
	public void update(float delta){ 
		mCat.update(delta); 
	}
	
	
	public Cat getCat(){ 
		return this.mCat; 
	}

	public String worldString(){
		return "My Game World"; 
	}
}
