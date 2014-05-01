package com.matt.blockgame.client;

import com.matt.blockgame.boot.BootStrap;
import com.matt.blockgame.client.render.Camera;
import com.matt.blockgame.client.render.RenderHelper;
import com.matt.blockgame.client.render.RenderWorld;
import com.matt.blockgame.common.world.World;

public class BlockGame {
	
	//private BlockObject block;
	private World world;
	private Camera camera;
	
	public BlockGame()
	{
		
	}
	
	public void init()
	{
		BootStrap.boot();
		this.camera = new Camera();
		this.camera.getTransform().getPosition().set(0, 68, 0);
		this.camera.getTransform().getRotation().set(0, 180, 0);
		RenderHelper.setCamera(this.camera);
		this.world = new World();
		//block = new BlockObject(Blocks.stone);
		//block.getTransform().getPosition().set(1, 1, 5);
	}
	
	public void input()
	{
		this.camera.input();
	}
	
	//float rot = 0;
	
	public void update()
	{
		this.camera.update();
		/*rot+=0.05;
		if (rot > 360)
			rot = 0;
		block.getTransform().getRotation().set(rot, 0, 1, 0);*/
	}
	
	public void render()
	{
		//RenderBlocks.renderBlock(block);
		RenderHelper.resetCamera();
		
		RenderWorld.renderWorld(world, camera);
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
