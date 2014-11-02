package com.base.core.components;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;

import com.base.core.Resource;


public class TextureRenderComponent extends GameComponent{
	private String fileName;
	private Texture texture;
	
	private float sx, sy;
	
	public TextureRenderComponent(String fileName, float sx, float sy)
	{
		this.fileName = fileName;
		this.sx = sx;
		this.sy = sy;
	}
	
	public void init()
	{
		this.texture = Resource.loadTexture(fileName);
	}
	
	public void render()
	{
		float x = parentObject.transform.getWorldSpaceTransform().x;
		float y = parentObject.transform.getWorldSpaceTransform().y;
		
		glColor3f(1, 1, 1);
		
		texture.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0); // top left
			glVertex2f(x, y);

			glTexCoord2f(0, 1); // bottom left 
			glVertex2f(x, y + sy);
			
			glTexCoord2f(1, 1); // bottom right
			glVertex2f(x + sx, y + sy);

			glTexCoord2f(1, 0); // top right
			glVertex2f(x + sx, y);
		}
		glEnd();
	}
}
