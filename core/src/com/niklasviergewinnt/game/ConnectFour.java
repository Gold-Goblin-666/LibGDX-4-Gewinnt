package com.niklasviergewinnt.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ConnectFour extends ApplicationAdapter {
    SpriteBatch batch;
    Spielbrett spielbrett;

    @Override
    public void create() {
        batch = new SpriteBatch();

        spielbrett = new Spielbrett (6, 8);


    }

    @Override
    public void render() {

        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        spielbrett.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        spielbrett.dispose();

    }

}



