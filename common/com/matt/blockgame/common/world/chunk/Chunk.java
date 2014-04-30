package com.matt.blockgame.common.world.chunk;

import com.matt.blockgame.boot.Blocks;
import com.matt.blockgame.common.blocks.Block;

public class Chunk {
	
	public static final int CHUNK_HEIGHT = 256;
	public static final int CHUNK_SIZE = 16;
	
	private Block[][][] blocks;
	
	public Chunk()
	{
		this.blocks = new Block[CHUNK_SIZE][CHUNK_HEIGHT][CHUNK_SIZE];
	}
	
	public Chunk generate()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				for (int k = 0; k < 3; k++)
				{
					if (j == 0)
						this.setBlock(i, j, k, Blocks.stone);
					else
						this.setBlock(i, j, k, Blocks.dirt);
				}
			}
		}
		return this;
	}
	
	public void setBlock(int x, int y, int z, Block block)
	{
		this.blocks[x][y][z] = block;
	}
	
	public Block getBlock(int x, int y, int z)
	{
		if (x < 0 || y < 0 || z < 0 || x >= CHUNK_SIZE || y >= CHUNK_HEIGHT || z >= CHUNK_SIZE)
			return Blocks.air;
		//System.out.println("x: " + x + ", y: " + y + ", z: " + z);
		if (this.blocks[x][y][z] == null)
			return Blocks.air;
		return this.blocks[x][y][z];
	}
	
	public Block[][][] getBlocks()
	{
		return this.blocks;
	}
	
}
