
package com.base.game;

import com.base.core.Engine;

/**
 * Main class which just kicks the whole thing off
 * 
 * @author Thomas Lauer
 * 
 */
public class Main 
{
	public static void main(String args[])
	{
		if(AutoUpdate.hasUpdates())
		{
			System.out.println("Downloading updates....");
			AutoUpdate.getUpdate();
			System.out.println("Download complete!");
		}
		else
		{
			System.out.println("No updates found.");
		}
		Game game = new Game();
		Engine mainEngine = new Engine(game);
		mainEngine.begin();
	}
}
