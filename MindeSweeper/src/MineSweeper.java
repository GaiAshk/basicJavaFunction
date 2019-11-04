/**
 * a program that generates the mine sweeper board
 * accepets N - number of rows
 *          M - number of columns
 *          p - probebility of mines in the board
 */
public class MineSweeper {

    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);


        printBoard(gameBoard(genBoard(N, M, p)));

    }

    /**
     * generates a board of mines and zeros
     * @param N - # of rows
     * @param M - number of columns
     * @param p - probability of mines
     * @return genBoard - the board with mines spreded out in the entered probobilty
     */
    public static char[][] genBoard(int N, int M, double p) {
        char[][] genBoard = new char[N + 2][M + 2];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                double r = Math.random();
                if (r < p) {
                    genBoard[i][j] = '*';
                } else {
                    genBoard[i][j] = '0';
                }

            }
        }
        return genBoard;

    }

    /**
     * generates a board of mines and zeros
     * @param genBoard - the board with mines and zeros
     * @return gameBoard - the full game board with number of mines near each place
     */
    public static char[][] gameBoard(char[][] genBoard) {
        int N = genBoard.length;
        int M = genBoard[0].length;
        char count = '0';
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if ( genBoard[i][j] == '*') {
                    genBoard[i][j] = '*';
                } else {
                    if (genBoard[i - 1][j - 1] == '*') count++;
                    if (genBoard[i - 1][j] == '*') count++;
                    if (genBoard[i - 1][j + 1] == '*') count++;
                    if (genBoard[i][j - 1] == '*') count++;
                    if (genBoard[i][j + 1] == '*') count++;
                    if (genBoard[i + 1][j - 1] == '*') count++;
                    if (genBoard[i + 1][j] == '*') count++;
                    if (genBoard[i + 1][j + 1] == '*') count++;

                    genBoard[i][j] = (char) count;
                    count = '0';
                }
            }
        }
        return genBoard;
    }

    /**
     * a function that prints an array or arrays
     * @param board - in this case the mine sweeping game board
     */
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
