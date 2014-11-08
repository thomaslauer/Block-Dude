/**
 * Game class
 * Handles all the game stuff
 */

package com.base.game;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.base.core.AbstractGame;
import com.base.core.GameFile;
import com.base.core.GameObject;
import com.base.core.components.*;

public class Game extends AbstractGame{
	public void init()
	{
		rootObject.addObject(new GameObject("face").setPosition(100, 100, 0)
				.addComponent(new TextureRenderComponent("photo", 200, 200))
				.addComponent(new KeyboardMoveComponent()));
		GameFile g = new GameFile();
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(150);
		g.setTag("Hello world", x);
		g.saveToFile("test");
		
		
		GameFile f = new GameFile("test");
		ArrayList<Integer> list = (ArrayList<Integer>) f.getArray("Hello world");
		System.out.println(list.toString());
	}
}
