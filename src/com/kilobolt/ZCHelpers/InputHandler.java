package com.kilobolt.ZCHelpers;

import com.badlogic.gdx.InputProcessor;
import com.kilobolt.GameObjects.Cat; 


// we only need to worry about the onTouch method
// TouchDown method should call our Cat's onClick method
// We need a reference to our cat object
// Who has a reference to you cat? GameWorld does, which 
// belongs to game screen



public class InputHandler implements InputProcessor {

	private Cat mMyCat; 
	
	public InputHandler(Cat cat){ 
		mMyCat = cat; 
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		mMyCat.onClick(); 
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
