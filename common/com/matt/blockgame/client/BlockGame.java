package com.matt.blockgame.client;

import com.matt.blockgame.boot.BootStrap;
import com.matt.blockgame.client.render.RenderHelper;
import com.matt.blockgame.client.render.RenderWorld;
import com.matt.blockgame.client.render.gui.RenderGui;
import com.matt.blockgame.common.entities.Camera;
import com.matt.blockgame.common.world.World;

public class BlockGame {
	
	private World world;
	private Camera camera;
	
	public BlockGame()
	{
		
	}
	
	public void init()
	{
		BootStrap.boot();
		this.camera = new Camera();
		this.camera.getTransform().getPosition().set(0, 18, 0);
		this.camera.getTransform().getRotation().set(0, 180, 0);
		RenderHelper.setCamera(this.camera);
		this.world = new World();
	}
	
	public void input()
	{
		this.camera.input();
	}
	
	public void update()
	{
		this.camera.update();
	}
	
	public void render()
	{
		RenderHelper.resetCamera();
		
		RenderWorld.renderWorld(world, camera);
	}
	
	public void renderGui()
	{
		RenderGui.renderGui();
	}
	
	public void dispose()
	{
		
	}
	
	public World getWorld()
	{
		return this.world;
	}
	
	public Camera getCamera()
	{
		return this.camera;
	}
	
}
