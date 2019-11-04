/*

Assignment number : 7

File Name : PolynomialDemo.java

Name (First Last) : Gai Ashkenazy

Student ID : 204459127

Email : gaiashkenazy@gmail.com

*/


package polynomial;

public class PolynomialDemo {

    public static void main(String args[]) {

        // Tests the constructor and the toString method.
        //test1();

        // My tests
        //getDegreeTest();
        //getCoeffArrTest();
        //getCoefficientTest();
        //value1Test();
        //value2Test();

        //multByScalrTest();
        //addPolynomualTest();
        //detivativeTest();

        //test for ploting methods
        //testPloting();

        // A general test that creates and manipulates some polynomials.
         generalTest();
    }

    // Tests the constructor and the toString method.
    public static void test1() {
        // A polynomial of degree = 2
        int[] p1CoeffArr = {1, -5, 3};
        Polynomial p1 = new Polynomial(p1CoeffArr);
        System.out.println(p1.toString() + "\n");

        // A polynomial of degree = 4
        int[] p2CoeffArr = {-2, 0, 7, 5, 12};
        Polynomial p2 = new Polynomial(p2CoeffArr);
        System.out.println(p2 + "\n");

        // A polynomial of degree = 0
        int[] p3CoeffArr = {3};
        Polynomial p3 = new Polynomial(p3CoeffArr);
        System.out.println(p3 + "\n");

        // A polynomial of degree = 0, with trailing zero coefficients
        int[] p4CoeffArr = {5, 0, 0, -1};
        Polynomial p4 = new Polynomial(p4CoeffArr);
        System.out.println(p4 + "\n");

        // A polynomial of degree = 0, with trailing zero coefficients
        int[] p5CoeffArr = {0, 0, 0, 1, -1, 3, -3};
        Polynomial p5 = new Polynomial(p5CoeffArr);
        System.out.println(p5.toString() + "\n");
    }

    //tests the getter of the Degree of the function
    public static void getDegreeTest () {
        int[] pol1 = {1, -5, 5, 9, 0, 0 , 0, 11};
        Polynomial p6 = new Polynomial (pol1);
        System.out.println(" The Polynomial " + p6.toString() + " has a Degree of " + p6.getDegree());
    }

