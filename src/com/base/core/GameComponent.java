/**
 * GameComponent class
 * framework to be extended in other code
 * the components will handle the meat of the program, such as
 * rendering, physics, input, and more
 */

package com.base.core;

public class GameComponent {
	
	private GameObject parentObject;
	private boolean isEnabled = true;
	
	public String name;
	
	public Transform parentTransform;
	
	public GameComponent(GameObject parent, String name)
	{
		parentObject = parent;
		parentTransform = parent.transform;
		this.name = name;
	}
	
	public void input(){}
	
	public void update(){}
	
	public void render(){}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public GameObject getParentObject() {
		return parentObject;
	}

	public void setParentObject(GameObject parentObject) {
		this.parentObject = parentObject;
	}
}
