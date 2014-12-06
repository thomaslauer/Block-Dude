package com.base.core;

import com.base.game.*;

/**
 * Engine class
 * runs game loop and handles everything 
 * not related to rendering or the game
 * 
 * @author Thomas Lauer
 *
 */
public class Engine {
	/**
	 * The game used by the entire engine
	 */
	public Game game;
	
	// if the game is running
	private boolean isRunning = false;
	
	/**
	 * Creates a new engine with the specified game
	 * @param game The game to be used by the rest of the engine
	 */
	public Engine(Game game)
	{
		this.game = game;
		game.setGameEngine(this);
	}

	/**
	 * Starts the entire game
	 */
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
	
	// if the engine will poll input
	private boolean doInput = true;
	
	// if the engine will update the game
	private boolean doUpdate = true;
	
	// if the engine will render the game
	private boolean doRender = true;
	
	// the main game loop
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
		cleanUp();
	}

	// polls the input
	private void input()
	{
		Input.poll();
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
	
	// deals with deleting things from memory and cleaning up the system
	private void cleanUp()
	{
		Window.destroy();
	}
	
	/**
	 * enables or disables the input
	 * @param e enabled
	 */
	public void enableInput(boolean e)
	{
		doInput = e;
	}
	
	/**
	 * enables or disables the update cycle
	 * @param e enabled
	 */
	public void enableUpdate(boolean e)
	{
		doUpdate = e;
	}
	
	/**
	 * enables or disables render the game
	 * @param e enabled
	 */
	public void enableRender(boolean e)
	{
		doRender = e;
	}
	
	/**
	 * checks if the engine will check the input
	 * @return if the input is enabled
	 */
	public boolean hasInput() {
		return doInput;
	}
	
	/**
	 * checks if the engine will update
	 * @return if the update is enabled
	 */
	public boolean hasUpdate() {
		return doUpdate;
	}
	
	/**
	 * checks if the engine will render
	 * @return if rendering is enabled
	 */
	public boolean hasRender() {
		return doRender;
	}
}
