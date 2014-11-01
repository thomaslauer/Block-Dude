package com.base.core.components;

import static org.lwjgl.opengl.GL11.*;

public class RenderComponent extends GameComponent{

	public float sx, sy, r, g, b;
	
	public RenderComponent(float sx, float sy, float r, float g, float b) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void render()
	{
		glColor3f(r, g, b);
		glBegin(GL_QUADS);
		{
			glVertex2f(parentTransform.getWorldSpaceTranform().x, parentTransform.getWorldSpaceTranform().y);
			glVertex2f(parentTransform.getWorldSpaceTranform().x + sx, parentTransform.getWorldSpaceTranform().y);
			glVertex2f(parentTransform.getWorldSpaceTranform().x + sx, parentTransform.getWorldSpaceTranform().y + sy);
			glVertex2f(parentTransform.getWorldSpaceTranform().x, parentTransform.getWorldSpaceTranform().y + sy);
		}
		glEnd();
	}
}
