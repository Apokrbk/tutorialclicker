package com.apok.tutorialclickergame;

import com.apok.tutorialclickergame.screens.SplashScreen;
import com.apok.tutorialclickergame.service.PassiveIncomeService;
import com.apok.tutorialclickergame.service.ScoreService;
import com.apok.tutorialclickergame.service.SoundService;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;

public class TutorialClickerGame extends Game {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Tutorial Clicker";
	private boolean paused;

	private SoundService soundService;
	private ScoreService scoreService;

	private PassiveIncomeService passiveIncomeService;

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		soundService = new SoundService();
		scoreService = new ScoreService();
		passiveIncomeService = new PassiveIncomeService(scoreService);
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

	public SoundService getSoundService() {
		return soundService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public PassiveIncomeService getPassiveIncomeService() {
		return passiveIncomeService;
	}
}
