package com.matt.blockgame.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import com.matt.blockgame.boot.BootStrap;
import com.matt.blockgame.client.input.Input;
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
		this.camera.getTransform().getPosition().set(0, 4, 16);
		this.camera.getTransform().getRotation().set(180, 0, 1, 0);
		RenderHelper.setCamera(this.camera);
		this.world = new World();
		//block = new BlockObject(Blocks.stone);
		//block.getTransform().getPosition().set(1, 1, 5);
	}
	
	public void input()
	{
		if (Input.getKey(Input.KEY_W))
		{
			this.camera.getTransform().getPosition().translate(0, 0, -0.5f);
		} else if (Input.getKey(Input.KEY_S))
		{
			this.camera.getTransform().getPosition().translate(0, 0, 0.5f);
		} else if (Input.getKey(Input.KEY_A))
		{
			this.camera.getTransform().getPosition().translate(-0.5f, 0, 0);
		} else if (Input.getKey(Input.KEY_D))
		{
			this.camera.getTransform().getPosition().translate(0.5f, 0, 0);
		}
	}
	
	//float rot = 0;
	
	public void update()
	{
		/*rot+=0.05;
		if (rot > 360)
			rot = 0;
		block.getTransform().getRotation().set(rot, 0, 1, 0);*/
	}
	
	public void render()
	{
		//RenderBlocks.renderBlock(block);
		RenderHelper.resetCamera();
		
		RenderWorld.renderWorld(world);
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
