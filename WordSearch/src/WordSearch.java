
public class WordSearch {

	public static void main(String[] args) {
		//test for the wordSearch Program
		test1();
	}

	//Test for the horizontal or Vertical words in the board
	public static void test1() {
		char[][] board = {{'a', 'b', 'c', 'd', 'e'},
						  {'f', 'g', 'h', 'i', 'j'},
						  {'k', 'l', 'm', 'n', 'o'},
						  {'a', 'b', 'c', 'd', 'e'},
						  {'f', 'g', 'h', 'i', 'j'},
						  {'k', 'l', 'm', 'n', 'o'}};
		String word = "hmchm";
		System.out.println(hasWord(board, word));
	}
	
	/** 
	 * a function that recives an array of arry of chars, like a board game, and a String.
	 * the function is looking for the String inside the board vertically and horizontally.
	 * if the word is found returns true, otherwise false.
	 * @param board, an array of arrays of chars.
	 * @param word, a String that is searched for in the arrays.
	 * @return boolean true if the word is found, otherwise false.
	 * @author GuyPc
	 */
	public static boolean hasWord (char[][] board, String word) {
	boolean hasWord = false;
	int nHorizontal = board[0].length;    //length of the array horizontally
	int nVertical = board.length;         //length of the array vertically
	
	// converting the String word into an array of chars
	int N = word.length();
	char[] c = new char[N];
	for (int i = 0; i < N; i++) {
		c[i] = word.charAt(i);
	}
	
	// Search Algoritem Horizontally
	int charCount = 0;
	for (int i = 0; i < nVertical; i++) {
		for (int j = 0; j < nHorizontal; j++) {
			if( j > nHorizontal - N + j) break;
			if (c[charCount] == board[i][j]) {
				charCount++;
				if (charCount == N) return true;
			} else { 
				charCount = 0;
			}
			
		}
			
	}
	// Search Algoritem Vertically
	int charCountV = 0;
	for (int i = 0; i < nHorizontal; i++) {
		for (int j = 0; j < nVertical; j++) {
			if( j > nVertical - N + j) break;
			if (c[charCountV] == board[j][i]) {
				charCountV++;
				if (charCountV == N) return true;
			} else { 
				charCountV = 0;
			}
			
		}
			
	}
	return hasWord;
	}


}
	
	
	
