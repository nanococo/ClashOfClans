package com.mygdx.clashofclans.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.clashofclans.clashOfClansGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new clashOfClansGame(), config);
		config.foregroundFPS = 60;
		config.width = clashOfClansGame.WIDTH;
		config.height = clashOfClansGame.HEIGHT;
		config.resizable = false;
	}
}
