package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spielbrett {
    private final Texture rahmen;

    private final Map<Point, Figur> spielfigurenGesetzt;

    private int anzahlZeilen;
    private int anzahlSpalten;

    public Spielbrett(int anzahlZeilen, int anzahlSpalten) {
        this.anzahlZeilen = anzahlZeilen;
        this.anzahlSpalten = anzahlSpalten;

        this.rahmen = new Texture("Rahmen.png");

        spielfigurenGesetzt = new HashMap<>();
    }

    public void render(SpriteBatch batch) {

        for (int s = 0; s < anzahlSpalten; s++) {
            for (int z = 0; z < anzahlZeilen; z++) {
                batch.draw(rahmen, s * 62 + 64, z * 62 + 64);
            }
        }

        for(Point p : spielfigurenGesetzt.keySet()){
            Figur f = spielfigurenGesetzt.get(p);
            f.render(batch, p.x, p.y);
        }

    }

    public void dispose() {
        rahmen.dispose();
    }

    public boolean zug(Spieler spieler, int spalte){
        // prüfe ob der zug möglich ist oder
        // die spalte voll ist oder
        // die spalte nicht existiert

        // wenn zug nicht möglich gebe false zurück
        Point obersteZeileInUnsererSpalte = new Point(spalte, anzahlZeilen-1);
        if( spielfigurenGesetzt.get(obersteZeileInUnsererSpalte) != null ||
            spalte < 0 ||
            spalte > anzahlSpalten - 1) {
            return false;
        }

        // berechne die zeile in der spalte, an die das Plättchen fällt               (auf map zugegriffen )
        Point positionVonDerNeuenFigur = null;
        for( int z = anzahlZeilen-1; z >=0; z--){
            Point p = new Point(spalte, z);
            if(spielfigurenGesetzt.get(p) != null){
               positionVonDerNeuenFigur = new Point(spalte, z+1);
               break;
            }
        }

        // erzeuge eine Figur mit dem Eigentümer spieler an der Position spalte/zeile
        Figur f = new Figur(spieler);

        // füge das erzeugte plättchen der Liste spielfiguren hinzu
        spielfigurenGesetzt.put(positionVonDerNeuenFigur, f);

        return true;
    }

    public boolean checkGameWon() {
        // Hat einer gewonnen?

        return true;


    }

    public Spieler getWinner() {
        //Gib den Spieler zurück, der gewonnen hat

        return new Spieler(" ", "rot" );
    }
}


