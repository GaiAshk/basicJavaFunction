
public class longestSequence {
	// a function that gets a string and returns the longest sequence in that string
	public static void main(String[] args) {
		//accepts multiple arguments from the user 
		String text = "";
		for (int i = 0; i < args.length; i++) {
			text += args[i];
		}
		//tests the function
		System.out.println(longestSeq(text));
	}
	
	public static String longestSeq (String text) {
		int N = text.length();
		int count = 1;
		int maxSeq = 0;
		char c = text.charAt(0);
		String seq = ""; 
		
		for (int i = 0; i < N-2; i++) {
			if (text.charAt(i) == text.charAt(i+1)) {
				count++;
				if (count > maxSeq) {
					c = text.charAt(i);
					maxSeq = count;
				}
			} else {
				count = 1;
			}
		}
		for (int j = 0; j < maxSeq; j++) {
			seq += c;
		}
		return seq;
	}
}
