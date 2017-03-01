package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.utils.Timer;

/**
 * Created by Apok on 01.03.2017.
 */

public class PassiveIncomeService {

    private ScoreService scoreService;
    private final static int INFINITE = 100000000;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
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
}
