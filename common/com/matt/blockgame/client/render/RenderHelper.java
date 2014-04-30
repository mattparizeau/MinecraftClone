package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public final class RenderHelper {
	
	private static Camera camera;
	
	public static final void setCamera(Camera camera)
	{
		RenderHelper.camera = camera;
	}
	
	public static final Camera getCamera()
	{
		return RenderHelper.camera;
	}
	
	public static final void initOpenGL(Window window, float fov)
	{
		//glEnable(GL_CULL_FACE);
		//glCullFace(GL_FRONT);
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
	
	public static final void resetCamera()
	{
		glLoadIdentity();
		Vector3f position = RenderHelper.camera.getTransform().getPosition();
		Vector4f rotation = RenderHelper.camera.getTransform().getRotation();
		GL11.glTranslatef(-position.getX(), -position.getY(), -position.getZ());
		GL11.glRotatef(-rotation.getX(), rotation.getY(), rotation.getZ(), rotation.getW());
	}
	
}
