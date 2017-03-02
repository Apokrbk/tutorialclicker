package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by Apok on 01.03.2017.
 */

public class ScoreService {

    private static final String GAME_PREFS = "com.apok.tutorialclickergame.prefs";
    private static final String GAME_SCORE = "com.apok.tutorialclickergame.prefs.score";
    private static final String GAME_PASSIVE_INCOME = "com.apok.tutorialclickergame.prefs.passiveincome";
    private static final String GAME_SAVED_TIMESTAMP = "com.apok.tutorialclickergame.prefs.savedtimestamp";



    private int points;

    private int passiveIncome;
    private Preferences prefs;

    public ScoreService() {
        init();
    }

    public void addPassiveIncome() {
        passiveIncome++;
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

    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
    }

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }

    public long getSavedTimestamp()
    {
        return prefs.getLong(GAME_SAVED_TIMESTAMP);
    }

    public void saveCurrentGamestate() {
        prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
        prefs.flush();
    }
}
