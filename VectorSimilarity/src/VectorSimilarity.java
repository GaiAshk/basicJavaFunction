public class VectorSimilarity {

	public static void main(String []args) {
		// Uncomment the tester that you want to run:
		// test1();
		// test2();
		// test3();
		// test4();
		test5(args[0],args[1]);	
	}
	
	private static void test1() {
		// Tests the norm function.
		int[] a = {3, 4};
		int[] b = {2, 0, 5, 0, 0, 3};
		System.out.println(norm(a));
		System.out.println(norm(b));
	}
	
	private static void test2() {
		// Write a similar tester to test the inner product function
		int[] a = {2, 12, 12, 34};
		int[] b = {10, 12, 23, 92};
		System.out.println(innerProduct(a, b));
		
	}
	
	private static void test3() {
		// Write a similar tester to test the similarity function.
		int[] a = {2, 0, 0, 0, 1};
		int[] b = {2, 0, 0, 0, 2};
		int[] c = {2, 1};
		System.out.println(similarity(a,b));
		System.out.println(similarity(b,a));
		System.out.println(similarity(a,c));
		System.out.println(similarity(c,b));
		
		
	}
	
	private static void test4() {
		// Tests the strToArray parsing function. Does not test extreme or 
		// invalid values, since in this program we assume that the inputs are valid.
		print(strToArray("4,3,5"));        // Should print 4 3 5
		print(strToArray("7"));            // Should print 7
		print(strToArray("4,0,0,3,0,5"));  // Should print 4 0 0 3 0 5
	}
	
	private static void test5(String inputStr1, String inputStr2) {
		// Test the full program, using two command line arguments.
		int[] arr1 = strToArray(inputStr1);
		int[] arr2 = strToArray(inputStr2);
		System.out.println(similarity(arr1, arr2));	
	}
	
	/** Returns the norm of the vector represented by the given array.
	The norm of a vector (a1, a2, ..., an) is defined as the square root of (a1^2 + a2^2 + ... + an^2).
	*@param an array of integers
	*@return a double, norm of a vector.
	*@author GuyPc
	*/
	public static double norm(int []a) {
		double norm = 0.0;
		int N = a.length;
		for (int i = 0; i < N; i++) {
			norm += (a[i] * a[i]);
		}
		
		return Math.sqrt(norm);
	}
	
	/** Returns the inner product of the two vectors represented by the two given arrays.
	 * If the two arrays don't have the same length, returns -1.
	 * The inner product of two vectors (a1, a2, ..., an) and (b1, b2, ..., bn) is defined
	 * as a1*b1 + a2*b2 + ... + an*bn. 
	 * @param two arrays of integers 
	 * @return product of two vectors, vProduct
	 * @author GuyPc
	 * */
	public static int innerProduct(int []a, int []b) {
		int vProduct = 0;
		int n1 = a.length;
		int n2 = b.length;
		if (n1 != n2) return -1;
		for (int i = 0; i < n1; i++) {
			vProduct += a[i] * b[i];
		}
		return vProduct;
	}
	
	/** Returns the similarity of the two vectors represented by the two given arrays.
	 * The similarity is defined as the inner product of the two vectors, divided by
	 * the multiplication of their norms. If the two arrays don't have the same length, returns -1.
	 * @param two arrays of integer, vectors. 
	 * @return a double, the vectors similarity.
	 * @author GuyPc
	 */
	public static double similarity(int []a, int []b) {
		int n1 = a.length;
		int n2 = b.length;
		if (n1 != n2) return -1;
		
		return innerProduct(a,b) / (norm(a) * norm(b));
	}
	
	// Given a comma-separated string of the form "a1,a2,a3,...", returns the array of integers
	// (a1,a2,a3,...). Assumes (without checking) that each character ai in the given string is a single digit. 
	public static int[] strToArray(String str) {
		double N = str.length();
		int n = str.length();
		char[] c = new char[n];
		int[] a = new int[(int) Math.ceil(N/2.0)]; 
		for (int i = 0; i < n; i = i + 2) {
			c[i] = str.charAt(i);
			a[i/2] = c[i] - '0';
		}
		return a;
	}	
	
	
	// Prints the given int array​
		public static void print(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
}
