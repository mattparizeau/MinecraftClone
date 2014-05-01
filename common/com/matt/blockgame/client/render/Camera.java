package com.matt.blockgame.client.render;

import com.matt.blockgame.client.input.Input;
import com.matt.blockgame.common.game.Entity;

public class Camera extends Entity {
	
	public static float sensitivity = 0.5f;
	
	public Camera()
	{
		
	}
	
	@Override
	public void input() {
		
		if (Input.isLocked())
		{
			if (Input.getKeyDown(Input.KEY_ESCAPE))
			{
				Input.setLocked(false);
			}
			
			float dx = Input.getMouseDX();
			float dy = Input.getMouseDY();
			
			//this.getTransform().getRotation().translate(-dy * sensitivity, -dx * sensitivity, 0);
			yaw(-dx * sensitivity);
			pitch(dy * sensitivity);
		} else {
			if (Input.getMouseButton(0))
			{
				Input.setLocked(true);
			}
		}
		
		if (Input.getKey(Input.KEY_W))
		{
			this.move(ObjectDirection.FORWARD, 0.5f);
			//this.getTransform().getPosition().translate(0, 0, -0.5f);
		}
		
		if (Input.getKey(Input.KEY_S))
		{
			this.move(ObjectDirection.BACKWARD, 0.5f);
			//this.getTransform().getPosition().translate(0, 0, 0.5f);
		}
		
		if (Input.getKey(Input.KEY_A))
		{
			this.move(ObjectDirection.LEFT, 0.5f);
			//this.getTransform().getPosition().translate(-0.5f, 0, 0);
		}
		
		if (Input.getKey(Input.KEY_D))
		{
			this.move(ObjectDirection.RIGHT, 0.5f);
			//this.getTransform().getPosition().translate(0.5f, 0, 0);
		}
		
		if (Input.getKey(Input.KEY_SPACE))
		{
			this.move(ObjectDirection.UP, 0.5f);
		}
		
		if (Input.getKey(Input.KEY_LSHIFT))
		{
			this.move(ObjectDirection.DOWN, 0.5f);
		}
	}
	
	protected void move(ObjectDirection direction, float amount)
	{
		float x = this.getTransform().getPosition().getX();
		float y = this.getTransform().getPosition().getY();
		float z = this.getTransform().getPosition().getZ();
		float yaw = -this.getTransform().getRotation().getY();
		//float pitch = this.getTransform().getRotation().getX();
		
		switch (direction)
		{
		case FORWARD:
			x += amount * (float)Math.sin(Math.toRadians(yaw));
			z -= amount * (float)Math.cos(Math.toRadians(yaw));
			break;
		case BACKWARD:
			x -= amount * (float)Math.sin(Math.toRadians(yaw));
			z += amount * (float)Math.cos(Math.toRadians(yaw));
			break;
		case LEFT:
			x += amount * (float)Math.sin(Math.toRadians(yaw-90));
			z -= amount * (float)Math.cos(Math.toRadians(yaw-90));
			break;
		case RIGHT:
			x += amount * (float)Math.sin(Math.toRadians(yaw+90));
			z -= amount * (float)Math.cos(Math.toRadians(yaw+90));
			break;
		case UP:
			y += amount;
			break;
		case DOWN:
			y -= amount;
			break;
		default:
			break;
		
		}
		
		this.getTransform().getPosition().set(x, y, z);
	}
	
	protected void yaw(float amount)
	{
		float yaw = this.getTransform().getRotation().getY();
		this.getTransform().getRotation().setY(yaw + amount);
	}
	
	protected void pitch(float amount)
	{
		float pitch = this.getTransform().getRotation().getX();
		if ((pitch > 90 && amount > 0) || (pitch < -90 && amount < 0))
			return;
		this.getTransform().getRotation().setX(pitch + amount);
	}
	
}
