package com.apok.tutorialclickergame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.apok.tutorialclickergame.TutorialClickerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = TutorialClickerGame.TITLE;
		config.height = TutorialClickerGame.HEIGHT;
		config.width = TutorialClickerGame.WIDTH;
		config.resizable = false;
		new LwjglApplication(new TutorialClickerGame(), config);
	}
}
