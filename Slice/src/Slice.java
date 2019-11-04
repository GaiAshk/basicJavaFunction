
public class Slice {

	public static void main(String[] args) {
		String text = "";
		//acceptes multipe arguments from the user
		for (int i = 0; i < args.length; i++) {
			text = text + " " + args[i];
		}
		// Tests Slice function
		System.out.println(slice(text, 3, 12)); //Hello World

	}
	/** 
	 * 
	 * @param accepts 3 parameters
	 * @param string text - the string that is wanted to be sliced
	 * @param from - from witch character slice should start
	 * @param to - until what char to slice the world
	 * @return new sliced string
	 * @author GuyPc
	 */
	public static String slice (String text, int from, int to) {
		if ( from < 0 || to > text.length() || to < from) {
			return "-1";
		}
		
		String newText = ""; 
		for (int i = from+1; i < to; i++) {
			newText += text.charAt(i);
		}
	
	return newText;
	}
	

}
