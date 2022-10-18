package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Couple {

    private JeuPuzzle jeuPuzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle jeuPuzzle, Couple predecesseur) {
        this.jeuPuzzle = jeuPuzzle;
        this.predecesseur = predecesseur;
    }

    public void mettreAJour(LinkedList<Couple> frontiere, HashSet<JeuPuzzle> dejaVus) {
        ArrayList<? extends JeuPuzzle> taquinSuivant = jeuPuzzle.genererFils();
        for (int i = 0; i < taquinSuivant.size(); i++) {
            if(!dejaVus.contains(taquinSuivant.get(i))){
                dejaVus.add(taquinSuivant.get(i));
                frontiere.add(new Couple(taquinSuivant.get(i),this));
            }
        }
    }

    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> mouvementsPossible = new ArrayList<>();
        mouvementsPossible.add(jeuPuzzle);
        Couple suivant=this;

        while(suivant.predecesseur !=null){
            mouvementsPossible.add(suivant.predecesseur.getJeuPuzzle());
            suivant = suivant.predecesseur;
        }
        Collections.reverse(mouvementsPossible);
        return mouvementsPossible;
    }

    public JeuPuzzle getJeuPuzzle() {
        return jeuPuzzle;
    }
}
