/**
 * GameObject Class
 * Is the basis of the hierarchy system
 * It's only job is to update the components, which will do the actual computations
 */

package com.base.core;

import java.util.ArrayList;

public class GameObject {
	private boolean isEnabled = true;
	
	public String name;
	
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	public ArrayList<GameComponent> components = new ArrayList<GameComponent>();
	
	public final void input()
	{
		for(GameComponent g : components)
		{
			if(g.isEnabled())
				g.input();
		}
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.input();
		}
	}
	
	public final void update()
	{
		for(GameComponent g : components)
		{
			if(g.isEnabled())
				g.update();
		}
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.update();
		}
	}
	
	public final void render()
	{
		for(GameComponent g : components)
		{
			if(g.isEnabled())
				g.render();
		}
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.render();
		}
	}
	
	public GameObject getChildObject(String name)
	{
		for(GameObject g : children)
		{
			if(g.name == name)
			{
				return g;
			}
		}
		return null;
	}
	
	public GameComponent getComponent(String name)
	{
		for(GameComponent c : components)
		{
			if(c.name == name)
			{
				return c;
			}
		}
		return null;
	}
	
	public GameObject setEnabled(boolean enabled)
	{
		isEnabled = enabled;
		return this;
	}
	
	public boolean getEnabled()
	{
		return isEnabled;
	}
}
