package com.base.core.components;

import org.lwjgl.input.Keyboard;

import com.base.core.Input;

public class KeyboardMoveComponent extends GameComponent
{
	public float speed = 1.5f;
	
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
			parentTransform.x -= speed;
		}
		if(Input.isKeyDown("right"))
		{
			parentTransform.x += speed;
		}
		if(Input.isKeyDown("up"))
		{
			parentTransform.y -= speed;
		}
		if(Input.isKeyDown("down"))
		{
			parentTransform.y += speed;
		}
	}
}
