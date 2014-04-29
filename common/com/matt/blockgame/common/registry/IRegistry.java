package com.matt.blockgame.common.registry;

public interface IRegistry {
	public void addObject(String name, Object object);
	public Object getObject(String name);
}
