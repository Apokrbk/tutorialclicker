package com.apok.tutorialclickergame.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 27.02.2017.
 */

public class Player extends Image{
    private static final int WIDTH = 77;
    private static final int HEIGHT = 152;

    private static final int STARTING_X = 200;
    private static final int STARTING_Y = 300;

    public Player()
    {
        super(new Texture("badlogic.jpg"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }
}
