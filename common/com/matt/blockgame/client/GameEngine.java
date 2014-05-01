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
		
		long lastTime = System.nanoTime();
		int frames = 0;
		int updates = 0;
		long unprocessedTime = 0;
		long frameTime = 0;
		float ns = 1.0f / 60.0f;
		
		while(true)
		{
			long startTime = System.nanoTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)ns;
			frameTime += passedTime;
			
			while (unprocessedTime >= 1000)
			{
				unprocessedTime -= 1000000000L;
				if (window.isCloseRequested())
					this.stop();
				
				this.input();
				this.update();
				updates++;
			
			}
			
			if (frameTime >= 1000000000L)
			{
				String info = ("FPS: " + frames + " | UPS: " + updates);
				window.setTitle(info);
				frameTime = 0;
				frames = 0;
				updates = 0;
			}
			
			this.render();
			frames++;
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
	
	public BlockGame getGame()
	{
		return this.game;
	}
	
	public Window getWindow()
	{
		return this.window;
	}
	
}
