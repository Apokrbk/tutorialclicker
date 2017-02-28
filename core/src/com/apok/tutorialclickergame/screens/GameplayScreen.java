package com.apok.tutorialclickergame.screens;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.apok.tutorialclickergame.entities.FlyingObject;
import com.apok.tutorialclickergame.entities.Player;
import com.apok.tutorialclickergame.ui.IClickCallback;
import com.apok.tutorialclickergame.ui.PlayerButton;
import com.apok.tutorialclickergame.ui.ResetScoreButton;
import com.apok.tutorialclickergame.ui.ScoreLabel;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameplayScreen extends AbstractScreen {

    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private Image background;
    private ScoreLabel scoreLabel;
    private FlyingObject flyingObject;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    protected void init() {
        initBackground();
        initPlayer();
        initPlayerButton();
        initScoreLabel();
        initResetScoreButton();
        initFlyingObjects();
    }

    private void initFlyingObjects() {
        flyingObject = new FlyingObject(FlyingObject.MONEY);
        stage.addActor(flyingObject);
        flyingObject.fly();
    }

    private void initBackground() {
        background = new Image(new Texture("background.png"));
        stage.addActor(background);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }

    private void initScoreLabel() {
        scoreLabel = new ScoreLabel();
        stage.addActor(scoreLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
            }
        });
        stage.addActor(playerButton);
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
        scoreLabel.setText("SCORE: " + game.getPoints());
        stage.act();

    }
}
