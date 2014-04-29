package com.matt.blockgame.common.game;

import com.matt.blockgame.common.math.Transform;

public abstract class GameObject {
	
	protected Transform transform;
	
	public GameObject()
	{
		this.transform = new Transform();
	}
	
	public Transform getTransform()
	{
		return this.transform;
	}
	
}
