package com.apok.tutorialclickergame.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Apok on 01.03.2017.
 */

public class SoundService {
    private Sound moneySound;
    private Music backgroundMusic;
    public SoundService()
    {
        init();
    }

    private void init() {
        moneySound = Gdx.audio.newSound(Gdx.files.internal("coins.wav"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
    }

    public void playMoneySound()
    {
        moneySound.play();
    }

    public void playBackgroundMusic()
    {
        backgroundMusic.play();
        backgroundMusic.setLooping(true);
    }
}
