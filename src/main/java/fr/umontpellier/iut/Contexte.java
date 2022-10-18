package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Contexte {

    private JeuPuzzle jeuPuzzle;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle jeuPuzzle) {
        this.jeuPuzzle = jeuPuzzle;
        solution = new ArrayList<>();
    }

    public void resoudre() {
        HashSet<JeuPuzzle> dejaVus = new HashSet<>();
        LinkedList<Couple> frontiere = new LinkedList<>();
        dejaVus.add(jeuPuzzle);
        frontiere.add(new Couple(jeuPuzzle,null));

        Couple coupleCourant= frontiere.get(0);
        while(!coupleCourant.getJeuPuzzle().estGagnant() && !frontiere.isEmpty()){
            frontiere.get(0).mettreAJour(frontiere,dejaVus);
            frontiere.remove(0);
            coupleCourant=frontiere.get(0);
        }
        if(!frontiere.isEmpty()){
            solution = coupleCourant.getListeDeMouvements();
        }
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < solution.size(); i++) {
            str += "solution : "+ i + "\n";
            str += solution.get(i).toString();
        }
        return str;
    }

    //Question 4, Exercice 3 : C'est la taille de la frontiere que l'on peut afficher pour voir si ça progresse.
}
