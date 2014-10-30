/**
 * GameComponent class
 * framework to be extended in other code
 * the components will handle the meat of the program, such as
 * rendering, physics, input, and more
 */

package com.base.core;

public class GameComponent {
	
	//TODO: need to add enabled/disabled system to components?
	//TODO: add names
	
	public GameComponent(GameObject parent)
	{
		parentObject = parent;
	}
	
	private GameObject parentObject;
	
	public void input()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
}
