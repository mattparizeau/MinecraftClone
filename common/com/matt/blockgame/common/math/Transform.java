package com.matt.blockgame.common.math;

import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class Transform {
	
	protected Vector3f position;
	protected Vector3f scale;
	protected Quaternion rotation;
	
	public Transform()
	{
		this(new Vector3f(0, 0, 0));
	}
	
	public Transform(Vector3f position)
	{
		this(position, new Vector3f(1, 1, 1));
	}
	
	public Transform(Vector3f position, Vector3f scale)
	{
		this(position, scale, new Quaternion());
	}
	
	public Transform(Vector3f position, Vector3f scale, Quaternion rotation)
	{
		this.position = position;
		this.scale = scale;
		this.rotation = rotation;
	}
	
	public Vector3f getPosition()
	{
		return this.position;
	}
	
	public void setPosition(Vector3f position)
	{
		this.position = position;
	}
	
	public Vector3f getScale()
	{
		return this.scale;
	}
	
	public void setScale(Vector3f scale)
	{
		this.scale = scale;
	}
	
	public Quaternion getRotation()
	{
		return this.rotation;
	}
	
	public void setRotation(Quaternion rotation)
	{
		this.rotation = rotation;
	}
	
}
