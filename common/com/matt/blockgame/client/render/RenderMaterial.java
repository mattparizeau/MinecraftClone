package com.matt.blockgame.client.render;

import org.lwjgl.opengl.GL11;

public class RenderMaterial {
	
	private int color;
	
	public RenderMaterial(int color)
	{
		this.color = color;
	}
	
	public RenderMaterial(int red, int green, int blue)
	{
		this(red, green, blue, 255);
	}
	
	public RenderMaterial(int red, int green, int blue, int alpha)
	{
		this(((alpha & 0xFF) << 24) | 
				((red    & 0xFF) << 16) |
				((green  & 0xFF) << 8)  |
				((blue   & 0xFF) << 0));
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public byte getAlpha()
	{
		return (byte)((this.color >> 24) & 0xFF);
	}
	
	public byte getRed()
	{
		return (byte)((this.color >> 16) & 0xFF);
	}
	
	public byte getGreen()
	{
		return (byte)((this.color >> 8) & 0xFF);
	}
	
	public byte getBlue()
	{
		return (byte)((this.color >> 0) & 0xFF);
	}
	
	public void bind()
	{
		GL11.glColor4ub(getRed(), getGreen(), getBlue(), getAlpha());
	}
	
}
