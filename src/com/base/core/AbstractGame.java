package com.base.core;

public abstract class AbstractGame {	
	public GameObject rootObject;
	
	public Engine engine;
	
	public AbstractGame()
	{
		rootObject = new GameObject();
	}
	
	public void setGameEngine(Engine e)
	{
		engine = e;
		rootObject.setEngine(engine);
	}
	
	public void init(){}
	
	public void input()
	{
		rootObject.input();
	}
	public void update()
	{
		rootObject.update();
	}
	public void render()
	{
		rootObject.render();
	}
}
