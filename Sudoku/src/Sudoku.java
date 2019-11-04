import std.*;
public class Sudoku {
    public static void main (String[] args) {
        // creates a Sudoku
        int[][] m = {   { 5, 3, 4, 6, 7, 8, 9, 1, 2 } ,
                        { 6, 7, 2, 1, 9, 5, 3, 4, 8 } ,
                        { 1, 9, 8, 3, 4, 2, 5, 6, 7 } ,
                        { 8, 5, 9, 7, 6, 1, 4, 2, 3 } ,
                        { 4, 2, 6, 8, 5, 3, 7, 9, 1 } ,
                        { 7, 1, 3, 9, 2, 4, 8, 5, 6 } ,
                        { 9, 6, 1, 5, 3, 7, 2, 8, 4 } ,
                        { 2, 8, 7, 4, 1, 9, 6, 3, 5 } ,
                        { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };


        //Tests the function
        //test1(m);
        //test2(m);
        //test3(m);

    }

    public static void test1(int[][] m) {
        print(getColumn(m,4));
    }

    public static void test2(int[][] m ) {
        StdOut.println(containNum(m[0]));
        print(m[0]);
    }

    public static void test3(int[][] m) {
        print(getSquare(m, 2, 2, 4));
    }

    public static int[] getSquare (int[][] m, int row, int col, int n) {
        int [] getSquare = new int[n*n];
        int count = 0;
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                getSquare[count] = m[i][j];
                count++;
            }
        }
        return getSquare;
    }

    public static boolean containNum(int[] m) {
        boolean containNum = true;
        for (int i = 0; i < m.length; i++) {
            for (int j = 1; j <= 9; j++) {
                if (m[i] == j) {
                    containNum = true;
                    j = 0;
                    break;
                }
                else {
                    containNum = false;
                }
            }
            if (containNum == false) return false;
        }
        return containNum;
    }

    public static int[] getColumn(int[][] m, int n) {
        int[] getColumn = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            getColumn[i] = m[i][n];
        }
        return getColumn;
    }



    public static void print (int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                StdOut.print(m[i][j] + " ");
            }
            StdOut.println();
        }
    }
    public static void print (int[] m) {
        for(int i = 0; i < m.length; i++) {
            StdOut.print(m[i]  + " ");
        }
    }


}
