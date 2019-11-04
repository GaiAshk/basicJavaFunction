// a program that generates the Pascal Triangle for any given value N
public class PascalTriangle {

    public static void main(String[] args) {
        //size of the Triangle, chosen by the user, N
        int N = Integer.parseInt(args[0]);

        // initalizing the triangle
        int[][] pascalTriangle = new int[N + 1][];

        //initializing the first row
        pascalTriangle[0] = new int[3];
        //first value set to be 1
        pascalTriangle[0][1] = 1;

        for (int i = 1; i < N + 1; i++) {
            pascalTriangle[i] = new int[i+3];
            for (int j = 1; j <= i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j] + pascalTriangle[i-1][j-1];
                System.out.print(pascalTriangle[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
