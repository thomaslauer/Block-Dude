package com.base.game;

import com.base.core.Engine;

public class Main {
	public static void main(String args[])
	{
		Engine mainEngine = new Engine(new Game());
		mainEngine.start();
	}
}
