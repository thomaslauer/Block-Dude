/**
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import com.base.core.AbstractGame;
import com.base.core.GameObject;
import com.base.core.components.RenderComponent;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject().setPosition(100, 100, 0).addComponent(new RenderComponent(100, 100, 1, 1, 1)));
	}
}
