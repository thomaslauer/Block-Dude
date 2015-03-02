package com.base.core;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import com.base.core.components.*;

public class ScriptComponent extends GameComponent
{
	public GameComponent script;
	
	public ScriptComponent(String file)
	{
		try {
			GroovyClassLoader gcl = new GroovyClassLoader();
			Class<?> clazz = gcl.parseClass(new File(file));
			System.out.println(clazz.getName());
			script = (GameComponent) clazz.newInstance();
			System.out.println(script.toString());
			
			gcl.close();
		} catch (CompilationFailedException e) {
			System.err.println("ERROR: Couldn't compile script");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: Couldn't find file");
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		parentObject.addComponent(script);
		parentObject.components.remove(this);
	}
}
