/**
 * GameObject Class
 * Is the basis of the hierarchy system
 * It's only job is to update the components, which will do the actual computations
 */

package com.base.core;

import java.util.ArrayList;

public class GameObject {
	//TODO: add names of components
	private boolean isEnabled = true;
	
	//TODO: replace ArrayLists with HashMaps
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	public ArrayList<GameComponent> components = new ArrayList<GameComponent>();
	
	public final void input()
	{
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.input();
		}
	}
	
	public final void update()
	{
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.update();
		}
	}
	
	public final void render()
	{
		for(GameObject g : children)
		{
			if(g.isEnabled)
				g.render();
		}
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
