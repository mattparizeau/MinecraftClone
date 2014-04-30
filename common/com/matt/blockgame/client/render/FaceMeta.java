package com.matt.blockgame.client.render;

import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.world.World;

public class FaceMeta {
	
	private boolean front, back, left, right, top, bottom;
	
	public FaceMeta()
	{
		this.front = true;
		this.back = true;
		this.left = true;
		this.right = true;
		this.top = true;
		this.bottom = true;
	}
	
	public FaceMeta calculate(World world, int x, int y, int z)
	{
		Block blockFront = world.getBlock(x, y, z - 1);
		if (blockFront != null && blockFront.isVisible())
			front = false;
		Block blockBack = world.getBlock(x, y, z + 1);
		if (blockBack != null && blockBack.isVisible())
			back = false;
		Block blockLeft = world.getBlock(x - 1, y, z);
		if (blockLeft != null && blockLeft.isVisible())
			left = false;
		Block blockRight = world.getBlock(x + 1, y, z);
		if (blockRight != null && blockRight.isVisible())
			right = false;
		Block blockTop = world.getBlock(x, y + 1, z);
		if (blockTop != null && blockTop.isVisible())
			top = false;
		Block blockBottom = world.getBlock(x, y - 1, z);
		if (blockBottom != null && blockBottom.isVisible())
			bottom = false;
		return this;
	}
	
	@Override
	public String toString()
	{
		String front = (this.front ? "Front " : "");
		String back = (this.back ? "Back " : "");
		String left = (this.left ? "Left " : "");
		String right = (this.right ? "Right " : "");
		String top = (this.top ? "Top " : "");
		String bottom = (this.bottom ? "Bottom " : "");
		return "{" + front + back + left + right + top + bottom + "}";
	}
	
	public boolean getFront()
	{
		return this.front;
	}
	
	public boolean getBack()
	{
		return this.back;
	}
	
	public boolean getLeft()
	{
		return this.left;
	}
	
	public boolean getRight()
	{
		return this.right;
	}
	
	public boolean getTop()
	{
		return this.top;
	}
	
	public boolean getBottom()
	{
		return this.bottom;
	}
	
}
