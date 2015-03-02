package com.base.game.components;

import com.base.core.components.GameComponent;

public class GravityComponent extends GameComponent
{
	public BitmapWorldComponent world;
	
	public int mx, my;
	public int dataValue;
	public GravityComponent(int x, int y, int data)
	{
		mx = x;
		my = y;
		dataValue = data;
		//System.out.println("Making new GravityComponent with positions of x: " + mx + " y: " + my);
	}
	
	public void init()
	{
		world = (BitmapWorldComponent) parentObject.engine.game.rootObject.getChildObject("world").getComponentByName("game");
	}
	
	public void update()
	{
		
		//System.out.println("for block in position of x: " + mx + " y: " + my + "\tDataValue below is: " + world.getBlockRelative(mx, my, 0, 1));
		
		while(world.getBlockRelative(mx, my, 0, 1) == 0)
		{
			world.data[mx][my] = 0;
			my++;
			//System.out.println(my);
		}
		
		
		world.data[mx][my] = dataValue;
	}
}
