package com.niklasviergewinnt.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ConnectFour extends ApplicationAdapter {
    SpriteBatch batch;
    Spielbrett spielbrett;

    private IOControl ioController;

    private Integer zaehler;

    private Spieler spieler1;

    private Spieler spieler2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        ioController = new IOControl();
        spielbrett = new Spielbrett (6, 8);
        zaehler = 0;
        spieler1 = new Spieler("Spieler1", "rot");
        spieler2 = new Spieler("Spieler2", "gelb");
    }

    @Override
    public void render() {
        Spieler spieler;
        if(zaehler % 2 == 0){
            spieler = spieler1;
        }else{
            spieler = spieler2;
        }
        Integer i = ioController.readUserInput(spieler);
        if(i < 0){
            this.dispose();
        }
        spielbrett.zug(spieler,i);

        if(spielbrett.checkGameWon()){
            Spieler s = spielbrett.getWinner();
            ioController.printMessageOnScreen(s+" hat gewonnen.");
        };

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



