package com.matt.blockgame.client;

import com.matt.blockgame.boot.Blocks;
import com.matt.blockgame.boot.BootStrap;
import com.matt.blockgame.client.render.RenderBlocks;

public class BlockGame {
	
	private BlockObject block;
	
	public BlockGame()
	{
		
	}
	
	public void init()
	{
		BootStrap.boot();
		block = new BlockObject(Blocks.stone);
		block.getTransform().getPosition().set(1, 1, 5);
	}
	
	public void input()
	{
		
	}
	
	float rot = 0;
	
	public void update()
	{
		rot+=0.05;
		if (rot > 360)
			rot = 0;
		block.getTransform().getRotation().set(rot, 0, 1, 0);
	}
	
	public void render()
	{
		RenderBlocks.renderBlock(block);
	}
	
	public void dispose()
	{
		
	}
	
}
