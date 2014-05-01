package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

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
		//FloatBuffer buffer = BufferUtils.createFloatBuffer(4);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		//glEnable(GL_FOG);
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
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
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		
		glEnable(GL_FOG);
		FloatBuffer fogColor = BufferUtils.createFloatBuffer(4);
		fogColor.put(0f).put(0.4f).put(0.5f).put(1.0f).flip();
		
		glFogi(GL_FOG_MODE, GL_EXP);
		glFog(GL_FOG_COLOR, fogColor);
		glFogf(GL_FOG_DENSITY, RenderWorld.RENDER_DISTANCE / 300f);
		glHint(GL_FOG_HINT, GL_DONT_CARE);
		glFogf(GL_FOG_START, 1.0f);
		glFogf(GL_FOG_END, 5.0f);
		
		glClearColor(0f, 0.4f, 0.5f, 1.0f);
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
		Vector3f rotation = RenderHelper.camera.getTransform().getRotation();
		
		GL11.glRotatef(-rotation.getZ(), 0, 0, 1);
		GL11.glRotatef(-rotation.getX(), 1, 0, 0);
		GL11.glRotatef(-rotation.getY(), 0, 1, 0);
		GL11.glTranslatef(-position.getX(), -position.getY(), -position.getZ());
	}
	
}
