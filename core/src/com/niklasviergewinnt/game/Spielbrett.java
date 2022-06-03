package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Spielbrett {
    private final Texture rahmen;

    private final List <Figur> spielfiguren;
    
    int anzahlZeilen;
    int anzahlSpalten;

    public Spielbrett(int anzahlZeilen, int anzahlSpalten) {
        this.anzahlZeilen = anzahlZeilen;
        this.anzahlSpalten = anzahlSpalten;

        this.rahmen = new Texture("Rahmen.png");

        spielfiguren = new ArrayList<>();


    }

    public void render(SpriteBatch batch) {

        for (int s = 0; s < anzahlSpalten; s++) {
            for (int z = 0; z < anzahlZeilen; z++) {
                batch.draw(rahmen, s * 62 + 64, z * 62 + 64);
            }
        }

        for(Figur f : spielfiguren){
            f.render(batch);
        }

    }

    public void dispose() {
        rahmen.dispose();
    }

    public boolean zug(Spieler spieler, int spalte){


        // prüfe ob der zug möglich ist oder
        // die spalte voll ist oder
        // die spalte nicht existiert


        for (int s = 0; s < anzahlSpalten; s++) {
            for (int z = 0; z < anzahlZeilen; z++) {
                if (spielfiguren.get(z) == null) {

                }
            }
        }




        boolean frei = spielfiguren.isEmpty();
        if (frei == true){
            System.out.println("die Spalte ist leer");
        } else {
            System.out.println("die Spalte ist Voll");
        }


        // wenn zug nicht möglich gebe false zurück

        if (frei =! true){
            return false;

        }




        // berechne die zeile in der spalte, an die das Plättchen fällt

        // erzeuge eine Figur mit dem Eigentümer spieler an der Position spalte/zeile

        // füge das erzeugte plättchen der Liste spielfiguren hinzu


    }
}


