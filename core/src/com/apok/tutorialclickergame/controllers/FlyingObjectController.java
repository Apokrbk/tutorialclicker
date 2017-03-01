package com.apok.tutorialclickergame.controllers;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.apok.tutorialclickergame.entities.FlyingObject;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Apok on 01.03.2017.
 */

public class FlyingObjectController {

    private int spawnTime;

    public FlyingObjectController(Stage stage, TutorialClickerGame game)
    {
        init(stage, game);
    }

    private void init(final Stage stage, final TutorialClickerGame game) {
        randomizeSpawnTime();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                FlyingObject flyingObject = null;
                if(MathUtils.randomBoolean())
                {
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.MONEY, game);
                }
                else
                {
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
                }
                stage.addActor(flyingObject);
                flyingObject.fly();
                randomizeSpawnTime();
            }
        },0, spawnTime);
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5,10);
    }

}
