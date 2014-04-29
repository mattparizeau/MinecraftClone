package com.matt.blockgame.client.main;

import com.matt.blockgame.client.GameEngine;

/**
 * The class containing the entry point for the program
 * @author Matthieu Parizeau
 */
public final class Main {
	
	/**
	 * Entry Point
	 * @param args program arguments
	 */
	public static final void main(String[] args)
	{
		// Start the game
		GameEngine.getInstance().start();
	}
	
}
