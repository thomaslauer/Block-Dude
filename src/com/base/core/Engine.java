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
		game.setGameEngine(this);
	}

	// method to kick it off
	public void start()
	{
		init();
		gameLoop();
	}
	
	// initializes the game and other needed items
	private void init()
	{
		Window.createDisplay(800, 600);
		game.init();
		game.initChildren();
	}
	
	// variables to determine if the engine needs to call the input, update, or render methods
	private boolean doInput = true;
	private boolean doUpdate = true;
	private boolean doRender = true;
	
	
	// main game loop
	private void gameLoop()
	{
		isRunning = true;
		while(isRunning)
		{
			if(doInput)
				input();
			if(doUpdate)
				update();
			if(doRender)
				render();
			
			Window.capFps(60);
			Window.clearScreen();
			if(Window.isCloseRequested())
				isRunning = false;
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
		Window.update();
	}
	
	// changes if we need to poll input
	public void enableInput(boolean e)
	{
		doInput = e;
	}
	
	// same for update
	public void enableUpdate(boolean e)
	{
		doUpdate = e;
	}
	
	// and for render
	public void enableRender(boolean e)
	{
		doRender = e;
	}
	
	// getters for doInput, doUpdate, doRender
	public boolean hasInput() {
		return doInput;
	}

	public boolean hasUpdate() {
		return doUpdate;
	}

	public boolean hasRender() {
		return doRender;
	}
}
