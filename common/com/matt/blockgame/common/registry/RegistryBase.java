package com.matt.blockgame.common.registry;

import java.util.Iterator;

public class RegistryBase extends RegistryAdapter implements Iterable<Object> {
	
	public boolean contains(String name)
	{
		return this.map.containsKey(name);
	}

	@Override
	public Iterator<Object> iterator() {
		return this.map.values().iterator();
	}
	
}
