package com.github.jacekpoz.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.github.jacekpoz.PopeClickerGame;

public class DesktopLauncher {
	public static void main (String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(800, 600);
		config.setTitle("Pope Clicker");
		new Lwjgl3Application(new PopeClickerGame(), config);
	}
}
