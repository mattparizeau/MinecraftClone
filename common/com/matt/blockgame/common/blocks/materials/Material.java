package com.matt.blockgame.common.blocks.materials;

public class Material {
	
	public static Material air = new Material();
	public static Material rock = new Material();
	public static Material dirt = new Material();
	public static Material wood = new Material().setBurnRate(1.0F).setBurnChance(0.4F);
	
	protected float burnRate;
	protected float burnChance;
	
	protected Material()
	{
		this.burnRate = 0.0F;
		this.burnChance = 0.05F;
	}
	
	public Material setBurnRate(float burnRate)
	{
		this.burnRate = burnRate;
		return this;
	}
	
	public Material setBurnChance(float burnChance)
	{
		this.burnChance = burnChance;
		return this;
	}
	
}
