/**
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import com.base.core.AbstractGame;
import com.base.core.Engine;
import com.base.core.GameObject;
import com.base.core.components.RenderComponent;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject().setPosition(100, 100, 0).addComponent(new RenderComponent(100, 100, 1, 1, 1)));
		rootObject.addObject(new GameObject().setPosition(200, 100, 0).addComponent(new RenderComponent(100, 100, 0, 1, 1)));
		rootObject.setPosition(100, 0, 0);
	}
}
