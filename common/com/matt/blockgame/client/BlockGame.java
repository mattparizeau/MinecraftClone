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
	
	public void update()
	{
		
	}
	
	public void render()
	{
		RenderBlocks.renderBlock(block);
	}
	
	public void dispose()
	{
		
	}
	
}
