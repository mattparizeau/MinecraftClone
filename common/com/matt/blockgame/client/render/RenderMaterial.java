package com.matt.blockgame.client.render;

import org.lwjgl.opengl.GL11;

public class RenderMaterial {
	
	private int color;
	private Texture texture;
	
	public RenderMaterial(int color)
	{
		this(color, null);
	}
	
	public RenderMaterial(Texture texture)
	{
		this(0xFFFFFF, texture);
	}
	
	public RenderMaterial(int red, int green, int blue)
	{
		this(red, green, blue, 255);
	}
	
	public RenderMaterial(int red, int green, int blue, int alpha)
	{
		this(red, green, blue, alpha, null);
	}
	
	public RenderMaterial(int color, Texture texture)
	{
		this.color = color;
		this.texture = texture;
	}
	
	public RenderMaterial(int red, int green, int blue, Texture texture)
	{
		this(red, green, blue, 255, texture);
	}
	
	public RenderMaterial(int red, int green, int blue, int alpha, Texture texture)
	{
		this(((alpha & 0xFF) << 24) | 
				((red    & 0xFF) << 16) |
				((green  & 0xFF) << 8)  |
				((blue   & 0xFF) << 0), texture);
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
	
	public Texture getTexture()
	{
		return this.texture;
	}
	
	public void bind()
	{
		this.unbind();
		GL11.glColor4ub(getRed(), getGreen(), getBlue(), getAlpha());
		if (this.texture != null)
			this.texture.bind();
	}
	
	public void unbind()
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}
	
}
