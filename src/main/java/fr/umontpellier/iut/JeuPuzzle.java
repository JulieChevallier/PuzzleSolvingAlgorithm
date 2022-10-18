package fr.umontpellier.iut;

import java.util.ArrayList;

public interface JeuPuzzle {
    boolean estGagnant();
    ArrayList<? extends JeuPuzzle> genererFils();
}
