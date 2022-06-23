package com.niklasviergewinnt.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ConnectFour extends ApplicationAdapter {
    SpriteBatch batch;
    Spielbrett spielbrett;

    private IOControl ioController;

    private Spieler spieler1;

    private Spieler spieler2;

    private MyInputProcessor ip;

    private boolean firstrender;

    @Override
    public void create() {
        batch = new SpriteBatch();
        spieler1 = new Spieler("Spieler1", "rot");
        spieler2 = new Spieler("Spieler2", "gelb");
        spielbrett = new Spielbrett (6, 8);
        ip = new MyInputProcessor(spielbrett,spieler1, spieler2);
        ioController = new IOControl(ip);
        Gdx.input.setInputProcessor(ip);
        firstrender = true;
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 1, 1);
        batch.begin();
        spielbrett.render(batch);
        Spieler s = spielbrett.checkGameWon();
        if(s != null){
            ioController.printMessageOnScreen(s.getName()+" hat gewonnen." , batch, 32, 32);
        }
        if(ip.getLeave() == true){
            dispose();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        spielbrett.dispose();

    }

}



