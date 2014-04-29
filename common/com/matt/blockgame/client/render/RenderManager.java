package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

public final class RenderManager {
	
	public static final void renderCube(BlockMaterial material)
	{
		glBegin(GL_QUADS);
		{
			material.getFront().bind();
			glVertex3f(1, 0, 0);
			glVertex3f(1, 1, 0);
			glVertex3f(0, 1, 0);
			glVertex3f(0, 0, 0);
			
			material.getBack().bind();
			glVertex3f(1, 1, 1);
			glVertex3f(0, 1, 1);
			glVertex3f(0, 0, 1);
			glVertex3f(1, 0, 1);
			
			material.getLeft().bind();
			glVertex3f(0, 0, 1);
			glVertex3f(0, 1, 1);
			glVertex3f(0, 1, 0);
			glVertex3f(0, 0, 0);
			
			material.getRight().bind();
			glVertex3f(1, 1, 1);
			glVertex3f(1, 1, 0);
			glVertex3f(1, 0, 0);
			glVertex3f(1, 0, 1);
			
			material.getTop().bind();
			glVertex3f(0, 1, 1);
			glVertex3f(1, 1, 1);
			glVertex3f(1, 1, 0);
			glVertex3f(0, 1, 0);
			
			material.getBottom().bind();
			glVertex3f(1, 0, 1);
			glVertex3f(1, 0, 0);
			glVertex3f(0, 0, 0);
			glVertex3f(0, 0, 1);
		}
		glEnd();
	}
	
}
