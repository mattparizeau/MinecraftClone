package com.matt.blockgame.common.registry;

import java.util.HashMap;
import java.util.Map;

public abstract class RegistryAdapter implements IRegistry {
	
	protected Map<String, Object> map;
	
	public RegistryAdapter() {
		map = new HashMap<String, Object>();
	}

	@Override
	public void addObject(String name, Object object) {
		map.put(name, object);
	}

	@Override
	public Object getObject(String name) {
		return map.get(name);
	}

}
