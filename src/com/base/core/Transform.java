package com.base.core;

/**
 * Transform class to give a really easy way to handle x, y, and z positions
 * 
 * @author Thomas Lauer
 * 
 */
public class Transform {
	// the parent Transform
	public Transform parent;
	
	// x, y, and z of the transform
	public float x;
	public float y;
	public float z;
	
	// makes a transform with the x, y, and z
	public Transform(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// sets the parent Transform
	public Transform setParent(Transform t)
	{
		parent = t;
		return this;
	}
	
	// gets the world space of this transform
	public Transform getWorldSpaceTransform()
	{
		if(parent != null)
		{
			return new Transform(x + parent.getWorldSpaceTransform().x, y + parent.getWorldSpaceTransform().y, z + parent.getWorldSpaceTransform().z);
		}
		else
		{
			return new Transform(x, y, z).setParent(this);
		}
	}
}
