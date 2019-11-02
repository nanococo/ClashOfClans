package com.mygdx.clashofclans.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.clashofclans.ClashOfClansGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ClashOfClansGame(), config);
		config.foregroundFPS = 60;
		//config.width = ClashOfClansGame.WIDTH;
		//config.height = ClashOfClansGame.HEIGHT;
		config.width = Gdx.graphics.getWidth();
		config.height = Gdx.graphics.getHeight();
		config.fullscreen = true;
		config.resizable = false;
	}
}
