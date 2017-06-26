package com.oleynik.solarsystem.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.oleynik.solarsystem.GdxGameCore;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
//		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
//		config.fullscreen = true;
		config.width = 1850;
		config.height = 930;
		new LwjglApplication(new GdxGameCore(), config);
	}
}

// to build jar in desktop/build/libs/:  gradlew desktop:dist