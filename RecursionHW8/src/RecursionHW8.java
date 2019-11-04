/*

Assignment number : 8

File Name : RecursionHW8.java

Name (First Last) : Gai Ashkenazy

Student ID : 204459127

Email : gaiashkenazy@gmail.com

*/


import std.*;

public class RecursionHW8 {

    public static void main (String[] args) {

        //add Test
        //calls the add function and prints out the result
       StdOut.println(add(10, -8));                                  // 10 + (-8) = 2

        //integer to binary test
        // calls the int2Bin function and prints out the resulted Binary value
        StdOut.println(int2Bin(5));                                    // 5 base 10  = 101 binary based

        //parseInt Test
        // calls the parseInt function and prints out the Integer value of the written String
        StdOut.println(parseInt("2079"));                              // "2079" as a string = 2079 as int

        //Palindrome Test
        // checks if a given String is a palindrome and if it is prints out True, if not prints Fales
        StdOut.println(palindrome("viva la vid div al aviv"));        // True

        //sierpinski Test
        //uses the Std Draw to draw out a sierpinski Triangle with a given value n
        sierpinski(8);                                                // draws a Sierpinski Triangle n dimensional

    }

    /** a recurcive function that get two integers and returns their sum;
     * @param a int
     * @param b int
     * @return the sum of the two integers
     */
    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        }
        if (b < 0 && a > 0) return add(a - 1, b + 1);
        if (b < 0 && a < 0) return add(a - 1, b + 1);
        if (b > 0 && a < 0) return add(a + 1, b - 1);
        return add(a + 1, b - 1);
    }

    /**
     * a function that gets an integer (10 based) and converts it into a binary integer
     * @param n the 10 based integer
     * @return the same value of the integer, but binary based
     */
    public static String int2Bin(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        }
        if ( n % 2 == 0) return int2Bin(n / 2) + "0" ;
        else return int2Bin(n / 2) + "1";
    }


    /**
     * a function that receives a string and returns the same string as an integer,
     * if the string argument is including characters the program throws an exception and returns -1
     * @param s the original number as a string
     * @return the same value of number but as an integer, if not a valid input returns -1
     */
    public static int  parseInt(String s) {
        //throws an exeption if the argument is not made of only integers
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 10) {
                try {
                    throw new NumberFormatException("Invalid Argument");
                } catch (NumberFormatException e) {
                    StdOut.println("Invalid argument, try again.");
                    return -1;
                }
            }
        }

        // the recursive function
        if (s.length() - 1 == 0) {
            return s.charAt(0) - '0';
        }
        return (int) ((s.charAt(0) - '0') * (Math.pow(10, s.length() - 1))) + parseInt(s.substring(1, s.length()));
    }


    /**
     * a function that returns true if the String entered is a palindrome false otherwise
     * @param str, a String
     * @return true if the String is a palindrome, false otherwise
     */
    public static boolean palindrome(String str) {
        if (str.charAt(0) == str.charAt(str.length()-1) && str.length() <= 3) {
            return true;
        } else if (str.charAt(0) != str.charAt(str.length()-1)) {
            return false;
        }
        return palindrome(str.substring(1, str.length()-1));
    }


    public static void sierpinski (int n) {
        sierpinski(0, 0, 1, n);
    }

    public static void sierpinski(double x, double y, double size, int n) {
        if (n == 0) return;
        // Draws the Triangle with current points
        StdDraw.line(x, y, x + size/2, y + size);
        StdDraw.line(x + size/2, y + size, x + size, y);
        StdDraw.line(x + size, y, x, y);
        // Draws triangle ofhalf the size,
        // located at the bottom x and y of each triangle
        sierpinski(x, y, size/2, n-1);
        sierpinski(x + size/4, y + size/2, size/2, n-1);
        sierpinski(x + size/2, y, size/2, n-1);
    }

}
