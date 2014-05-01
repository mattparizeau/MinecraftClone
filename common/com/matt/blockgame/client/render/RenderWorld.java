package com.matt.blockgame.client.render;

import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.game.Entity;
import com.matt.blockgame.common.world.World;
import com.matt.blockgame.common.world.chunk.Chunk;

public final class RenderWorld {
	
	public static final float RENDER_DISTANCE = 4;
	
	public static final void renderWorld(World world, Entity entity)
	{	
		int x = (int)entity.getTransform().getPosition().getX() >> 4;
		int z = (int)entity.getTransform().getPosition().getZ() >> 4;
		
		int x1 = x - ((int)RENDER_DISTANCE / 2);
		int x2 = x + ((int)RENDER_DISTANCE / 2);
		
		int z1 = z - ((int)RENDER_DISTANCE / 2);
		int z2 = z + ((int)RENDER_DISTANCE / 2);
		
		for (int i = x1; i < x2; i++)
		{
			for (int j = z1; j < z2; j++)
			{
				Chunk chunk = world.getChunk(i, j);
				if (chunk == null)
				{
					world.createChunkAt(i, j);
					chunk = world.getChunk(i, j);
				}
				RenderWorld.renderChunk(world, chunk, i * 16, j * 16);
			}
		}
	}
	
	public static final void renderChunk(World world, Chunk chunk, int x, int z)
	{
		for (int i = 0; i < Chunk.CHUNK_SIZE; i++)
		{
			for (int j = 0; j < Chunk.CHUNK_HEIGHT; j++)
			{
				for (int k = 0; k < Chunk.CHUNK_SIZE; k++)
				{
					Block block = world.getBlock(i + x, j, k + z);
					RenderBlocks.renderBlock(world, block, i + x, j, k + z);
				}
			}
		}
	}
	
}
