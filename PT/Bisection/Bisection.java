package PT.Bisection;

public class Bisection {
    public static void divide(int n, double a, double b, double tolerant) {
        double p = (a + b) / 2;
        double error = Double.MAX_VALUE;
        for (int i = 1; i < n && error > tolerant; ++i) {
            double prevP = p;
            if (function(p) < 0) {
                a = p;
            } else if (function(p) > 0) {
                b = p;
            } else {
                System.out.println("Nghiệm đúng của phương trình là: x = " + p);
                return;
            }
            p = (a + b) / 2;
            error = Math.abs(p - prevP);
        }
        System.out.println("Nghiệm gần đúng của phương trình là: p = " + p);
        System.out.println("Sai số: " + error);
    }

    private static double function(double x) {
        return Math.sin(x);
    }
}
