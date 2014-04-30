package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import com.matt.blockgame.client.BlockObject;
import com.matt.blockgame.client.GameEngine;
import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.world.World;

public final class RenderBlocks {
	
	public static final void renderBlock(World world, Block block, int x, int y, int z)
	{
		if (block == null || !block.isVisible())
			return;
		BlockObject blockObject = new BlockObject(block);
		blockObject.getTransform().getPosition().set(x, y, z);
		
		RenderBlocks.renderBlock(world, blockObject);
	}
	
	public static final void renderBlock(World world, BlockObject blockObject)
	{
		RenderHelper.resetCamera();
		Vector3f pos = blockObject.getTransform().getPosition();
		Vector4f rot = blockObject.getTransform().getRotation();
		//glTranslatef(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
		//glTranslatef(pos.getX(), pos.getY(), pos.getZ());
		glTranslatef(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
		//glRotatef(rot.getX(), rot.getY(), rot.getZ(), rot.getW());
		//glTranslatef(-0.5F, -0.5F, -0.5F);
		RenderBlocks.renderStandardBlock(blockObject.getMaterial(), new FaceMeta().calculate(world, (int)pos.getX(), (int)pos.getY(), (int)pos.getZ()));
	}
	
	public static final void renderStandardBlock(BlockMaterial material, FaceMeta meta)
	{
		//System.out.println("Meta: " + meta.toString());
		//if (true)
		//	return;
		glBegin(GL_QUADS);
		{
			if (meta.getFront())
			{
				material.getFront().bind();
				glTexCoord2f(1, 0);
				glVertex3f(1, 0, 0);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 0);
				glTexCoord2f(0, 1);
				glVertex3f(0, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 0);
			}
			
			if (meta.getBack())
			{
				material.getBack().bind();
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(0, 1);
				glVertex3f(0, 1, 1);
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 0, 1);
			}
			
			if (meta.getLeft())
			{
				material.getLeft().bind();
				glTexCoord2f(0, 1);
				glVertex3f(0, 0, 1);
				glTexCoord2f(1, 1);
				glVertex3f(0, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(0, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 0);
			}
			
			if (meta.getRight())
			{
				material.getRight().bind();
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(1, 0, 0);
				glTexCoord2f(0, 1);
				glVertex3f(1, 0, 1);
			}
			
			if (meta.getTop())
			{
				material.getTop().bind();
				glTexCoord2f(0, 1);
				glVertex3f(0, 1, 1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(0, 1, 0);
			}
			
			if (meta.getBottom())
			{
				material.getBottom().bind();
				glTexCoord2f(1, 1);
				glVertex3f(1, 0, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 0, 0);
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 0);
				glTexCoord2f(0, 1);
				glVertex3f(0, 0, 1);
			}
		}
		glEnd();
	}
	
}
