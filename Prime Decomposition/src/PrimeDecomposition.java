
public class PrimeDecomposition {

	public static void main(String[] args) {
		int p = Integer.parseInt(args[0]);
		//text the functions
		System.out.println("The Number " + p + ((isPrime(p))? " is a Prime" : " is not a Prime"));
		System.out.println(" The Prime Decomposition is " + primeDecomposition(p));
		
	}
	
	public static boolean isPrime (int p) {
		boolean isPrime = true;
		for (int i = 2; i < p/2; i++) {
			if (p % i == 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}
	
	public static String primeDecomposition (int p) {
		if (isPrime(p)) {
			return "1 * " + p;			
		}
		
		String decomposition = "";
		int count = 0;
		
		for (int i = 2; i <= p; i++) {
			if (p % i == 0 && isPrime(i)) {
				decomposition = decomposition + ((count == 0)? "" : " * ") + i;
				p = p/i;
				i = 1;
				count++;
			}
		}

		return decomposition;
	}

}
