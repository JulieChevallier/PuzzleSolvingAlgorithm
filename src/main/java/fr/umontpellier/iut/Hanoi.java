package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Objects;

public class Hanoi implements JeuPuzzle{
    private ArrayList<Integer> tour1;
    private ArrayList<Integer> tour2;
    private ArrayList<Integer> tour3;
    private int taille;

    public Hanoi(int taille) {
        /* crée un hanoi avec la configuration suivante :
                * sur la tour 1 les disques [taille,taille-1, .., 1]
                * rien sur les tour 2 et 3 (elles sont vides)

         */
        this.tour1 = new ArrayList<>();
        this.tour2 = new ArrayList<>();
        this.tour3 = new ArrayList<>();
        this.taille=taille;

        for (int i = taille; i > 0; i--) {
            tour1.add(i);
        }
    }


    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        /*
        Crée un hanoi où la tour 1 (resp. tour 2 et tour 3) contient les entiers de tour1 (resp. tour2 et tour3). Par exemple,
        si tour1 est une ArrayList contenant [3,2,1], et tour2 et tour3 sont des ArrayList vides, alors
        Hanoi(tour1, tour2, tour3) doit créer la même configuration que Hanoi(3).
         */
        this.taille = taille;
        this.tour1 = new ArrayList<>();
        this.tour2 = new ArrayList<>();
        this.tour3 = new ArrayList<>();

        this.tour1.addAll(tour1);
        this.tour2.addAll(tour2);
        this.tour3.addAll(tour3);


    }

    @Override
    public String toString() {
        return "Hanoi{" + "\n"+
                "tour1=" + tour1 + "\n"+
                "tour2=" + tour2 + "\n"+
                "tour3=" + tour3 + "\n"+
                "taille=" + taille +  "\n"+
                '}' + "\n";
    }

    @Override
    public boolean estGagnant() {
        return this.tour3.size() == taille;
    }


    @Override
    public ArrayList<Hanoi> genererFils() {
        ArrayList<Hanoi> filsPossible = new ArrayList<>();
        if(!tour1.isEmpty()){
            if(tour2.isEmpty() || tour2.get(tour2.size()-1)>tour1.get(tour1.size()-1)){
                //tour1 to tour2
                ArrayList<Integer> nvTour1 = copyL(tour1);
                ArrayList<Integer> nvTour2 = copyL(tour2);
                nvTour2.add(nvTour1.get(nvTour1.size()-1));
                nvTour1.remove(nvTour1.size()-1);
                Hanoi h = new Hanoi(nvTour1, nvTour2, tour3,taille);
                filsPossible.add(h);
            }
            if(tour3.isEmpty() || tour3.get(tour3.size()-1)>tour1.get(tour1.size()-1)){
                //tour1 to tour3
                ArrayList<Integer> nvTour1 = copyL(tour1);
                ArrayList<Integer> nvTour3 = copyL(tour3);
                nvTour3.add(nvTour1.get(nvTour1.size()-1));
                nvTour1.remove(nvTour1.size()-1);
                filsPossible.add(new Hanoi(nvTour1, tour2 , nvTour3,taille));
            }
        }
        if(!tour2.isEmpty()){
            if(tour1.isEmpty() || tour1.get(tour1.size()-1)>tour2.get(tour2.size()-1)){
                //tour2 to tour1
                ArrayList<Integer> nvTour2 = copyL(tour2);
                ArrayList<Integer> nvTour1 = copyL(tour1);
                nvTour1.add(nvTour2.get(nvTour2.size()-1));
                nvTour2.remove(nvTour2.size()-1);
                Hanoi h = new Hanoi(nvTour1, nvTour2 , tour3,taille);
                filsPossible.add(h);
            }
            if(tour3.isEmpty() || tour3.get(tour3.size()-1)>tour2.get(tour2.size()-1)){
                //tour2 to tour3
                ArrayList<Integer> nvTour2 = copyL(tour2);
                ArrayList<Integer> nvTour3 = copyL(tour3);
                nvTour3.add(nvTour2.get(nvTour2.size()-1));
                nvTour2.remove(nvTour2.size()-1);
                Hanoi h = new Hanoi(tour1, nvTour2 , nvTour3,taille);
                filsPossible.add(h);
            }
        }
        if(!tour3.isEmpty()){
            if(tour1.isEmpty() || tour1.get(tour1.size()-1)>tour3.get(tour3.size()-1)){
                //tour3 to tour1
                ArrayList<Integer> nvTour3 = copyL(tour3);
                ArrayList<Integer> nvTour1 = copyL(tour1);
                nvTour1.add(nvTour3.get(nvTour3.size()-1));
                nvTour3.remove(nvTour3.size()-1);
                Hanoi h = new Hanoi(nvTour1, tour2 , nvTour3,taille);
                filsPossible.add(h);
            }
            if(tour2.isEmpty() || tour2.get(tour2.size()-1)>tour3.get(tour3.size()-1)){
                //tour3 to tour2
                ArrayList<Integer> nvTour3 = copyL(tour3);
                ArrayList<Integer> nvTour2 = copyL(tour2);
                nvTour2.add(nvTour3.get(nvTour3.size()-1));
                nvTour3.remove(nvTour3.size()-1);
                Hanoi h = new Hanoi(tour1, nvTour2 , nvTour3,taille);
                filsPossible.add(h);
            }
        }
        return filsPossible;
    }
    private ArrayList<Integer> copyL(ArrayList<Integer> tour){
        ArrayList<Integer> t=new ArrayList<>();
        t.addAll(tour);
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return taille == hanoi.taille && Objects.equals(tour1, hanoi.tour1) && Objects.equals(tour2, hanoi.tour2) && Objects.equals(tour3, hanoi.tour3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tour1, tour2, tour3, taille);
    }
}
