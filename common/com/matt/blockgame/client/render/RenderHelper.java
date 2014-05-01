package com.matt.blockgame.client.render;

import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.NVFogDistance;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

import com.matt.blockgame.common.entities.Camera;

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
	
	public static final void initOpenGL3D(Window window, float fov)
	{
		glPushMatrix();
		glDisable(GL_BLEND);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_FLAT);
		glClearDepth(1);
		glEnable(GL_LINE_SMOOTH);
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(fov, (float)window.getWidth() / (float)window.getHeight(), 0.1f, 100.0f);
		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		
		glEnable(GL_FOG);
		FloatBuffer fogColor = BufferUtils.createFloatBuffer(4);
		fogColor.put(0.9f).put(0.9f).put(0.9f).put(1.0f).flip();
		
		glFogi(GL_FOG_MODE, GL_LINEAR);
		glFog(GL_FOG_COLOR, fogColor);
		glHint(GL_FOG_HINT, GL_NICEST);
		glFogf(GL_FOG_START, RenderWorld.RENDER_DISTANCE * 4 * 0.8f);
		glFogf(GL_FOG_END, RenderWorld.RENDER_DISTANCE * 4);
		glFogi(NVFogDistance.GL_FOG_DISTANCE_MODE_NV, NVFogDistance.GL_EYE_RADIAL_NV);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
		
		glPopMatrix();
	}
	
	public static final void initOpenGL2D(Window window)
	{
		glLoadIdentity();
		glPushMatrix();
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glEnable(GL_COLOR_MATERIAL);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDisable(GL_FOG);
		glDisable(GL_CULL_FACE);
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, window.getWidth(), window.getHeight(), 0);
		glMatrixMode(GL_MODELVIEW);
		glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		glPopMatrix();
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
