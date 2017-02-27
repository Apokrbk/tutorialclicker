package com.apok.tutorialclickergame;

import com.apok.tutorialclickergame.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TutorialClickerGame extends Game {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Tutorial Clicker";
	private int points;

	private boolean paused;

	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	public void addPoint()
	{
		points++;
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
