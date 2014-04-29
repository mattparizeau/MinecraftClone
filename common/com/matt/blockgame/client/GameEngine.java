package com.matt.blockgame.client;

import com.matt.blockgame.client.input.Input;
import com.matt.blockgame.client.render.RenderHelper;
import com.matt.blockgame.client.render.Window;

public final class GameEngine {
	
	private static GameEngine instance;
	
	public static GameEngine getInstance()
	{
		if (GameEngine.instance == null)
			GameEngine.instance = new GameEngine();
		return GameEngine.instance;
	}
	
	private Window window;
	private BlockGame game;
	
	private GameEngine()
	{
		this.window = Window.createWindow(800, 600, "BlockGame");
		this.game = new BlockGame();
	}
	
	public void start()
	{
		RenderHelper.initOpenGL(window, 45);
		this.game.init();
		
		while(true)
		{
			if (window.isCloseRequested())
				this.stop();
			
			this.input();
			this.update();
			this.render();
			window.update();
		}
	}
	
	public void input()
	{
		this.game.input();
		Input.update();
	}
	
	public void update()
	{
		this.game.update();
	}
	
	public void render()
	{
		RenderHelper.clearScreen();
		this.game.render();
	}
	
	public void stop()
	{
		this.game.dispose();
		this.window.dispose();
	}
	
	public Window getWindow()
	{
		return this.window;
	}
	
}
