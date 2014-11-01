/**
 * GameObject Class
 * Is the basis of the hierarchy system
 * It's only job is to update the components, which will do the actual computations
 */

package com.base.core;

import java.util.ArrayList;

import com.base.core.components.GameComponent;

public class GameObject {
	// if any computations should be done on this object
	private boolean isEnabled = true;
	
	// Transform to hold position
	public Transform transform;
	
	// name of the object
	public String name;
	
	public ArrayList<GameObject> children;
	public ArrayList<GameComponent> components = new ArrayList<GameComponent>();
	
	public Engine engine;
	
	public GameObject(float x, float y, float z, String name)
	{
		transform = new Transform(x, y, z);
		children = new ArrayList<GameObject>();
		components = new ArrayList<GameComponent>();
		engine = null;
		this.name = name;
	}
	
	public GameObject(float x, float y, float z)
	{
		this(x, y, z, null);
	}
	
	public GameObject(String name)
	{
		this(0, 0, 0, name);
	}
	
	public GameObject()
	{
		this(0, 0, 0, null);
	}
	
	
	public GameObject setName(String name)
	{
		this.name = name;
		return this;
	}
	
	public GameObject setPosition(float x, float y, float z)
	{
		transform.x = x;
		transform.y = y;
		transform.z = z;
		return this;
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
	
	public GameObject addObject(GameObject o)
	{
		o.setEngine(engine);
		children.add(o);
		return this;
	}
	
	public GameObject addComponent(GameComponent c)
	{
		c.setParentObject(this);
		components.add(c);
		return this;
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
