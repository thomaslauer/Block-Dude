package com.base.core.components;

public class SlideComponent extends GameComponent{
	public float mx, my, mz;
	
	public SlideComponent(float x, float y, float z)
	{
		mx = x;
		my = y;
		mz = z;
	}
	
	public void update()
	{
		parentTransform.x += mx;
		parentTransform.y += my;
		parentTransform.z += mz;
	}
}
