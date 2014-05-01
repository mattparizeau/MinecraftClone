package com.matt.blockgame.common.world.chunk;

import java.util.Objects;

public class ChunkLocation {
	
	private int x, z;
	
	public ChunkLocation(int x, int z)
	{
		this.x = x;
		this.z = z;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof ChunkLocation))
			return false;
		
		ChunkLocation loc = (ChunkLocation)o;
		
		return this.x == loc.x && this.z == loc.z;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.z);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getZ()
	{
		return this.z;
	}
	
}
