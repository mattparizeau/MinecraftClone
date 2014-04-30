package com.matt.blockgame.client;

import com.matt.blockgame.client.render.BlockMaterial;
import com.matt.blockgame.client.render.RenderMaterial;
import com.matt.blockgame.client.render.Texture;
import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.game.Entity;

public class BlockObject extends Entity {
	
	protected Block block;
	protected BlockMaterial material;
	
	public BlockObject(Block block)
	{
		this.block = block;
		Texture texture = null;
		if (block.getTextureName().trim().length() > 0)
			texture = Texture.loadTexture(block.getTextureName() + ".png");
		this.material = new BlockMaterial(new RenderMaterial(block.getColor(), texture));
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
