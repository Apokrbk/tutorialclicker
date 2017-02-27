package com.apok.tutorialclickergame;

import com.apok.tutorialclickergame.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TutorialClickerGame extends Game {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private static final String GAME_PREFS = "com.apok.tutorialclickergame.prefs";
	private static final String GAME_SCORE = "com.apok.tutorialclickergame.prefs.score";
	public static final String TITLE = "Tutorial Clicker";
	private int points;
	private Preferences prefs;
	private boolean paused;

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}

	public void addPoint()
	{
		points++;
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	/*******
	GETTERS AND SETTERS
	*******/

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
}
