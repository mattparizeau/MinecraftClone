package com.matt.blockgame.common.registry;

import java.util.HashMap;
import java.util.Map;

public class RegistryNamespaced extends RegistryBase {
	
	protected Map<Object, String> keyMap;
	
	public RegistryNamespaced()
	{
		keyMap = new HashMap<Object, String>();
	}
	
	@Override
	public void addObject(String name, Object object)
	{
		super.addObject(name, object);
		keyMap.put(object, name);
	}
	
	public String getKey(Object object)
	{
		return keyMap.get(object);
	}
	
	public boolean contains(Object object)
	{
		return keyMap.containsKey(object);
	}
	
}
