package com.matt.blockgame.boot;

import com.matt.blockgame.common.blocks.Block;

/**
 * Class used to initialize game data on startup
 * @author Matthieu Parizeau
 */
public final class BootStrap {
	
	/**
	 * Initialize all the game data
	 */
	public static final void boot()
	{
		Block.initBlocks();
	}
	
}
