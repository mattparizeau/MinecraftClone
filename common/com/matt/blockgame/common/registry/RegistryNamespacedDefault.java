package com.matt.blockgame.common.registry;

public class RegistryNamespacedDefault extends RegistryNamespaced {
	
	protected String defaultKey;
	
	public RegistryNamespacedDefault(String defaultKey)
	{
		super();
		this.defaultKey = defaultKey;
	}

	@Override
	public Object getObject(String name) {
		if (this.contains(name))
			return super.getObject(name);
		if (!this.contains(name) && this.contains(defaultKey))
			return super.getObject(defaultKey);
		return null;
	}

}
