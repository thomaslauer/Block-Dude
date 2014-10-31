/**
 * Engine class
 * runs game loop and handles everything 
 * not related to rendering or the game
 */

package com.base.core;

import com.base.game.*;

public class Engine {
	// the big game
	public Game game;
	// if the game is running
	private boolean isRunning = false;
	
	// makes a new engine with the game given
	public Engine(Game game)
	{
		this.game = game;
	}
	
//	public static void main(String args[])
//	{
//		Engine main = new Engine(new Game());
//		main.init();
//		main.gameLoop();
//	}

	public void start()
	{
		init();
		gameLoop();
	}
	
	// initializes the game and other needed items
	private void init()
	{
		game.init();
	}
	
	// main game loop
	private void gameLoop()
	{
		isRunning = true;
		while(isRunning)
		{
			input();
			update();
			render();
		}
	}
	// polls the input
	private void input()
	{
		game.input();
	}
	
	// updates the game
	private void update()
	{
		game.update();
	}
	
	// renders the game
	private void render()
	{
		game.render();
	}
}