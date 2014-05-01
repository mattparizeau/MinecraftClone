package com.matt.blockgame.client.render.gui;

import static org.lwjgl.opengl.GL11.*;

public final class RenderGui {
	
	public static final void renderGui()
	{
		glBegin(GL_QUADS);
		{
			glColor4f(1.0f, 0, 0, 1.0f);
			glVertex2f(0, 0);
			glVertex2f(0, 100);
			glVertex2f(100, 100);
			glVertex2f(100, 0);
		}
		glEnd();
	}
	
}
