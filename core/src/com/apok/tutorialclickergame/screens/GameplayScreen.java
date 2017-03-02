package com.apok.tutorialclickergame.screens;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.apok.tutorialclickergame.controllers.FlyingObjectController;
import com.apok.tutorialclickergame.entities.Player;
import com.apok.tutorialclickergame.ui.BasicDialog;
import com.apok.tutorialclickergame.ui.IClickCallback;
import com.apok.tutorialclickergame.ui.PlayerButton;
import com.apok.tutorialclickergame.ui.ResetScoreButton;
import com.apok.tutorialclickergame.ui.GameLabel;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameplayScreen extends AbstractScreen {

    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private Image background;
    private GameLabel gameLabel;
    private FlyingObjectController flyingObjectController;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    protected void init() {
        initBackground();
        initPlayer();
        initPlayerButton();
        initScoreLabel();
        initResetScoreButton();
        initFlyingObjectController();
        game.getSoundService().playBackgroundMusic();
        game.getPassiveIncomeService().start();
        initPassiveIncomeInfoDialog();
    }

    private void initPassiveIncomeInfoDialog() {
        if(game.getPassiveIncomeService().getPointsToAdd() > 0)
        {
            BasicDialog dialog = new BasicDialog();
            stage.addActor(dialog);
            dialog.initContent("Passive income gained: " + game.getPassiveIncomeService().getPointsToAdd());
        }

    }

    private void initFlyingObjectController() {
        flyingObjectController = new FlyingObjectController(stage, game);
    }

    private void initBackground() {
        background = new Image(new Texture("background.png"));
        stage.addActor(background);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentGamestate();
    }

    private void initScoreLabel() {
        gameLabel = new GameLabel();
        stage.addActor(gameLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.getScoreService().addPoints(1);
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
        gameLabel.setText("SCORE: " + game.getScoreService().getPoints());
        stage.act();

    }
}
