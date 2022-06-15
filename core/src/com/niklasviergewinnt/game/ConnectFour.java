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

    private Integer zaehler;

    private Spieler spieler1;

    private Spieler spieler2;

    private MyInputProcessor ip;

    private boolean firstrender;

    @Override
    public void create() {
        batch = new SpriteBatch();
        ip = new MyInputProcessor();
        ioController = new IOControl(ip);
        spielbrett = new Spielbrett (6, 8);
        zaehler = 0;
        spieler1 = new Spieler("Spieler1", "rot");
        spieler2 = new Spieler("Spieler2", "gelb");
        Gdx.input.setInputProcessor(ip);
        firstrender = true;


    }

    @Override
    public void render() {

        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();
        Spieler spieler;
        if(zaehler % 2 == 0){
            spieler = spieler1;
        }else{
            spieler = spieler2;
        }
        spielbrett.render(batch);
        Integer i = null;

        if (firstrender == false) {
            try {
                i = ioController.readUserInput(spieler, batch);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i < 0){
                this.dispose();
            }
            spielbrett.zug(spieler,i);

        }

        firstrender = false ;

//        if(spielbrett.checkGameWon()){
//            Spieler s = spielbrett.getWinner();
//            ioController.printMessageOnScreen(s+" hat gewonnen." , batch, 32, 32);
//        };

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        spielbrett.dispose();

    }

}



