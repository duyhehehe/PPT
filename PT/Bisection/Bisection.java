package PT.Bisection;

public class Bisection {
    public static double divide(int n, double a, double b) {
        double p = (a + b) / 2;
        double fa = 5 * a * a * a - Math.cos(3 * a);
        double fb = 5 * b * b * b - Math.cos(3 * b);
        for (int i = 0; i <= n; ++i) {
            double x = (a + b) / 2;
            double f = 5 * x * x * x - Math.cos(3 * x);
            if (f == 0) {
                System.out.println("f = 0");
                return x;
            } else if (fa * f < 0) {
                print(i, a, b, x);
                System.out.println("fa * f < 0");
                b = x;
                p = x;
            } else {
                print(i, a, b, x);
                System.out.println("fa * f > 0");
                a = x;
                p = x;
            }
        }
        return p;
    }

    private static void print(int n, double a, double b, double x) {
        System.out.println("Lan " + n);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("p" + n + " = " + x);
    }
}
