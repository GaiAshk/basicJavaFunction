public class MyArrays1 {
	
	public static void main(String []args) {
		// Uncomment the tester that you want to run:
		test1();
		test2();
		test3();
		test4();
	}
	
	private static void test1() {
		// Tests the hasDuplicates function.		
		int[] a = {3, 5, 7, 4, 13, 1, 12};
		int[] b = {1, 0, 2, 9, 9};
		System.out.println(hasDuplicates(a));
		System.out.println(hasDuplicates(b));
	}

	private static void test2() {
		// Write a similar tester for the Inorder function.
		int[] a = {1, 2, 3, 4, 6,  5, 6};
		int[] b = {10, 20, 21, 88, 99, 100};
		print(a);
		print(b);
		System.out.println(inOrder(a));
		System.out.println(inOrder(b));
	}
	
	private static void test3() {
		// Write a similar tester for the rotate function.
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int[] b = {10, 23, 0, 18, 3, 7, 18, 99}; 
		print(a);
		print(b);
		print(rotate(a, 10));
		print(rotate(b, 7));
	}
	
	private static void test4() {
		// Write a similar tester for the concat function.
		int[] a = {1, 2, 3, 7, 1, 12};
		int[] b = {99, 23, 0, 1, 34, 55};
		print(concat(b, a));
		
	}
	
	/** If the given array contains an element that appears at least twice, returns true.
	 *  Otherwise, returns false.
	 *  
	 *  @param an array of integers 
	 *  @return boolean, true if has duplicates, false otherwise
	 *  @author GuyPc
	 *   */
	public static boolean hasDuplicates(int[] arr) {
		boolean hasDuplicates = false;
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i] == arr[j] && j != i) return true;
			}
		}
		
    	    return hasDuplicates;
   }
	
	/** If the elements of the given array are in increasing (greater or equal) order, returns true.
	 *  Otherwise, returns false.
	 *  @param an array of integers 
	 *  @return a boolean true if in order, false otherwise
	 *  @author GuyPc 
	 *   */
	public static boolean inOrder(int[] arr) {
    	// Replace the following statement with your code.
		boolean inOrder = true;
		int N = arr.length;
		for (int i = 0; i < N-1; i++) {
			if (arr[i] > arr[i+1]) return false;
		}
    	    return inOrder;
    }
	
	/** Returns an n-rotation of the given array. Array elements whose indices become too large are wrapped around.
	 * Assumes (without checking) that n is a non-negative number which is less than the array size.
	 * For example, consider the array [1 9 6 5 7]. If n=2, the rotated array will be [5 7 1 9 6].
	 * 
	 * @param an array of integers
	 * @param number of rotations 
	 * @return a rotated array 
	 * @author GuyPc 
	 */
	public static int[] rotate(int[] arr, int n) {
		// Replace the following statement with your code.
		int N = arr.length;
		int[] rotateArray = new int[N];
		int[] temp = new int[N];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < N; j++) {
				if (j == 1) {
					rotateArray[j-1] = arr[N-1];
					temp[j-1] = rotateArray[j-1];
				}
				rotateArray[j] = arr[j-1];
				temp[j] = rotateArray[j];
			}
			for (int k = 0; k < N; k++) {
				arr[k] = temp[k];
			}
			
			
		}
		return rotateArray;
	}
	
	 /** Returns an array whose elements consist of all the elements of arr1, followed by all the elements of arr2.
	  * @param two array of integers 
	  * @return one array of integers
	  * @author GuyPc
	  *  */
    public static int[] concat(int[] arr1, int[] arr2) {
    	// Replace the following statement with your code.
    	int n1 = arr1.length;
    	int n2 = arr2.length;
    	int N = n1 + n2;
    	int[] concatArray = new int[N];
    	for (int i = 0; i < n1; i++) {
    		concatArray[i] = arr1[i];
    	}
    	for (int j = 0; j < n2; j++) {
    		concatArray[n1 + j] = arr2[j];
    	}
    	
    	return concatArray;
    }

	// Prints the given int array​
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}