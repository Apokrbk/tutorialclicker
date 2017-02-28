package com.apok.tutorialclickergame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Apok on 28.02.2017.
 */

public class FlyingObject extends Image {
    public final static String MONEY = "money.png";
    private final static int WIDTH = 100;
    private final static int HEIGHT = 100;
    private static final int STARTING_Y = -100;
    private static final int STARTING_X = 0;

    public FlyingObject(String texture) {
        super(new Texture(texture));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                FlyingObject.this.remove();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void fly()
    {
        Action actionA= Actions.parallel(
                Actions.moveBy(300,200,5),
                Actions.rotateBy(360,5)
        );

        Action actionB = Actions.parallel(
                Actions.moveBy(-500,900,3),
                Actions.rotateBy(360,3)
        );

        Action actionC = Actions.run(new Runnable() {
            @Override
            public void run() {
                FlyingObject.this.remove();
            }
        });

        this.addAction(Actions.sequence(actionA, actionB, actionC));

    }
}
