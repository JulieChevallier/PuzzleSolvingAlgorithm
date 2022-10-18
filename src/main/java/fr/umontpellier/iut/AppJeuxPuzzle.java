package fr.umontpellier.iut;

public class AppJeuxPuzzle {
    public static void main(String[] args) {
        /*
        int[][] tableau = {{1,2,3},
                {4,5,6},
                {7,0,8}};
        JeuPuzzle jeuPuzzle = new Hanoi(3);
        Contexte contexte = new Contexte(jeuPuzzle);
        contexte.resoudre();
        System.out.println(contexte.getSolution());

        Hanoi hanoi = new Hanoi(3);
        //System.out.println(hanoi);


        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        ArrayList<Integer> t3 = new ArrayList<>();
        t1.add(1,1);
        t1.add(1,2);
        t1.add(1,3);
        Hanoi hanoi1 = new Hanoi(t1,t2,t3,3);
        System.out.println(hanoi1);


        ArrayList<Hanoi> han = hanoi.genererFils();
        for (int i = 0; i < han.size() ; i++) {
            System.out.println(han.get(i));
        }

        int[][] grille = {
                {0,5,0,2,0,6,1,0,0},
                {6,8,7,1,0,0,5,0,0},
                {0,0,2,0,8,4,0,0,0},
                {4,2,0,0,3,0,7,0,8},
                {0,0,0,7,2,8,0,0,0},
                {8,0,9,0,6,0,0,3,1},
                {0,0,0,6,4,0,3,0,0},
                {0,0,1,0,0,7,9,4,2},
                {0,0,5,3,0,9,0,6,0}
        };

         */
        Sudoku sudoku = new Sudoku(new int[][]{
                {0,1,2,3},
                {3,2,1,4},
                {2,3,4,1},
                {1,4,3,2}
        });

        Sudoku sudoku1 = new Sudoku(new int[][]{
                {0,5,0,2,0,6,1,0,0},
                {6,8,7,1,0,0,5,0,0},
                {0,0,2,0,8,4,0,0,0},
                {4,2,0,0,3,0,7,0,8},
                {0,0,0,7,2,8,0,0,0},
                {8,0,9,0,6,0,0,3,1},
                {0,0,0,6,4,0,3,0,0},
                {0,0,1,0,0,7,9,4,2},
                {0,0,5,3,0,9,0,6,0}
        });
        Contexte con = new Contexte(sudoku1);
        con.resoudre();
        System.out.println(con.getSolution());
    }
}
