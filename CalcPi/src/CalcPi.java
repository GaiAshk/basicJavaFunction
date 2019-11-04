public class CalcPi {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        double sum = 0.0;
        //calculates the denomenator of the series
        for (double i = 0.0; i <= N; i++) {
            if (i == 0.0) {
                sum += 1.0;
            } else if (i % 2.0 == 0) {
                sum += 1.0/ (1 + 2.0 * i);
            } else {
                sum -= 1.0/ (1 + (i * 2.0));
            }
        }
        System.out.println(sum * 4);
    }
}
