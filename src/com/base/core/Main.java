/**
 * Main class
 * runs game loop
 */

package com.base.core;

import com.base.game.*;

public class Main {
	public Game game;
	
	private boolean isRunning = false;
	
	public Main(Game game)
	{
		this.game = game;
	}
	
	public static void main(String args[])
	{
		Main main = new Main(new Game());
		main.start();
		main.cleanup();
	}
	
	private void start()
	{
		init();
		loop();
	}
	
	private void init()
	{
		game.init();
	}
	
	private void loop()
	{
		isRunning = true;
		while(isRunning)
		{
			input();
			update();
			render();
		}
	}
	
	private void input()
	{
		game.input();
	}
	
	private void update()
	{
		game.update();
	}
	
	private void render()
	{
		game.render();
	}
	
	private void cleanup()
	{
		game.cleanup();
	}
}
