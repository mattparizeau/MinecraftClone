package com.matt.blockgame.client.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public final class Window {
	
	public static final Window createWindow(int width, int height, String title)
	{
		return new Window(width, height, title);
	}
	
	private String baseTitle;
	private String title;
	
	private Window(int width, int height, String title)
	{
		this.baseTitle = title;
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void update(int fps)
	{
		Display.sync(fps);
		this.update();
	}
	
	public void update()
	{
		Display.update();
	}
	
	public void setTitle(String title)
	{
		this.title = title;
		Display.setTitle(baseTitle + " | " + title);
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int getWidth()
	{
		return Display.getWidth();
	}
	
	public int getHeight()
	{
		return Display.getHeight();
	}
	
	public boolean isFullscreen()
	{
		return Display.isFullscreen();
	}
	
	public void setFullscreen(boolean fullscreen)
	{
		try {
			Display.setFullscreen(fullscreen);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
	
	public void dispose()
	{
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		System.exit(0);
	}
	
}
