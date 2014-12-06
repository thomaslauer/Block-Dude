/*
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import java.util.ArrayList;

import com.base.core.AbstractGame;
import com.base.core.GameObject;
import com.base.core.components.*;
import com.base.game.components.WorldComponent;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject("face").setPosition(100, 100, 0)
				.addComponent(new TextureRenderComponent("photo", 200, 200))
				.addComponent(new KeyboardMoveComponent()));
		
		WorldComponent c = new WorldComponent("GameFile1");
	}
}
