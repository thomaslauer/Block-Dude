package com.base.core;

import java.util.ArrayList;

import com.base.core.components.GameComponent;

/**
 * GameObject Class
 * Is the basis of the hierarchy system
 * It's only job is to update the components, which will do the actual computations
 */
public class GameObject {
	// if any computations should be done on this object
	private boolean isEnabled = true;
	
	// Transform to hold position
	public Transform transform;
	
	// name of the object
	public String name;
	
	// an arraylist of the children and components
	public ArrayList<GameObject> children;
	public ArrayList<GameComponent> components;
	
	// reference to the engine
	public Engine engine;
	
	// constructor that takes all args
	public GameObject(float x, float y, float z, String name)
	{
		transform = new Transform(x, y, z);
		children = new ArrayList<GameObject>();
		components = new ArrayList<GameComponent>();
		engine = null;
		this.name = name;
	}
	
	// constructor that takes position
	public GameObject(float x, float y, float z)
	{
		this(x, y, z, null);
	}
	
	// constructor that takes name
	public GameObject(String name)
	{
		this(0, 0, 0, name);
	}
	
	// no argument constructor
	public GameObject()
	{
		this(0, 0, 0, null);
	}
	
	// method to set the name of the object
	public GameObject setName(String name)
	{
		this.name = name;
		return this;
	}
	
	// method that sets the position of the object
	public GameObject setPosition(float x, float y, float z)
	{
		transform.x = x;
		transform.y = y;
		transform.z = z;
		return this;
	}
	
	// sets if the object is enabled
	public GameObject setEnabled(boolean enabled)
	{
		isEnabled = enabled;
		return this;
	}
	
	// checks if the object is enabled
	public boolean getEnabled()
	{
		return isEnabled;
	}
	
	// initializes all the children and components
	public void init()
	{
		for(GameComponent c : components)
		{
			if(c.isEnabled())
			{
				c.init();
			}
		}
		for(GameObject g : children)
		{
			if(g.getEnabled())
			{
				g.init();
			}
		}
	}
	
	// checks the input for all of the children and components
	public final void input()
	{
		for(GameComponent c : components)
		{
			if(c.isEnabled())
			{
				c.input();
			}
		}
		for(GameObject g : children)
		{
			if(g.getEnabled())
			{
				g.input();
			}
		}
	}
	
	// updates all the children and components
	public final void update()
	{
		for(GameComponent c : components)
		{
			if(c.isEnabled())
			{
				c.update();
				
			}
		}
		for(GameObject g : children)
		{
			if(g.getEnabled())
			{
				g.update();
			}
		}
	}
	
	// tells the children and components to render stuff
	public final void render()
	{
		for(GameComponent c : components)
		{
			if(c.isEnabled())
			{
				c.render();
			}
		}
		for(GameObject g : children)
		{
			if(g.getEnabled())
			{
				g.render();
			}
		}
	}
	
	// adds a child object, and ads it to the engine
	public GameObject addObject(GameObject o)
	{
		o.setEngine(engine);
		o.transform.parent = transform;
		children.add(o);
		return this;
	}
	
	// adds a component to the engine
	public GameObject addComponent(GameComponent c)
	{
		c.setParentObject(this);
		components.add(c);
		return this;
	}
	
	// gets a child object of a specific name
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
	
	// gets a component by name
	public GameComponent getComponentByName(String name)
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
	
	// gets a component by type
	public GameComponent getComponentByType(String type)
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
	
	// sets the engine of this object and all children
	public void setEngine(Engine e)
	{
		engine = e;
		for(GameObject g : children)
		{
			g.setEngine(e);
		}
	}
}
