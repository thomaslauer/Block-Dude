package com.base.game;

import com.base.core.Engine;

public class Main {
	public static void main(String args[])
	{
		Game game = new Game();
		Engine mainEngine = new Engine(game);
		mainEngine.start();
	}
}
