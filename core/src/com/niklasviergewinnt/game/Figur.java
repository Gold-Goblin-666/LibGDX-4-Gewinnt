package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Figur {

    private Spieler eigentuemer;

    // lege ein Feld / Instanzvariable für die Textur für Plättchen rot an
    private Texture plaettchenRot;

    // lege ein Feld / Instanzvariable für die Textur für Plättchen gelb an
    private Texture plaettchenGelb;


    // Der Konstruktor bekommt auch einen Eigentümer übergeben, der auf das Feld / die Instanzvariable eigentümer gespeichert werden muss
    public Figur(Spieler spieler) {
        this.eigentuemer = spieler;

        // beide Texturen aus dem assets Verzeichnis in die Felder / die Instanzvariableen laden
        this.plaettchenRot = new Texture("Rot.png");
        this.plaettchenGelb = new Texture("Gelb.png");

    }


    public void render(SpriteBatch batch, int x, int y) {
        // Die Figur gehört einem Eigentümer. Je nach dem, wer sie eingeworfen hat müssen wir sie rot oder gelb ein
        // färben. Entscheide anhand des Feldes / die Instanzvariable im Eigentümer, ob das Plättchen rot oder gelb ist.

        Texture t ;

        if (eigentuemer.isIstRot() == true) {
            t = plaettchenRot;
        } else {
            t = plaettchenGelb;
        }

        // zeichne die ausgewählte Textur an die position zeile / spalte
        batch.draw(t, x, y);
       }

    public Spieler getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(Spieler eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    public Texture getPlaettchenRot() {
        return plaettchenRot;
    }

    public void setPlaettchenRot(Texture plaettchenRot) {
        this.plaettchenRot = plaettchenRot;
    }

    public Texture getPlaettchenGelb() {
        return plaettchenGelb;
    }

    public void setPlaettchenGelb(Texture plaettchenGelb) {
        this.plaettchenGelb = plaettchenGelb;
    }
}
