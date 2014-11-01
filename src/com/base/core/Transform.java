package com.base.core;

/**
 * Transform class to give a really easy way to handle x, y, and z coords
 *
 */
public class Transform {
	//TODO: add a way to account for parent transforms (will have to be in other classes)
	
	public Transform parent;
	
	public float x;
	public float y;
	public float z;
	
	public Transform(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Transform applyTransform(Transform t)
	{
		return new Transform(t.x + x, t.y + y, t.z + z);
	}
	
	public Transform getWorldSpaceTranform()
	{
		if(parent != null)
		{
			return new Transform(x + parent.getWorldSpaceTranform().x, y + parent.getWorldSpaceTranform().y, z + parent.getWorldSpaceTranform().z);
		}
		else
		{
			return this;
		}
	}
}
