/**
 * GameObject Class
 * Is the basis of the hierarchy system
 * It's only job is to update the components, which will do the actual computations
 */

package com.base.core;

import java.util.ArrayList;

public class GameObject {
	// if any computations should be done on this object
	private boolean isEnabled = true;
	
	// Transform to hold position
	public Transform transform;
	
	// name of the object
	public String name;
	
	// ArrayLists of the children objects and the components of this object
	public ArrayList<GameObject> children;
	public ArrayList<GameComponent> components;
	
	// a reference to the engine
	public Engine engine;
	
	// full argument constructor, takes all the arguments needed
	public GameObject(float x, float y, float z, String name)
	{
		transform = new Transform(x, y, z);
		children = new ArrayList<GameObject>();
		components = new ArrayList<GameComponent>();
		engine = null;
		this.name = name;
	}
	
	// position only constructor
	public GameObject(float x, float y, float z)
	{
		this(x, y, z, "");
	}
	
	// name only constructor
	public GameObject(String name)
	{
		this(0, 0, 0, name);
	}
	
	// no argument constructor
	public GameObject()
	{
		this(0, 0, 0, "");
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
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
	
	public GameObject setEnabled(boolean enabled)
	{
		isEnabled = enabled;
		return this;
	}
	
	public boolean getEnabled()
	{
		return isEnabled;
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
	
	public void addObject(GameObject o)
	{
		o.setEngine(engine);
		children.add(o);
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
	
	public GameComponent getComponentNamed(String name)
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
	
	public GameComponent getComponentType(String type)
	{
		try {
			Class<?> componentClass = Class.forName(type);
			
			for(GameComponent c : components)
			{
				if(componentClass.isInstance(c))
				{
					return c;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setEngine(Engine e)
	{
		engine = e;
		for(GameObject g : children)
		{
			g.setEngine(e);
		}
	}
}
