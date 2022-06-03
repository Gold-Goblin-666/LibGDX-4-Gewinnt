package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Figur {

    private Spieler eigentuemer;

    private int spalte;

    private  int zeile;

    // lege ein Feld für die Textur für Plättchen rot an

    // lege ein Feld für die Textur für Plättchen gelb an

    // lege eine Konstruktor-Funktion an, der beide Texturen aus dem assets Verzeichnis in die Felder lädt

    public void render(SpriteBatch batch) {
        // Entscheide anhand des eigentümers, ob rot oder gelb gezeichnet werden soll und wähle die richtige Textur aus

        // zeichne die ausgewählte Textur an die position zeile / spalte
    }
}
