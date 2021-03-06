package com.niklasviergewinnt.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Spielbrett {
    private final Texture rahmen;

    private final Map<Point, Figur> spielfigurenGesetzt;

    private int anzahlZeilen;
    private int anzahlSpalten;

    private boolean gameIsRunning;

    public Spielbrett(int anzahlZeilen, int anzahlSpalten) {
        this.anzahlZeilen = anzahlZeilen;
        this.anzahlSpalten = anzahlSpalten;

        this.rahmen = new Texture("Rahmen.png");

        spielfigurenGesetzt = new HashMap<>();

        gameIsRunning = true ;
    }

    public void render(SpriteBatch batch) {

        for (int s = 0; s < anzahlSpalten; s++) {
            for (int z = 0; z < anzahlZeilen; z++) {
                batch.draw(rahmen, s * 62 + 64, z * 62 + 64);
            }
        }

        for(Point p : spielfigurenGesetzt.keySet()){
            Figur f = spielfigurenGesetzt.get(p);
            f.render(batch, p.x * 62 + 64, p.y * 62 + 64);
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
        for( int z = anzahlZeilen-1; z >=-1; z--){
            Point p = new Point(spalte, z);
            if(spielfigurenGesetzt.get(p) != null || z == -1){
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

    public Spieler checkGameWon() {
        // Hat einer gewonnen?


        for ( int spalte = 0; spalte < anzahlSpalten; spalte ++){
            for( int zeile = 0; zeile < anzahlZeilen ; zeile ++){





                //spalten  nach rechts:


                if(spalte < anzahlSpalten - 3) {

                    Figur f1 = extracted(spalte, zeile);
                    Figur f2 = extracted(spalte + 1, zeile);
                    Figur f3 = extracted(spalte + 2, zeile);
                    Figur f4 = extracted(spalte + 3, zeile);

                    if(     f1 != null && f2 != null && f3 != null && f4 != null &&
                            f1.getEigentuemer() == f2.getEigentuemer() &&
                            f2.getEigentuemer() == f3.getEigentuemer() &&
                            f3.getEigentuemer() == f4.getEigentuemer()  ){

                        gameIsRunning = false;

                        return f1.getEigentuemer();

                    }

                }

                //Zeilen nach unten:

                if(zeile < anzahlZeilen - 3 ){

                    Figur f1 = extracted(spalte, zeile);
                    Figur f2 = extracted(spalte, zeile + 1);
                    Figur f3 = extracted(spalte, zeile + 2);
                    Figur f4 = extracted(spalte, zeile + 3);

                    if(     f1 != null && f2 != null && f3 != null && f4 != null &&
                            f1.getEigentuemer() == f2.getEigentuemer() &&
                            f2.getEigentuemer() == f3.getEigentuemer() &&
                            f3.getEigentuemer() == f4.getEigentuemer()  ){

                        gameIsRunning = false;

                        return f1.getEigentuemer();

                    }

                }

                // Diagonal Rechts unten:

                if(spalte < anzahlSpalten - 3 && zeile < anzahlZeilen - 3 ){

                    Figur f1 = extracted(spalte, zeile);
                    Figur f2 = extracted(spalte + 1, zeile + 1);
                    Figur f3 = extracted(spalte + 2, zeile + 2);
                    Figur f4 = extracted(spalte + 3, zeile + 3);

                    if(     f1 != null && f2 != null && f3 != null && f4 != null &&
                            f1.getEigentuemer() == f2.getEigentuemer() &&
                            f2.getEigentuemer() == f3.getEigentuemer() &&
                            f3.getEigentuemer() == f4.getEigentuemer()  ){

                        gameIsRunning = false;

                        return f1.getEigentuemer();

                    }

                }

                // Diagonal Links unten:

                if( zeile < anzahlZeilen - 3 && spalte > 3){

                    Figur f1 = extracted(spalte, zeile);
                    Figur f2 = extracted(spalte - 1, zeile + 1);
                    Figur f3 = extracted(spalte - 2, zeile + 2);
                    Figur f4 = extracted(spalte - 3, zeile + 3);

                    if(     f1 != null && f2 != null && f3 != null && f4 != null &&
                            f1.getEigentuemer() == f2.getEigentuemer() &&
                            f2.getEigentuemer() == f3.getEigentuemer() &&
                            f3.getEigentuemer() == f4.getEigentuemer()  ){

                        gameIsRunning = false;

                        return f1.getEigentuemer();

                    }

                }

            }

        }

        return null;

    }

    private Figur extracted(int spalte, int zeile) {
        Point p = new Point(spalte, zeile);
        if(spielfigurenGesetzt.containsKey(p)) {
            Figur f = spielfigurenGesetzt.get(p);
            return f;
        }else{
            return null;
        }
    }

    public boolean isGameIsRunning() {
        return gameIsRunning;
    }

    public void setGameIsRunning(boolean gameIsRunning) {
        this.gameIsRunning = gameIsRunning;
    }






}


