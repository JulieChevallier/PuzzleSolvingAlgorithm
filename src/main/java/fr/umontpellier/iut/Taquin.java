package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Taquin implements JeuPuzzle {
    private int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }


    public boolean estGagnant() {
        int compteur = 1;
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if(tableau[tableau.length-1][tableau[i].length-1]==0 && i == tableau.length - 1 && j == tableau[i].length - 1){
                    return true;
                }
                if (compteur != tableau[i][j]) {
                    return false;
                }

                compteur+=1;
            }
        }
        return false;
    }


    public ArrayList<Taquin> genererFils() {
        int[] trou0 = this.trouverTrou();
        ArrayList<Taquin> taquinPosible = new ArrayList<>();

        if(trou0[0]!=0){//pas coller à gauche
            Taquin gauchePossible = copyTaquin();
            gauchePossible.tableau[trou0[0]][trou0[1]] = gauchePossible.tableau[trou0[0]-1][trou0[1]];
            gauchePossible.tableau[trou0[0]-1][trou0[1]]=0;
            taquinPosible.add(gauchePossible);
        }
        if(trou0[1]!=this.tableau.length-1){ //pas coller à droite
            Taquin droitePossible = copyTaquin();
            droitePossible.tableau[trou0[0]][trou0[1]] = droitePossible.tableau[trou0[0]][trou0[1]+1];
            droitePossible.tableau[trou0[0]][trou0[1]+1]=0;
            taquinPosible.add(droitePossible);
        }
        if(trou0[1]!=0) {//pas coller en haut
            Taquin hautPossible = copyTaquin();
            hautPossible.tableau[trou0[0]][trou0[1]] = hautPossible.tableau[trou0[0]][trou0[1]-1];
            hautPossible.tableau[trou0[0]][trou0[1]-1]=0;
            taquinPosible.add(hautPossible);
        }
        if(trou0[0]!=this.tableau[this.tableau.length-1].length-1){//pas coller en bas
            Taquin basPossible = copyTaquin();
            basPossible.tableau[trou0[0]][trou0[1]] = basPossible.tableau[trou0[0]+1][trou0[1]];
            basPossible.tableau[trou0[0]+1][trou0[1]]=0;
            taquinPosible.add(basPossible);
        }
        return taquinPosible;
    }

    private Taquin copyTaquin(){
        int[][] helloWorld = new int[tableau.length][tableau[tableau.length-1].length];
        Taquin maPetiteCopy = new Taquin(helloWorld);
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                maPetiteCopy.tableau[i][j]=tableau[i][j];
            }
        }
        return maPetiteCopy;
    }

    /**
     * @return un tableau [i,j] si tableau[i][j]==0
     */
    public int[] trouverTrou() {
        int[] tableauResult = new int[2];
        for(int i=0; i< tableau.length;i++){
            for(int j=0; j<tableau[i].length;j++){
                if(tableau[i][j]==0){
                    tableauResult[0]=i;
                    tableauResult[1]=j;
                }
            }
        }
        return tableauResult;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tableau);
    }

    @Override
    public boolean equals(Object obj) {
        if( obj==this){
            return true;
        }
        if( obj==null || obj.getClass() != getClass()){
            return false;
        }
        Taquin a = (Taquin) obj;
        return Arrays.deepEquals(tableau,a.tableau);
    }

    @Override
    public String toString() {
        String str = "";
        int compteur = 0;
        int anciencompteur = 0;
        for (int i = 0; i < tableau.length; i++) {
            str += "|";
            if (compteur > anciencompteur) {
                anciencompteur = compteur;
            }
            compteur = 0;
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] < 10) {
                    str += " ";
                    compteur++;
                }

                str += tableau[i][j] + " ";
                compteur += 2;

                if (tableau[i][j] > 9) {
                    compteur++;
                }
            }
            str += "| \n";
        }
        String str2 = "+";


        for (int a = 0; a < compteur; a++) {
            str2 += "-";
        }
        str2 += "+\n";
        return str2 + str + str2;
    }
}
