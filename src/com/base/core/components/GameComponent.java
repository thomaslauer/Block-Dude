/**
 * GameComponent class
 * framework to be extended in other code
 * the components will handle the meat of the program, such as
 * rendering, physics, input, and more
 */

package com.base.core.components;

import com.base.core.*;

public class GameComponent {
	// a reference to the parent object
	protected GameObject parentObject;
	
	// boolean which will enable or disable the component
	private boolean isEnabled = true;
	
	// a name for the component
	public String name;
	
	// a reference to the parent object transform
	public Transform parentTransform;
	
	// a reference to the engine
	public Engine engine;
	
	// constructor with name
	public GameComponent(String name)
	{ this.name = name; }
	
	// no argument constructor, for nice constructing uses
	public GameComponent()
	{ this(""); }
	
	// method that gets called before the first frame, but after all the objects are done
	public void init(){}
	
	// method to handle input
	public void input(){}
	
	// method to handle updating the game
	public void update(){}
	
	// method to render things
	public void render(){}
	
	// getters and setters for isEnabled
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	// getter for the parent object
	public GameObject getParentObject() {
		return parentObject;
	}
	
	// setter for the parent object, used when adding the component to an object
	public void setParentObject(GameObject parentObject) {
		this.parentObject = parentObject;
		parentTransform = parentObject.transform;
		engine = parentObject.engine;
	}
}
