package com.base.core;

public abstract class AbstractGame {	
	public GameObject rootObject;
	
	public AbstractGame()
	{
		rootObject = new GameObject();
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
