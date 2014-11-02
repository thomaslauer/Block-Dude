/**
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import com.base.core.AbstractGame;
import com.base.core.GameObject;
import com.base.core.components.RenderComponent;
import com.base.core.components.SlideComponent;
import com.base.core.components.TextureRenderComponent;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject().setPosition(100, 100, 0).addComponent(new TextureRenderComponent("photo.png", 200, 200)).addComponent(new SlideComponent(1, 1, 0)));
		
	}
}
