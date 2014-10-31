package com.base.core;

/**
 * Transform class to give a really easy way to handle x, y, and z coords
 *
 */
public class Transform {
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
}
