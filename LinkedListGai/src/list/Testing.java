package list;

public class Testing {

    public static void main(String[] args) {

        //Q1 - no { or } so the code will output nothing, an error
        //Q2 - 320023   maybe 0 is 1 so 321123
        //Q3
        //deposit(100, 0.05, 12);

        String str = "test";
        for (int i = 0; i < 100; i++) {

        }

        String str1 = "test";
        System.out.println(str == str1);
        System.out.println("test" == "test");



        }

    // Q3
    public static double deposit(double sum, double rate, int n) {
        if(n == 0) return sum;
        return (deposit(sum * (1 + rate), rate, n-1));
    }

    //Q4



}
