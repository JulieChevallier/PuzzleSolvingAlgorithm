package fr.umontpellier.iut;


import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Sudoku implements JeuPuzzle{

    private int[][] grille;

    // pré-requis : la grille est carrée
    public Sudoku(int[][] g) {
        this.grille = g;
    }

    @Override
    public boolean estGagnant() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if(grille[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean estValide(int i, int j, int nombre){
        int n = (int) sqrt(grille.length);
        int iBloc = i - i%n;
        int jBloc = j - j%n;

        //cas bloc
        for (int ligne = iBloc; ligne < iBloc + n ; ligne++) {
            for(int colonne = jBloc; colonne < jBloc + n ; colonne++){
                if(colonne != j && ligne !=i){
                    if(grille[ligne][colonne]==nombre) {
                        return false;
                    }
                }
            }
        }

        //cas ligne
        for(int k=0; k < grille.length; k++){
            if(grille[k][j]==nombre){
                return false;
            }

        //cas colonne
            if(grille[i][k]==nombre){
                return false;
            }
        }
        return true;
    }


    private int[] trouverTrou() {
        int longueurligne = grille.length;
        int longueurcol = grille[0].length;
        for (int i = 0; i < longueurligne; i++) {
            for (int j = 0; j < longueurcol ; j++) {
                if(grille[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Sudoku> genererFils(){
        ArrayList<Sudoku> resultat = new ArrayList<>();
        int[] trou=this.trouverTrou();
        for (int i = 1; i < grille.length+1; i++) {
            if (estValide(trou[0],trou[1],i)){
                int[][] copie = copie(grille);
                copie[trou[0]][trou[1]] =i;

                resultat.add(new Sudoku(copie));
            }
        }
        return resultat;
    }

    private int[][] copie(int[][] tab){
        int[][] tabcopie = new int[tab.length][tab[0].length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                tabcopie[i][j] = tab[i][j];
            }
        }
        return tabcopie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sudoku sudoku = (Sudoku) o;
        return Arrays.deepEquals(grille, sudoku.grille);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grille);
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < grille.length; i++) {
            str+="\n";
            for (int j = 0; j < grille[i].length; j++) {
                str+=grille[i][j] + " ";
            }
        }
        return str;
    }
}
