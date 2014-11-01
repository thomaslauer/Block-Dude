/**
 * GameComponent class
 * framework to be extended in other code
 * the components will handle the meat of the program, such as
 * rendering, physics, input, and more
 */

package com.base.core.components;

import com.base.core.GameObject;
import com.base.core.Transform;

public class GameComponent {
	
	private GameObject parentObject;
	private boolean isEnabled = true;
	
	public String name;
	
	public Transform parentTransform;
	
	public GameComponent(String name)
	{
		this.name = name;
	}
	
	public GameComponent()
	{
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
		parentTransform = parentObject.transform;
	}
}
