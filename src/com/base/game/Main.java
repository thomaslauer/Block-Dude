
package com.base.game;

import com.base.core.Engine;

/**
 * Main class which just kicks the whole thing off
 * 
 * @author Thomas Lauer
 * 
 */

public class Main {
	public static void main(String args[])
	{
		Game game = new Game();
		Engine mainEngine = new Engine(game);
		mainEngine.start();
	}
}
