package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    public static int[][] grille_sudoku22_incomplete2() {
        return new int[][]{
                {4, 1, 2, 3},
                {0, 0, 1, 4},
                {0, 3, 4, 1},
                {1, 4, 3, 2}
        };
    }

    static int[][] grille_sudoku22_gagnante() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}};
    }

    static int[][] grille_sudoku_nongagnante_ligne() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 2},
                {1, 4, 3, 1}};
    }

    static int[][] grille_sudoku_incomplet_3x3() {
        return new int[][]{
                {0, 2, 3, 4, 5, 6, 7, 8, 0},
                {4, 5, 6, 7, 8, 9, 1, 2, 0},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5, 6, 7, 8}};
    }

    @Test
    public void test_sudoku33_solution() {
        Sudoku sudoku = new Sudoku(grille_sudoku_incomplet_3x3());
        Contexte contexte = new Contexte(sudoku);
        contexte.resoudre();
        ArrayList<JeuPuzzle> solution = contexte.getSolution();
        // solution.forEach(System.out::println);
        assertTrue(contexte.getSolution().get(solution.size() - 1).estGagnant());
    }

    //@Disabled
    @Test
    public void test_sudoku22_est_gagnant_vrai() {
        Sudoku sudoku = new Sudoku(grille_sudoku22_gagnante());
        assertTrue(sudoku.estGagnant());
    }

    //@Disabled
    @Test
    public void test_sudoku22_est_gagnant_faux_pbLignes() {
        Sudoku sudoku = new Sudoku(new int[][]{
                {4, 1, 2, 3},
                {2, 3, 1, 4},
                {0, 2, 4, 1},
                {1, 4, 3, 2}});
        assertFalse(sudoku.estGagnant());
    }

    @Test
    public void test_sudoku22_est_gagnant_faux_pbCol(){
        Sudoku sudoku = new Sudoku(new int[][]{
                {4, 1, 2, 3},
                {2, 3, 1, 0},
                {3, 2, 4, 1},
                {1, 4, 3, 2}});
        assertFalse(sudoku.estGagnant());
    }

    @Test
    public void test_sudoku11_genererfils_un_trou(){
        Sudoku sudoku = new Sudoku(new int[][]{
                {1,2},
                {2,0}});
        ArrayList<Sudoku> fils = new ArrayList<>();
        ArrayList<Sudoku> filsTest = sudoku.genererFils();
        fils.add(new Sudoku(new int[][]{
                {1,2},
                {2,1}}));
        assertTrue(fils.containsAll(filsTest));
    }

    @Test
    public void test_sudoku11_genererfils_un_trou1(){
        Sudoku sudoku = new Sudoku(new int[][]{
                {0,1},
                {1,2}});
        ArrayList<Sudoku> fils = new ArrayList<>();
        ArrayList<Sudoku> filsTest = sudoku.genererFils();
        fils.add(new Sudoku(new int[][]{
                {2,1},
                {1,2}}));
        assertTrue(fils.containsAll(filsTest) && filsTest.containsAll(fils));
    }
}
