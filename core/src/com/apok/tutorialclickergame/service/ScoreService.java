package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Apok on 01.03.2017.
 */

public class ScoreService {

    private static final String GAME_PREFS = "com.apok.tutorialclickergame.prefs";
    private static final String GAME_SCORE = "com.apok.tutorialclickergame.prefs.score";

    private int points;
    private Preferences prefs;

    public ScoreService() {
        init();
    }

    public void addPassiveIncome() {
        System.out.println("passive income click");
    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
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

    public int getPoints() {
        return points;
    }
}
