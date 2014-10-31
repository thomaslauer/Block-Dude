/**
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import com.base.core.AbstractGame;
import com.base.core.GameObject;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject());
	}
}
