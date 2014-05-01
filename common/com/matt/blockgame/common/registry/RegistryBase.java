package com.matt.blockgame.common.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegistryBase implements IRegistry, Iterable<Object> {
	
	protected Map<String, Object> map;
	
	public RegistryBase() {
		map = new HashMap<String, Object>();
	}
	
	public boolean contains(String name)
	{
		return this.map.containsKey(name);
	}
	
	@Override
	public void addObject(String name, Object object) {
		map.put(name, object);
	}

	@Override
	public Object getObject(String name) {
		return map.get(name);
	}

	@Override
	public Iterator<Object> iterator() {
		return this.map.values().iterator();
	}
	
}
