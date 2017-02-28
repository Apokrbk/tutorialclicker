package com.apok.tutorialclickergame.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ResetScoreButton extends Button {
    public ResetScoreButton(IClickCallback callback) {
        super(prepareButtonStyle());
        init(callback);
    }

    private static ButtonStyle prepareButtonStyle() {
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("ui-blue.atlas"));
        Skin skin = new Skin(textureAtlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_01");
        buttonStyle.down = skin.getDrawable("button_02");
        return buttonStyle;

    }

    private void init(final IClickCallback callback) {
        this.setHeight(50);
        this.setWidth(50);
        this.setX(150);
        this.setY(650);
        
        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
