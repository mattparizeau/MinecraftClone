package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import com.matt.blockgame.client.BlockObject;

public final class RenderBlocks {
	
	public static final void renderBlock(BlockObject blockObject)
	{
		Vector3f pos = blockObject.getTransform().getPosition();
		Vector4f rot = blockObject.getTransform().getRotation();
		glTranslatef(-pos.getX(), -pos.getY(), -pos.getZ());
		glRotatef(rot.getX(), rot.getY(), rot.getZ(), rot.getW());
		glTranslatef(-0.5F, -0.5F, -0.5F);
		RenderManager.renderCube(blockObject.getMaterial());
	}
	
}
