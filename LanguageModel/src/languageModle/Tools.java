package languageModle;

import java.util.LinkedList;

public class Tools {

    public static void main(String []args) {
        // test1();
        // test2();
        test3();
        // test4();
        // test5();

    }

    // Creates a linked list, adds a few CharProb objects,
    // and tests the indexOf method.
    private static void test1() {
        LinkedList<CharProb> probs = new LinkedList<CharProb>();
        probs.add(new CharProb('i'));
        probs.add(new CharProb('d'));
        probs.add(new CharProb('c'));
        System.out.println(indexOf(probs,'d'));	// Should print 1
        System.out.println(indexOf(probs,'i'));	// Should print 0
        System.out.println(indexOf(probs,'u'));	// Should print -1
    }

    // Creates a linked list, adds a few CharProb objects,
    // and tests the toString method.
    private static void test2() {
        LinkedList<CharProb> probs = new LinkedList<CharProb>();
        probs.add(new CharProb('i'));
        probs.add(new CharProb('d'));
        probs.add(new CharProb('c'));
        System.out.println(toString(probs));
        // The output should look like this:
        // ((i 1)(d 1)(c 1))
    }

    // Tests the creation of a character probabilities list from a given string.
    // Does not handle the p and cp fields yet.
    private static void test3() {
        System.out.println(toString(buildList("ecotttmixittee ")));
        // The output should look like this:
        // ((c 1)(o 1)(m 2)(i 1)(t 2)(e 2)(  1))
    }

    // Tests the probability calculations.
    private static void test4() {
        LinkedList<CharProb> probs = buildList("committee ");
        System.out.println("Before: " + toString(probs));
        calculateProbabilities(probs);
        // The following printout will make sense only after you change the
        // toString method of the CharProb class to also list the two
        // probability fields.
        //System.out.println(toString(probs));
        System.out.println("After:  " + toString(probs));
    }

    // Tests the calculation of the probabilities p and cp.
    // the test returns the percentage (%) of each letters occurrence
    // the percentages are rounded to Integers.
    private static void test5() {
        LinkedList<CharProb> probs = buildList("committee ");
        calculateProbabilities(probs);
        System.out.println(" one random char:  " + getRandomChar(probs));
        System.out.println("");
        // Write below code that generates characters at random from a given
        // list. Repeat this experiment many times, and verify that the characters
        // are generated according to the probabilities represented in the given list.

        double N = 10000000;                      // number of Stress Tests
        int n = probs.size();                     // length of the string
        //creates an array for the letters and an array for the stressTest
        char[] stressTest = new char[n + 1];
        int[] stressTestNum = new int[n];
        //inserts a letter into each slot of the array
        for (int j = 0; j < n; j++) {
            stressTest[j] = probs.get(j).chr;
        }
        // the stress test itself
        for (int i = 0; i < N; i++) {
            char c = getRandomChar(probs);
            for (int j = 0; j < n; j++) {
                if (stressTest[j] == c){
                    stressTestNum[j]++;
                }
            }
        }
        //prints out the result of the stress test in percents, rounded to integers
        for (int i = 0; i < n; i++) {
            System.out.println("the char " + stressTest[i] + " appeared " + (int)((stressTestNum[i]/N)*(100)) + "% of the times");
        }
    }

    // Builds a character probabilities list from the given string.
    // For each character, sets the chr and count fields, without
    // dealing with the fields p and cp (they remain zero for now).
    public static LinkedList<CharProb> buildList(String str) {
        LinkedList<CharProb> probs = new LinkedList<CharProb>();
        for (int i = 0; i < str.length(); i++) {
            int k = i;
            for (int j = 0; j < probs.size(); j++) {
                if (str.charAt(i) == probs.get(j).chr) {
                    probs.get(j).count++;
                    k++;
                    break;
                }
            }
            if (k == i) {
                probs.add(new CharProb(str.charAt(i)));
            }
        }
        return probs;
    }

    // If the given character exists in the given list, returns the index of the
    // element where the character was found. Otherwise returns -1.
    public static int indexOf(LinkedList<CharProb> probs, char c) {
        for (int i = 0; i < probs.size(); i++) {
            if (probs.get(i).chr == c ){
                return i;
            }
        }
        return -1;
    }

    // Returns a textual representation of the given probabilities list, using the
    // format ((c n),(c n),...,(c n)) where c is a character and n is a count value.
    public static String toString(LinkedList<CharProb> probs) {
        String str = "";
        str += "(";
        for (int i = 0; i <probs.size() ; i++) {
            str += "('" + probs.get(i).chr + "', " + probs.get(i).count + ", " + probs.get(i).p + ", " + probs.get(i).cp + ")";
        }
        str += ")";
        return str;
    }

    // Computes and sets the probabilities (p and cp fields) of all the
    // characters in the given probabilities list.
    public static void calculateProbabilities(LinkedList<CharProb> probs) {
        // calculates the sum of all the counts of all the probes
        double totalCount = 0.0;
        for (int i = 0; i < probs.size(); i++) {
            totalCount += probs.get(i).count;
        }
        // creates a double that contains the probibility for a single char
        double evenShare = 1/totalCount;
        // runs a loop for creating the probebilities of each letter
        for (int i = 0; i < probs.size(); i++) {
            probs.get(i).p = probs.get(i).count * evenShare;
            if (i == 0) {
                probs.get(i).cp = probs.get(i).p;
            } else {
                probs.get(i).cp = probs.get(i-1).cp + probs.get(i).p;
            }
        }
    }

    // Returns a character from the given list, according to its probability.
    public static char getRandomChar(LinkedList<CharProb> probs) {
        double r = Math.random();
        for (int i = 0; i < probs.size(); i++) {
            if (probs.get(i).cp > r) {
                return probs.get(i).chr;
            }
        }
        return 0;
    }
}

