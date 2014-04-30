package com.matt.blockgame.common.game;

import com.matt.blockgame.common.math.Transform;

public abstract class Entity {
	
	protected Transform transform;
	
	public Entity()
	{
		this.transform = new Transform();
	}
	
	public void input()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public Transform getTransform()
	{
		return this.transform;
	}
	
}
