package com.matt.blockgame.common.blocks;

import com.matt.blockgame.common.blocks.materials.Material;

public class BlockAir extends Block {

	public BlockAir() {
		super(Material.air);
	}
	
	@Override
	public boolean canCollide() {
		return false;
	}
	
	@Override
	public boolean isVisible()
	{
		return false;
	}
	
}
