package com.niklasviergewinnt.game;

import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {

   Character tasteGedrückt;

   Spielbrett spielbrett;

   int zaehler;

   private Spieler spieler1;

   private Spieler spieler2;

   private Boolean leave;


   public MyInputProcessor(Spielbrett s, Spieler sp1, Spieler sp2 ) {
        zaehler=0;
       spielbrett = s;
       spieler1 = sp1;
       spieler2 = sp2;
       leave = false ;
   }

    @Override
    public boolean keyTyped(char character) {
        tasteGedrückt = character;

       int neu = Character.getNumericValue(character );

        Spieler spieler;
        if(zaehler % 2 == 0){
            spieler = spieler1;
        }else{
            spieler = spieler2;
        }
        // game is running ?

        if (spielbrett.isGameIsRunning()){

            spielbrett.zug(spieler,neu);
            zaehler++;
        }

        if( character == 'q'){
            leave = true;
        } else {
            leave = false;
        }

        return leave;

    }

    public Boolean getLeave() {
        return leave;
    }

    public void setLeave(Boolean leave) {
        this.leave = leave;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
