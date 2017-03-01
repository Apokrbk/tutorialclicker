package com.apok.tutorialclickergame;

import com.apok.tutorialclickergame.screens.SplashScreen;
import com.apok.tutorialclickergame.service.SoundService;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;

public class TutorialClickerGame extends Game {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private static final String GAME_PREFS = "com.apok.tutorialclickergame.prefs";
	private static final String GAME_SCORE = "com.apok.tutorialclickergame.prefs.score";
	public static final String TITLE = "Tutorial Clicker";
	private int points;
	private Preferences prefs;
	private boolean paused;

	private SoundService soundService;

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		soundService = new SoundService();
	}


	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}

	public void addPoints(int pointsToAdd)
	{
		points+= pointsToAdd;
		updateSavedScoreInPrefs();
	}

	private void updateSavedScoreInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	public void resetGameScore() {
		points = 0;
		updateSavedScoreInPrefs();
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

	public void addPassiveIncome() {
		System.out.println("passive income click");
	}

	public SoundService getSoundService() {
		return soundService;
	}
}
