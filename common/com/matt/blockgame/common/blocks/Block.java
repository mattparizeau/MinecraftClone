package com.matt.blockgame.common.blocks;

import com.matt.blockgame.client.render.material.MaterialList;
import com.matt.blockgame.common.blocks.materials.Material;
import com.matt.blockgame.common.registry.RegistryNamespaced;
import com.matt.blockgame.common.registry.RegistryNamespacedDefault;

public class Block {
	
	public static RegistryNamespaced registry = new RegistryNamespacedDefault("air");
	
	public static final void registerBlock(String name, Block block)
	{
		registry.addObject(name, block);
	}
	
	public static final Block getBlock(String name)
	{
		return (Block)registry.getObject(name);
	}
	
	public static final void initBlocks()
	{
		Block.registerBlock("air", new BlockAir());
		Block.registerBlock("stone", new Block(Material.rock).setTextureName("stone"));
		Block.registerBlock("dirt", new Block(Material.dirt).setTextureName("stone").setColor(MaterialList.yellow.getColor()));
		Block.registerBlock("grass", new Block(Material.dirt).setTextureName("stone").setColor(MaterialList.green.getColor()));
	}
	
	protected Material material;
	protected String textureName;
	protected int color;
	
	public Block(Material material)
	{
		this.material = material;
		this.textureName = "";
		this.color = 0xFFFFFF;
	}
	
	public Block setTextureName(String textureName)
	{
		this.textureName = textureName;
		return this;
	}
	
	public String getTextureName()
	{
		return this.textureName;
	}
	
	public Block setColor(int color)
	{
		this.color = color;
		return this;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public boolean canCollide()
	{
		return true;
	}
	
	public boolean isVisible()
	{
		return true;
	}
	
}
