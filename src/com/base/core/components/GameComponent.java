package com.base.core.components;

import com.base.core.*;

/**
 * This is a framework to be extended in other code.
 * the components will handle the meat of the program, such as
 * rendering, physics, input, and more.
 * 
 * @author Thomas Lauer
 * 
 */
public class GameComponent {
	
	/**
	 * A reference to the parent GameObject
	 */
	protected GameObject parentObject;
	
	/**
	 * enables or disables the component
	 */
	private boolean isEnabled = true;	
	
	/**
	 * the individual component name
	 */
	public String name;
	
	/**
	 * reference to the parent object transform
	 */
	public Transform parentTransform;
	
	/**
	 * reference to the game engine
	 */
	public Engine engine;
	
	/**
	 * constructor that takes a name
	 * @param name the name
	 */
	public GameComponent(String name)
	{ this.name = name; }
	
	/**
	 * no argument constructor
	 */
	public GameComponent()
	{ this(""); }
	
	/**
	 * method that gets called before the first frame, but after the scene is built
	 */
	public void init(){}
	
	/**
	 * method to handle input
	 */
	public void input(){}
	
	/**
	 * method to update the game
	 */
	public void update(){}
	
	/**
	 * method to render things
	 */
	public void render(){}
	
	/**
	 * gets if the component is enabled
	 * @return if the component is enabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}
	
	/**
	 * sets if the component is enabled
	 * @param isEnabled if it is enabled
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	/**
	 * getter for the parent object
	 * @return the parent object
	 */
	public GameObject getParentObject() {
		return parentObject;
	}
	
	/**
	 * sets the parent object of the component, and adds it to the engine
	 * @param parentObject the parent object
	 */
	public void setParentObject(GameObject parentObject) {
		this.parentObject = parentObject;
		parentTransform = parentObject.transform;
		engine = parentObject.engine;
	}
}
