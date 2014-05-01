package com.matt.blockgame.client.render;

import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.world.World;
import com.matt.blockgame.common.world.chunk.Chunk;
import com.matt.blockgame.common.world.chunk.ChunkLocation;

public final class RenderWorld {
	
	public static final void renderWorld(World world)
	{
		Chunk[] chunks = new Chunk[world.getChunks().size()];
		world.getChunks().values().toArray(chunks);
		ChunkLocation[] locations = new ChunkLocation[world.getChunks().size()];
		world.getChunks().keySet().toArray(locations);
		
		for (int i = 0; i < world.getChunks().size(); i++)
		{
			Chunk chunk = chunks[i];
			ChunkLocation location = locations[i];
			
			RenderWorld.renderChunk(world, chunk, location.getX() * 16, location.getZ() * 16);
		}
	}
	
	public static final void renderChunk(World world, Chunk chunk, int x, int z)
	{
		//BlockMesh mesh = new BlockMesh();
		//mesh.rebuild(chunk, x, z);
		//mesh.draw();
		for (int i = 0; i < Chunk.CHUNK_SIZE; i++)
		{
			for (int j = 0; j < Chunk.CHUNK_HEIGHT; j++)
			{
				for (int k = 0; k < Chunk.CHUNK_SIZE; k++)
				{
					Block block = world.getBlock(i + x, j, k + z);
					//int x2 = i & 0xF;
					//int z2 = k & 0xF;
					//System.out.println(x2 + ", " + z2);
					RenderBlocks.renderBlock(world, block, i + x, j, k + z);
				}
			}
		}
	}
	
}
