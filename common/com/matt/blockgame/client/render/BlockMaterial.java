package com.matt.blockgame.client.render;

public class BlockMaterial {
	
	private RenderMaterial top;
	private RenderMaterial bottom;
	private RenderMaterial left;
	private RenderMaterial right;
	private RenderMaterial front;
	private RenderMaterial back;
	
	public BlockMaterial(RenderMaterial material)
	{
		this(material, material, material, material, material, material);
	}
	
	public BlockMaterial(RenderMaterial top, RenderMaterial bottom, RenderMaterial left, RenderMaterial right, RenderMaterial front, RenderMaterial back)
	{
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.front = front;
		this.back = back;
	}
	
	public RenderMaterial getTop()
	{
		return this.top;
	}
	
	public RenderMaterial getBottom()
	{
		return this.bottom;
	}
	
	public RenderMaterial getLeft()
	{
		return this.left;
	}
	
	public RenderMaterial getRight()
	{
		return this.right;
	}
	
	public RenderMaterial getFront()
	{
		return this.front;
	}
	
	public RenderMaterial getBack()
	{
		return this.back;
	}
	
}
