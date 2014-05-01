package com.matt.blockgame.client.render.material.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class Texture {
	
	private int id;
	private int width;
	private int height;
	
	private Texture(int id, int width, int height)
	{
		this.id = id;
		this.width = width;
		this.height = height;
	}
	
	public static final Texture loadTexture(String path)
	{	
		BufferedImage image = null;
		try {
			InputStream is = (Texture.class.getClassLoader().getResourceAsStream("textures/" + path));
			if (is == null)
				return null;
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		IntBuffer buffer = BufferUtils.createIntBuffer(pixels.length);
		for (int pixel : pixels)
		{
			buffer.put(pixel);
		}
		buffer.flip();
		
		int id = GL11.glGenTextures();
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);
		
		return new Texture(id, width, height);
	}
	
	public void bind()
	{
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.id);
	}
	
	public void unbind()
	{
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
}
