package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import java.util.HashMap;

import com.matt.blockgame.client.render.material.BlockMaterial;
import com.matt.blockgame.common.blocks.Block;
import com.matt.blockgame.common.world.World;

public final class RenderBlocks {
	
	public static HashMap<Block, Integer> lists = new HashMap<Block, Integer>();
	private static boolean initialized = false;
	
	protected static final boolean isBlockVisible(World world, Block block, int x, int y, int z)
	{
		return !world.isBlockSurrounded(x, y, z) && block.isVisible();
	}
	
	public static final void renderBlock(World world, Block block, int x, int y, int z)
	{
		if (!initialized)
			initModels();
		
		if (block == null || !RenderBlocks.isBlockVisible(world, block, x, y, z))
			return;
			
			glPushMatrix();
			{
				RenderHelper.resetCamera();
				glEnable(GL_TEXTURE_2D);
				glTranslatef(x, y, z);
				glCallList(lists.get(block));
			}
			glPopMatrix();
	}
	
	public static final int getList(BlockMaterial material)
	{
		int displayList = glGenLists(1);
		glNewList(displayList, GL_COMPILE);
		
		glBegin(GL_QUADS);
		{
				material.getFront().bind();
				glNormal3f(0, 0, 1);
				glTexCoord2f(1, 0);
				glVertex3f(1, 0, 0);
				glTexCoord2f(1, 1);
				glVertex3f(0, 0, 0);
				glTexCoord2f(0, 1);
				glVertex3f(0, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(1, 1, 0);
			
				material.getBack().bind();
				glNormal3f(0, 0, -1);
				glTexCoord2f(1, 1);
				glVertex3f(0, 0, 1);
				glTexCoord2f(0, 1);
				glVertex3f(1, 0, 1);
				glTexCoord2f(0, 0);
				glVertex3f(1, 1, 1);
				glTexCoord2f(1, 0);
				glVertex3f(0, 1, 1);
				
				material.getTop().bind();
				glNormal3f(0, -1, 0);
				glTexCoord2f(0, 1);
				glVertex3f(1, 1, 0);
				glTexCoord2f(1, 1);
				glVertex3f(0, 1, 0);
				glTexCoord2f(1, 0);
				glVertex3f(0, 1, 1);
				glTexCoord2f(0, 0);
				glVertex3f(1, 1, 1);
			
				material.getBottom().bind();
				glNormal3f(0, 1, 0);
				glTexCoord2f(1, 1);
				glVertex3f(1, 0, 1);
				glTexCoord2f(1, 0);
				glVertex3f(0, 0, 1);
				glTexCoord2f(0, 0);
				glVertex3f(0, 0, 0);
				glTexCoord2f(0, 1);
				glVertex3f(1, 0, 0);
			
				material.getLeft().bind();
				glNormal3f(-1, 0, 0);
				glTexCoord2f(0, 1);
				glVertex3f(1, 0, 1);
				glTexCoord2f(1, 1);
				glVertex3f(1, 0, 0);
				glTexCoord2f(1, 0);
				glVertex3f(1, 1, 0);
				glTexCoord2f(0, 0);
				glVertex3f(1, 1, 1);
			
				material.getRight().bind();
				glNormal3f(1, 0, 0);
				glTexCoord2f(1, 1);
				glVertex3f(0, 0, 0);
				glTexCoord2f(1, 0);
				glVertex3f(0, 0, 1);
				glTexCoord2f(0, 0);
				glVertex3f(0, 1, 1);
				glTexCoord2f(0, 1);
				glVertex3f(0, 1, 0);
		}
		glEnd();
		glEndList();
		
		return displayList;
	}
	
	public static final void initModels()
	{
		for (Object o : Block.registry)
		{
			Block block = (Block)o;
			
			BlockMaterial material = new BlockMaterial(block);
			
			lists.put(block, getList(material));
		}
		
		initialized = true;
	}
	
}
