package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Figur {

    private Spieler eigentuemer;

    // lege ein Feld für die Textur für Plättchen rot an

    // lege ein Feld für die Textur für Plättchen gelb an

    // Der Konstruktor bekommt auch einen Eigentümer übergeben, der auf das Feld eigentümer gespeichert werden muss
    public Figur(Spieler spieler){
        this.eigentuemer = spieler;
        // beide Texturen aus dem assets Verzeichnis in die Felder lädt
    }


    public void render(SpriteBatch batch, int x, int y) {
        // Die Figur gehört einem Eigentümer. Je nach dem, wer sie eingeworfen hat müssen wir sie rot oder gelb ein
        // färben. Entscheide anhand des Feldes im Eigentümer, ob das Plättchen rot oder gelb ist.


        // zeichne die ausgewählte Textur an die position zeile / spalte
    }
}
