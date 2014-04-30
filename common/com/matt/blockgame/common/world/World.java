package com.matt.blockgame.common.world;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.matt.blockgame.boot.Blocks;
import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.world.chunk.Chunk;
import com.matt.blockgame.common.world.chunk.ChunkLocation;

public class World {
	
	protected Map<ChunkLocation, Chunk> chunks;
	protected Random random;
	protected long seed;
	
	public World()
	{
		this(System.currentTimeMillis());
	}
	
	public World(long seed)
	{
		this.seed = seed;
		this.random = new Random(seed);
		this.chunks = new HashMap<ChunkLocation, Chunk>();
		this.createChunkAt(0, 0);
	}
	
	public void createChunkAt(int x, int z)
	{
		this.chunks.put(new ChunkLocation(x, z), new Chunk().generate());
	}
	
	public Chunk getChunk(int x, int z)
	{
		return this.chunks.get(new ChunkLocation(x, z));
	}
	
	public Chunk getChunkFromBlockCoords(int x, int z)
	{
		return this.getChunk(x >> 4, z >> 4);
	}
	
	public Map<ChunkLocation, Chunk> getChunks()
	{
		return this.chunks;
	}
	
	public void setBlock(int x, int y, int z, Block block)
	{
		this.getChunkFromBlockCoords(x, z).setBlock(x & 0xF, y, z & 0xF, block);
	}
	
	public Block getBlock(int x, int y, int z)
	{
		//System.out.println("x: " + x + ", y: " + y + ", z: " + z);
		Chunk chunk = this.getChunkFromBlockCoords(x, z);
		if (chunk == null)
			return Blocks.air;
		Block block = chunk.getBlock(x & 0xF, y, z & 0xF);
		//System.out.println("Texture: " + block.getTextureName());
		return block;
	}
	
}