    // test the getCoeffArr method, by printing the coefficients of the Polynomial
    public static void getCoeffArrTest() {
        // A polynomial of degree = 4
        int[] p2CoeffArr = {-2, 0, 7, 5, 12};
        Polynomial p2 = new Polynomial(p2CoeffArr);
        int[] a = p2.getCoeffArr();
        for (int i = 0; i <= p2.getDegree(); i ++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // A polynomial of degree = 0
        int[] p3CoeffArr = {3};
        Polynomial p3 = new Polynomial(p3CoeffArr);
        int[] b = p3.getCoeffArr();
        for (int i = 0; i <= p3.getDegree(); i ++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        // A polynomial of degree = 0, with trailing zero coefficients
        int[] p4CoeffArr = {5, 0, 0};
        Polynomial p4 = new Polynomial(p4CoeffArr);
        int[] c = p4.getCoeffArr();
        for (int i = 0; i <= p4.getDegree(); i ++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }

    //test the getCoefficient method, by printing the coefficients out
    public static void getCoefficientTest() {
        // p(x) = 3x^2 - 5x + 1
        int[] pCoefficients = {1, -5, 3};
        Polynomial p = new Polynomial(pCoefficients);
        System.out.println(p.getCoefficient(0));
        System.out.println(p.getCoefficient(1));
        System.out.println(p.getCoefficient(2));
    }

    // test the method of value, which gets a singal x value
    // and returns the y value of the Polynomial
    public static void value1Test() {
        // p(x) = 3x^2 - 5x + 1
        int[] pCoefficients = {1, -5, 3};
        Polynomial p = new Polynomial(pCoefficients);
        System.out.println(p.value(0));            // 1
        System.out.println(p.value(0.5));          // -0.75
        System.out.println(p.value(1));            // -1
        System.out.println(p.value(2.67777));
        System.out.println(p.value(-1.15));
        System.out.println(p.value(-200));
    }

    // tests the method of value2
    //which gets an array of values (x values) and returns the result
    // of the values (v values)
    public static void value2Test(){
        int[] pol = {1, -5, 5, 9, 0, 0 , 0, 11};
        double[] x = {0.01, 0.1, 1, 1.5, 2, 2.5, 5};
        Polynomial p = new Polynomial (pol);
        for (int i = 0; i < x.length; i++) {
            System.out.println(p.getvalue(x)[i]);
        }
        System.out.println();

        int[] pCoefficients = {1, -5, 3};
        Polynomial p2 = new Polynomial(pCoefficients);
        for (int i = 0; i < x.length; i++) {
            System.out.println(p2.getvalue(x)[i]);
        }
    }

    //tests the method of multiplying a polynomial by a scaler
    public static void multByScalrTest() {
        int[] pCoefficients = {1, -5, 3};
        Polynomial p1 = new Polynomial(pCoefficients);
        Polynomial p2 = p1.multByScalar(-2);
        Polynomial p3 = p1.multByScalar(3);
        System.out.println("p1 = " + p1);
        System.out.println("p1 * (-2) = " + p2);
        System.out.println("p1 * (3) = " + p3);
    }

    // tests the method that adds two polynomialys
    public static void addPolynomualTest() {
        // creating two polynomials for testing
        int[] pCoefficients = {0, -2, 3};
        Polynomial p1 = new Polynomial(pCoefficients);

        int[] pArray = {2, 2, -5, 1};
        Polynomial p2 = new Polynomial(pArray);

        // multiplying the polymonials for more advance testing
        Polynomial p3 = p1.multByScalar(5);
        Polynomial p4  = p2.multByScalar(-2);

        //testing and printing the Plus method
        Polynomial p5 = p1.plus(p2);
        System.out.println(p1 + "  +  " + p2 + " = " + p5);
        System.out.println();

        //similar test
        Polynomial p6 = p3.plus(p4);
        System.out.println(p3 + "  +  " + p4 + " = " + p6);
        System.out.println();

        //combination of the plus and multiplication by scalr methods
        Polynomial p7 = p1.plus(p4.multByScalar(-1));
        System.out.println(p1 + "  +  " + p4.multByScalar(-1) + " = " + p7);
        System.out.println();
    }

    // test for the deriviteve method
    public static void detivativeTest() {
        //creating 3 Polynomials for testing
        int[] pCoefficients = {0, 0, 0, 1, -5, 3};
        Polynomial p1 = new Polynomial(pCoefficients);
        int[] pCoefficients2 = {0, -2, 3, 0, -1, 8};
        Polynomial p2 = new Polynomial(pCoefficients2);
        int[] pArray = {2, 2, -5, 1, 0, 0, 0};
        Polynomial p3 = new Polynomial(pArray);
        //taking their derivetives
        Polynomial pTag1 = p1.derivative();
        Polynomial pTag2 = p2.derivative();
        Polynomial pTag3 = p3.derivative();
        //printing the function and thier derivitives out
        System.out.println("f(x) = " + p1 + " and f'(x) = " + pTag1);
        System.out.println("f(x) = " + p2 + " and f'(x) = " + pTag2);
        System.out.println("f(x) = " + p3 + " and f'(x) = " + pTag3);
    }

    //test for the complete plot method
    public static void plotTest() {
        int[] line = {0, 1};
        Polynomial p = new Polynomial(line);
        p.plot(-100, 100, 1000);
    }

    //test for the xArr, min & max methods, i left them as methods so that all
    // the Polynomial document will be with methods and not with functions
    public static void testPloting() {
        int[] pCoefficients = {1, -5, 3};
        Polynomial p = new Polynomial(pCoefficients);

        double[] x = p.testPlotingFunctions(-20, 100, 10000);
        System.out.println(x[100]);
        System.out.println(p.minTest(x));
        System.out.println(p.maxTest(x));
    }

    public static void generalTest() {
        // p(x) = 3x^2 - 5x + 1
        int[] pCoefficients = {1, -5, 3};
        Polynomial p = new Polynomial(pCoefficients);
        System.out.println("p(x) = " + p);
        System.out.println("p(2) = " + p.value(2) + "\n");

        Polynomial ptag = p.derivative();
        System.out.println("ptag(x) = " + ptag);
        System.out.println("ptag(2) = " + ptag.value(2)+ "\n");

        //  q(x) = x^4 + 2x - 7
        Polynomial q = new Polynomial(new int[] {-7, 2, 0, 0, 1});
        System.out.println("q(x) = " + q);
        System.out.println("pPlusq(x) = " + p.plus(q));
        Polynomial pq = p.plus(q);

        // Plots the two functions
        p.plot(-100, 100, 1000);
        ptag.plot(-100, 100, 1000);
        q.plot(-100, 100, 1000);
        pq.plot(-1000, 1000, 1000);
    }
}