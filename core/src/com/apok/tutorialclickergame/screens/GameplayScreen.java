package com.apok.tutorialclickergame.screens;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.apok.tutorialclickergame.entities.Player;

/**
 * Created by Apok on 27.02.2017.
 */

public class GameplayScreen extends AbstractScreen {

    private Player player;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    protected void init() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
