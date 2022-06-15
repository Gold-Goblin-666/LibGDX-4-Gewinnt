package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class IOControl {


    public Integer readUserInput(Spieler spieler, Batch batch){
        // zeichne Meldung auf den Bildschirm, die den Spieler auffordert eine Spalte zu wählen (printMessageOnScreen)

        printMessageOnScreen(spieler.getName() + " Bitte Wähle eine Spalte !" ,batch , 32 , 32);

        // Lese die Spaltennummer ein und gib sie zurück

        



        // wenn der User 'q' eingibt, beendet er das Spiel und wir geben hier -1 zurück
        return 0;
    }


    public void printMessageOnScreen(String message, Batch batch , int x , int y){
        // zeichne die Meldung, die übergeben wurde auf den

        BitmapFont font = new BitmapFont();
//        font = new BitmapFont(Gdx.files.internal("data/nameOfFont.fnt"),
//                Gdx.files.internal("data/nameOfFont.png"), false);



        font.draw(batch, message , x , y);



    }
}
