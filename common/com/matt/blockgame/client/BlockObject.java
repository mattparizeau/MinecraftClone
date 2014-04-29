package com.matt.blockgame.client;

import com.matt.blockgame.client.render.BlockMaterial;
import com.matt.blockgame.client.render.RenderMaterial;
import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.game.GameObject;

public class BlockObject extends GameObject {
	
	protected Block block;
	protected BlockMaterial material;
	
	public BlockObject(Block block)
	{
		this.block = block;
		this.material = new BlockMaterial(new RenderMaterial(block.getColor()));
	}
	
	public Block getBlock()
	{
		return this.block;
	}
	
	public BlockMaterial getMaterial()
	{
		return this.material;
	}
	
}
