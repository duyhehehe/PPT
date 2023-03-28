public class NewtonBackward {

    // Newton forward
    // Table
    public static void interpolation(double[] x, double[][] y, double xi, int n) {
        for (int i = 1; i < n; ++i) {
            for (int j = n - 1; j >= i; --j) {
                y[j][i] = y[j][i - 1] - y[j - 1][i - 1];
            }
        }

        // Display the table
//        for(int i=0;i<n;++i){
//            System.out.println(x[i]+'\t');
//            for (int j=0;j<n-1;++j){
//                System.out.println(y[i][j]+'\t');
//            }
//            System.out.println();
//        }

        double s = (xi - x[n - 1]) / (x[1] - x[0]);
        double res = y[n - 1][0];
        for (int i = 1; i < n; ++i) {
            res = res + (s_cal(s, i) * y[n - 1][i]) / calcFact(i);
        }
        System.out.println("F(" + xi + ") = " + res);
    }

    private static double s_cal(double s, int n) {
        double temp = s;
        for (int i = 1; i < n; ++i) {
            temp *= (s + i);
        }
        return temp;
    }

    private static int calcFact(int n) {
        int res = 1;
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        return res;
    }
}
