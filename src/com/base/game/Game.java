package com.base.game;

import com.base.core.AbstractGame;
import com.base.core.GameObject;
import com.base.core.ScriptComponent;
import com.base.core.components.*;
import com.base.game.components.BitmapWorldComponent;

/**
 * Game class
 * Handles all the game stuff
 */
public class Game extends AbstractGame{
	public void start()
	{
		rootObject.addObject(new GameObject("world").setPosition(0, 0, 0)
				.addComponent(new ReverseKeyboardMoveComponent()));
		
		rootObject.getChildObject("world").addComponent(new ScriptComponent("res/scripts/test.groovy"));
		
		rootObject.getChildObject("world").addComponent(new BitmapWorldComponent("game", "def"));
	}
}
