package com.base.core.components;

import org.lwjgl.input.Keyboard;

import com.base.core.Input;

public class KeyboardMoveComponent extends GameComponent
{
	public void init()
	{
		Input.addKey("left", Keyboard.KEY_A);
		Input.addKey("right", Keyboard.KEY_D);
		Input.addKey("up", Keyboard.KEY_W);
		Input.addKey("down", Keyboard.KEY_S);
	}
	
	public void update()
	{
		if(Input.isKeyDown("left"))
		{
			parentTransform.x--;
		}
		if(Input.isKeyDown("right"))
		{
			parentTransform.x++;
		}
		if(Input.isKeyDown("up"))
		{
			parentTransform.y--;
		}
		if(Input.isKeyDown("down"))
		{
			parentTransform.y++;
		}
	}
}
