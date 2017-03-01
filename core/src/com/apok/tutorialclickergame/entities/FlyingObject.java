package com.apok.tutorialclickergame.entities;

import com.apok.tutorialclickergame.TutorialClickerGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by Apok on 28.02.2017.
 */

public class FlyingObject extends Image {



    public enum FlyingObjectType{
        MONEY, PASSIVE
    }

    public final static String MONEY = "money.png";
    private static final String PASSIVE = "passive.png";
    private final static int WIDTH = 50;
    private final static int HEIGHT = 50;
    private static final int STARTING_Y = -100;
    private static final int STARTING_X_1 = 0;
    private static final int STARTING_X_2 = TutorialClickerGame.WIDTH;
    private int startingX;
    private FlyingObjectType type;
    private TutorialClickerGame game;

    public FlyingObject(FlyingObjectType type, TutorialClickerGame game) {
        super(new Texture(getTextureString(type)));
        this.type = type;
        this.game = game;
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        startingX = MathUtils.randomBoolean() ? STARTING_X_1 : STARTING_X_2;
        this.setPosition(startingX, STARTING_Y);
        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                reactOnClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void reactOnClick() {
        if(FlyingObjectType.MONEY.equals(type))
            game.getScoreService().addPoints(50);
        else if(FlyingObjectType.PASSIVE.equals(type))
            game.getScoreService().addPassiveIncome();
        game.getSoundService().playMoneySound();
        FlyingObject.this.remove();
    }

    private static String getTextureString(FlyingObjectType type) {
        if(FlyingObjectType.MONEY.equals(type))
            return MONEY;
        else if(FlyingObjectType.PASSIVE.equals(type))
            return PASSIVE;
        else
            return "";
    }

    public void fly()
    {
        int xSign = 0;
        xSign = startingX == STARTING_X_1 ? 1 : -1;
        Action actionA= Actions.parallel(
                Actions.moveBy(xSign*300+(MathUtils.random(-200,200)),200,MathUtils.random(1,4)),
                Actions.rotateBy(360,MathUtils.random(1,3))
        );

        Action actionB = Actions.parallel(
                Actions.moveBy(xSign*(-500),900,MathUtils.random(1,3)),
                Actions.rotateBy(360,3)
        );

        Action actionC = Actions.run(new Runnable() {
            @Override
            public void run() {
                reactOnClick();
            }
        });

        this.addAction(Actions.sequence(actionA, actionB, actionC));

    }
}
