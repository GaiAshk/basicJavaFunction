/*

Assignment number : 7

File Name : Polynomial.java

Name (First Last) : Gai Ashkenazy

Student ID : 204459127

Email : gaiashkenazy@gmail.com

*/

package polynomial;

import std.*;

public class Polynomial {

    private int[] a;    // The coefficient of x^i is stored in a[i]
    private int degree; // The degree of this polynomial

    /**
     * Constructs a polynomial from the given array of coefficients.
     * If the given coefficients include trailing zeros, ignores them.
     * @param coeffArr The given coefficients. The coefficient of the
     *             zero's term is represented by coeffArr[0], and so on.
     */
    public Polynomial(int[] coeffArr) {
        // Computes and sets the degree of this polynomial.
        // If the given coefficients include trailing zeros, ignores them.
       int n = coeffArr.length - 1;
       int count = 0;
       int notCount = 0;
       boolean isZero = true;
        for(int i = n; i >= 0; i--) {
            if (coeffArr[i] == 0 && isZero){
                notCount++;
            } else {
                count++;
                isZero = false;
            }
        }

        a = new int[count];
        System.arraycopy(coeffArr, 0, a, 0, count);
        this.degree = count - 1;
    }


    /** Returns the degree of this polynomial.
     *  @return The degree of this polynomial.
     */
    public int getDegree() {
        // Replace the following statement with your code.
        return (this.degree);
    }

    /**
     * Returns the coefficients of this polynomial.
     * @return The coefficients of this polynomial, as an int array.
     */
    public int[] getCoeffArr(){
        // Constructs an array of the right size, copies all the coefficients of this polynomial into it,
        // and returns the array. This is done in order to protect the coefficients of this polynomial.
        // (If we will simply return the a array, the user can destroy it).
        int[] coeffArr = new int[getDegree()+1];
        for (int i = 0; i < getDegree()+1; i++) {
            coeffArr[i] = this.a[i];
        }
        return coeffArr;
    }

    /**
     * Returns the i'th coefficient of this polynomial.
     * If i is greater than the degree of this polynomial, returns 0.
     * @param i The term's power.
     * @return The i'th coefficient of this polynomial.
     */
    public int getCoefficient(int i) {
        if(i > getDegree()) {
            return 0;
        }
        int coeff = getCoeffArr()[i];
        return coeff;
    }

    /**
     * Returns the value of this polynomial at the given point.
     * @param x The value at which this polynomial is computed
     * @return The value of this polynomial at the given point.
     */
    public double value(double x) {
        double y = 0.0;
        for (int i = 0; i < getDegree()+1.0; i++){
        y += getCoefficient(i)*(Math.pow(x, (i)));
        }
        return y;
    }

    /**
     * Returns a vector of values of this polynomial,
     * computed over the given vector of values.
     * @param x The values at which this polynomial is computed
     * @return The values of this polynomial at the given points.
     */
    private double[] value(double x[]) {
        double[] vector = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            vector[i] = value(x[i]);
        }
        return vector;
    }
    // a public method to test the private value method
    public double[] getvalue( double x[]) {
        return value(x);
    }

    /**
     * Returns the multiplication of this polynomial by the given scalar value.
     * @param c The scalar
     * @return The multiplication of this polynomial by the given scalar, as a new polynomial
     */
    public Polynomial multByScalar(int c) {
       int[] scalr = new int[this.a.length];
        for (int i = 0; i < getDegree()+1; i++) {
            scalr[i] = this.a[i]*c;
        }
        Polynomial scalrP = new Polynomial(scalr);
        return scalrP;
    }

    /**
     * Returns the polynomial resulting from the addition of this polynomial
     * and the other polynomial.
     * @param other The other polynomial which is added to this polynomial.
     * @return The sum of this polynomial and the other one, as a new polynomial.
     */
    public Polynomial plus(Polynomial other) {
        int highestDegree = getDegree();
        if (other.getDegree() > highestDegree) {
            highestDegree = other.getDegree();
        }
        int[] sumArray = new int[highestDegree + 1];
        for (int i = 0; i < highestDegree + 1; i++) {
            sumArray[i] = this.getCoefficient(i) + other.getCoefficient(i);
        }
        Polynomial sum = new Polynomial(sumArray);
        return sum;
    }

    /**
     * Returns the first derivative of this polynomial.
     * @return The first derivative of this polynomial, as a new polynomial
     */
    public Polynomial derivative() {
        int[] deriviteveArray = new int[getDegree()];
        for (int i = 0; i < getDegree(); i++) {
            deriviteveArray[getDegree()-1 - i] = getCoefficient(getDegree() - i)*(getDegree() - i);
        }
        Polynomial deriviteve = new Polynomial(deriviteveArray);
        return deriviteve;
    }

    /**
     * Displays the graph of this polynomial, computed over the given range of values.
     * @param xMin The left-most x value
     * @param xMax The right-most x value
     * @param nSegments The number of line segments used to approximate the graph
     */
    public void plot(int xMin, int xMax, int nSegments) {
        //creating the x and y value arrays
        double[] x = xArr(xMin, xMax, nSegments);
        double[] y = value(x);
        //setting the scales for the ploting of the functions
        StdDraw.setXscale(min(x), max(x));
        StdDraw.setYscale(min(y), max(y));
        StdDraw.setPenColor(25, 100, 30);

        for (int i = 0; i < nSegments; i++) {
        StdDraw.point(x[i], y[i]);
        }
    }

    /** Returns a string representation of this polynomial.
     * @return This polynomial as a string of the form an*x^n + ... + a1*x + a0
     */
    public String toString() {
        String aStr = "";
        for (int i = 0; i < getDegree() + 1; i++) {
            // takes care of the Plus sign
            if (i == 0 || getCoefficient(getDegree() - i) < 0) {
            } else if ((getDegree() - i) == -1) {
            } else if (getCoefficient(getDegree() - i) == 0) {
            } else {
                aStr += " + ";
            }

            // takes care of the Coefficient
            if (getCoefficient(getDegree() - i) == 0) {
            } else if ((getDegree() - i > 1) && (getCoefficient(getDegree()-i) == 1 || getCoefficient(getDegree()-i) == -1)){
            } else {
                aStr += getCoefficient(getDegree() - i);
            }

            //takes care of the power of x,  x^i
            if (getDegree() - i == 0) {
            } else if (getCoefficient(getDegree() - i) == 0) {
            } else if ((getDegree() - i == 1) || (getDegree() - i == -1)) {
                aStr += "x ";
            } else {
                aStr += "x^" + (getDegree() - i + " ");
            }
        }
        return aStr;
    }

    // Returns an array that represent N equally-spaced
    // points between a and b
    private static double[] xArr(double a, double b, int N) {
        double x = (b - a)/N;
        double[] xArr = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            xArr[i] = a + x*i;
        }
        return xArr;
    }
    //a public test for the xArr method
    public double[] testPlotingFunctions(double a, double b, int N) {
        double[] x = xArr(a, b, N);
        return x;
    }

    // Returns the minimum value in the given array
    private static double min(double arr[]) {
        double min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // a privet test for min method
    public static double minTest(double arr[]) {
        return min(arr);
    }

    // Returns the maximum value in the given array
    private static double max(double arr[]) {
        double max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //test for the privet max method
    public static double maxTest (double arr[]) {
        return max(arr);
    }
}