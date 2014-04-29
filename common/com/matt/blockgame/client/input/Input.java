package com.matt.blockgame.client.input;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * Class used to check for user input
 * @author Matthieu Parizeau
 */
public final class Input {
	
	public static final int MAX_KEYS = 256;
	public static final int MAX_MOUSE_BTN = 3;
	
	public static final int KEY_0 = Keyboard.KEY_0;
	public static final int KEY_1 = Keyboard.KEY_1;
	public static final int KEY_2 = Keyboard.KEY_2;
	public static final int KEY_3 = Keyboard.KEY_3;
	public static final int KEY_4 = Keyboard.KEY_4;
	public static final int KEY_5 = Keyboard.KEY_5;
	public static final int KEY_6 = Keyboard.KEY_6;
	public static final int KEY_7 = Keyboard.KEY_7;
	public static final int KEY_8 = Keyboard.KEY_8;
	public static final int KEY_9 = Keyboard.KEY_9;
	public static final int KEY_A = Keyboard.KEY_A;
	public static final int KEY_B = Keyboard.KEY_B;
	public static final int KEY_C = Keyboard.KEY_C;
	public static final int KEY_D = Keyboard.KEY_D;
	public static final int KEY_E = Keyboard.KEY_E;
	public static final int KEY_F = Keyboard.KEY_F;
	public static final int KEY_G = Keyboard.KEY_G;
	public static final int KEY_H = Keyboard.KEY_H;
	public static final int KEY_I = Keyboard.KEY_I;
	public static final int KEY_J = Keyboard.KEY_J;
	public static final int KEY_K = Keyboard.KEY_K;
	public static final int KEY_L = Keyboard.KEY_L;
	public static final int KEY_M = Keyboard.KEY_M;
	public static final int KEY_N = Keyboard.KEY_N;
	public static final int KEY_O = Keyboard.KEY_O;
	public static final int KEY_P = Keyboard.KEY_P;
	public static final int KEY_Q = Keyboard.KEY_Q;
	public static final int KEY_R = Keyboard.KEY_R;
	public static final int KEY_S = Keyboard.KEY_S;
	public static final int KEY_T = Keyboard.KEY_T;
	public static final int KEY_U = Keyboard.KEY_U;
	public static final int KEY_V = Keyboard.KEY_V;
	public static final int KEY_W = Keyboard.KEY_W;
	public static final int KEY_X = Keyboard.KEY_X;
	public static final int KEY_Y = Keyboard.KEY_Y;
	public static final int KEY_Z = Keyboard.KEY_Z;
	public static final int KEY_SPACE = Keyboard.KEY_SPACE;
	public static final int KEY_UP = Keyboard.KEY_UP;
	public static final int KEY_DOWN = Keyboard.KEY_DOWN;
	public static final int KEY_LEFT = Keyboard.KEY_LEFT;
	public static final int KEY_RIGHT = Keyboard.KEY_RIGHT;
	public static final int KEY_LSHIFT = Keyboard.KEY_LSHIFT;
	public static final int KEY_LCTRL = Keyboard.KEY_LCONTROL;
	public static final int KEY_RSHIFT = Keyboard.KEY_RSHIFT;
	public static final int KEY_RCTRL = Keyboard.KEY_RCONTROL;
	public static final int KEY_RETURN = Keyboard.KEY_RETURN;
	
	public static boolean[] keys = new boolean[MAX_KEYS];
	public static boolean[] mouse_buttons = new boolean[MAX_MOUSE_BTN];
	
	/**
	 * Update key and mouse button states
	 */
	public static void update()
	{
		for (int i = 0; i < keys.length; i++)
			keys[i] = getKey(i);
		
		for (int i = 0; i < mouse_buttons.length; i++)
			mouse_buttons[i] = getMouseButton(i);
	}
	
	/**
	 * Returns whether the specified key is being held
	 * @param keyCode the key to check
	 * @return whether or not the specified key is being held
	 */
	public static boolean getKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}
	
	/**
	 * Returns whether the specified key was pressed
	 * @param keyCode the key to check
	 * @return whether or not the specified key was pressed
	 */
	public static boolean getKeyDown(int keyCode)
	{
		return getKey(keyCode) && !keys[keyCode];
	}
	
	/**
	 * Returns whether the specified key was released
	 * @param keyCode the key to check
	 * @return whether or not the specified key was released
	 */
	public static boolean getKeyUp(int keyCode)
	{
		return !getKey(keyCode) && keys[keyCode];
	}
	
	/**
	 * Returns whether the specified mouse button is being held
	 * @param button the mouse button to check
	 * @return whether or not the specified mouse button is being held
	 */
	public static boolean getMouseButton(int button)
	{
		return Mouse.isButtonDown(button);
	}
	
	/**
	 * Returns whether the specified mouse button was pressed
	 * @param button the mouse button to check
	 * @return whether or not the specified mouse button was pressed
	 */
	public static boolean getMouseDown(int button)
	{
		return getMouseButton(button) && !mouse_buttons[button];
	}
	
	/**
	 * Returns whether the specified mouse button was released
	 * @param button the mouse button to check
	 * @return whether or not the specified mouse button was released
	 */
	public static boolean getMouseUp(int button)
	{
		return !getMouseButton(button) && mouse_buttons[button];
	}
	
}
