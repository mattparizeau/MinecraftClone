package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector3f;

import com.matt.blockgame.client.BlockObject;

public final class RenderBlocks {
	
	public static final void renderBlock(BlockObject blockObject)
	{
		Vector3f pos = blockObject.getTransform().getPosition();
		glTranslatef(-pos.getX(), -pos.getY(), -pos.getZ());
		RenderManager.renderCube(blockObject.getMaterial());
	}
	
}
