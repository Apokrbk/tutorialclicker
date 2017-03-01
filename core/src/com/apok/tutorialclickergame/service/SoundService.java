package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Apok on 01.03.2017.
 */

public class SoundService {
    private Sound moneySound;
    public SoundService()
    {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("coins.wav"));
    }

    public void playMoneySound()
    {
        moneySound.play();
    }
}
