package com.apok.tutorialclickergame.screens;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Apok on 27.02.2017.
 */

public class SplashScreen extends AbstractScreen{

    private Texture splashImg;


    public SplashScreen(final TutorialClickerGame game) {
        super(game);
        init();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        }, 1);
    }

    private void init() {
        //TODO implement better assets loading when game grows
        splashImg = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0,0);
        spriteBatch.end();
    }
}
