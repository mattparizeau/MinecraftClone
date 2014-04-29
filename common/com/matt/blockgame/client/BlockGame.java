package com.matt.blockgame.client;

import com.matt.blockgame.boot.Blocks;
import com.matt.blockgame.boot.BootStrap;
import com.matt.blockgame.client.render.RenderBlocks;
import com.matt.blockgame.client.render.RenderManager;

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
		//rot+=0.05f;
		//if (rot > 360)
		//	rot = 0;
	}
	
	//float rot = 0;
	
	public void render()
	{
		RenderBlocks.renderBlock(block);
		/*GL11.glTranslatef(0, 0, -5);
		GL11.glRotatef(rot, 1, 1, 1);
		RenderManager.renderCube(new BlockMaterial(MaterialList.blue, MaterialList.cyan, MaterialList.magenta, MaterialList.orange, MaterialList.yellow, MaterialList.red));*/
	}
	
	public void dispose()
	{
		
	}
	
}
