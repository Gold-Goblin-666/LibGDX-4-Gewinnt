package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class IOControl  {

    public IOControl(MyInputProcessor eingabe ){

       ip = eingabe;

    }

    private MyInputProcessor ip;


    public Integer readUserInput(Spieler spieler, Batch batch) throws InterruptedException {
        // zeichne Meldung auf den Bildschirm, die den Spieler auffordert eine Spalte zu wählen (printMessageOnScreen)

        printMessageOnScreen(spieler.getName() + " Bitte Wähle eine Spalte !" ,batch , 32 , 32);

        // Lese die Spaltennummer ein und gib sie zurück


        // wenn der User 'q' eingibt, beendet er das Spiel und wir geben hier -1 zurück

        while ( ip.tasteGedrückt == null ) {
            Thread.sleep(100 );

        }

        if ( ip.tasteGedrückt == 'q'){ 
            return -1;
        }
        else {
            char spalteGelegt = ip.tasteGedrückt;

            ip.tasteGedrückt = null;

            return Character.getNumericValue(spalteGelegt);
        }

    }


    public void printMessageOnScreen(String message, Batch batch , int x , int y){
        // zeichne die Meldung, die übergeben wurde auf den

        BitmapFont font = new BitmapFont();
//        font = new BitmapFont(Gdx.files.internal("data/nameOfFont.fnt"),
//                Gdx.files.internal("data/nameOfFont.png"), false);

        font.draw(batch, message , x , y);



    }
}
