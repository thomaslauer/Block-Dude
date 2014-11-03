package com.base.core;

public abstract class AbstractGame {
	// gameObject to act as the root of the hierarchy
	public GameObject rootObject;
	
	// the engine that calls all of the game functions
	public Engine engine;
	
	// constructor to initialize the root object
	public AbstractGame()
	{
		rootObject = new GameObject();
	}
	
	// sets the Engine used by the game, and sets it for all GameObjects
	public void setGameEngine(Engine e)
	{
		engine = e;
		rootObject.setEngine(engine);
	}
	
	// method to be used to load the game
	public abstract void init();
	
	// calls init() on all the children
	public void initChildren() {
		rootObject.init();
	}
	
	// calls input() on all children
	public final void input()
	{
		rootObject.input();
	}
	
	// calls update() on all children
	public final void update()
	{
		rootObject.update();
	}
	
	// calls render() on all children
	public final void render()
	{
		rootObject.render();
	}
}
