package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Apok on 01.03.2017.
 */

public class ScoreService {

    private static final String GAME_PREFS = "com.apok.tutorialclickergame.prefs";
    private static final String GAME_SCORE = "com.apok.tutorialclickergame.prefs.score";
    private static final String GAME_PASSIVE_INCOME = "com.apok.tutorialclickergame.prefs.passiveincome";


    private int points;
    private int passiveIncome;
    private Preferences prefs;

    public ScoreService() {
        init();
    }

    public void addPassiveIncome() {
        passiveIncome++;
        updateSavedScoreInPrefs();
        System.out.println("passive: "+ passiveIncome);
    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
        loadPassiveIncome();
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);
    }

    private void loadPassiveIncome() {
        passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOME);
    }

    public void addPoints(int pointsToAdd)
    {
        points+= pointsToAdd;
        updateSavedScoreInPrefs();
    }

    private void updateSavedScoreInPrefs() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
        prefs.flush();
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
        updateSavedScoreInPrefs();
    }

    public int getPoints() {
        return points;
    }
}
