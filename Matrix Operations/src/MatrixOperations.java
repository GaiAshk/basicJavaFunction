// a function that calculates matrix add and multiplication 
public class MatrixOperations {
	
	// a test for the program
	public static void main(String[] args) {
		//test1();
		test2();

	}

	//test1 for adding matrixes
	public static void test1 () {
		int[][] a = { 
					{1, 2, 4, 7},
					{3, 8, 6, 4},
					{5, 7, 0, 9}
									};
		int[][] b = { 
					{1, 2, 4, 7},
					{3, 8, 6, 4},
					{5, 7, 0, 9}
									};
		
		print(a);
		print(b);
		int[][] c = add(a,b);
		print(c);
		
	}
	
	//test2 for multiplaing matrixes
	public static void test2 () {
		int[][] a = { 
					{1, 4, 7},
					{3, 8, 4},
					{5, 7, 9}
									};
		int[][] b = { 
					{1, 2, 4},
					{3, 8, 6},
					{5, 7, 0}
									};
		
		print(a);
		print(b);
		int[][] c = mult(a,b);
		print(c);
		
		
		}
	
	/** 
	 * a function that recivese an array of arrays and prints it out. 
	 * @param an array of arrays.
	 * @return void, but prints the array in the function.
	 * @author GuyPc
	 */
	public static void print (int[][] a) {
		int N = a.length;
		int M = a[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%4s", a[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
	}
	
	/** 
	 * a function that adds two matrixes. 
	 * @param a, an array of arrays.
	 * @param b, another array of arrays.
	 * @return c, the new added matrix of the sum a + b = c.
	 * @author GuyPc
	 */
	public static int[][] add (int[][] a, int[][] b) {
		int N = a.length;
		int M = a[0].length;
		int[][] c = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	
	/** 
	 * a function that multiplays two matrixes, the matrixes are of the same dimantions, square matrix. 
	 * @param a, an array of arrays.
	 * @param b, another array of arrays.
	 * @return c, the new product of the two matrix a * b = c.
	 * @author GuyPc
	 */
	public static int[][] mult(int[][] a, int[][] b) {
		int N = a.length;
		int M = a[0].length;
		int[][] c = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++)
				c[i][j] = a[i][k] * b[k][j] + c[i][j];
			}
		}
		return c;
	}
}
	
	
	

