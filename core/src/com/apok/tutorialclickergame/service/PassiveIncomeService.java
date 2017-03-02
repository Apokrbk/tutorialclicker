package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Apok on 01.03.2017.
 */

public class PassiveIncomeService {

    private ScoreService scoreService;
    private final static int INFINITE = 100000000;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
        calculateGainedPassiveIncome();
    }

    public void start()
    {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPassiveIncome());
            }
        }, 1,1, INFINITE);
    }

    private void calculateGainedPassiveIncome() {
        long savedTimeStamp = scoreService.getSavedTimestamp();
        if(savedTimeStamp > 0)
        {
            long millisPassed = TimeUtils.timeSinceMillis(savedTimeStamp);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
            scoreService.addPoints((int)seconds * scoreService.getPassiveIncome()/10);
        }
        else
        {

        }

    }
}
