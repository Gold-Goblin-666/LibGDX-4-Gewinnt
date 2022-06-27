package com.niklasviergewinnt.game;


public class Spieler {

    private String name;

    private boolean istRot;

    public Spieler(String name, String farbe) {
        this.name = name;
        if (farbe == "rot") {
            istRot = true;
        }else {
            istRot = false ;

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIstRot() {
        return istRot;
    }

    public void setIstRot(boolean istRot) {
        this.istRot = istRot;
    }

}
