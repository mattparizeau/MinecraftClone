package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;

public final class RenderHelper {
	
	public static final void initOpenGL(Window window, float fov)
	{
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glClearColor(0, 0, 0, 0);
		glClearDepth(1);
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(fov, (float)window.getWidth() / (float)window.getHeight(), 0.1f, 100.0f);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public static final void clearScreen()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
	}
	
}
