package PT.Newton;

public class Newton {
    public static void main(String[] args) {
        double p = 3;
        double tolerant = 0.0001; // Sai số cho phép
        int n = 20; // Số lần lặp tối đa
        newton(p, n, tolerant);
    }

    static double function(double x) {
        return Math.sin(x);
    }

    static double derivFunc(double x) {
        return Math.cos(x);
    }

    static void newton(double p, int n, double tolerant) {
        double error = Double.MAX_VALUE;
        double counter = 0;
        for (int i = 0; i < n && error > tolerant; ++i) {
            double prevP = p;
            if (function(p) == 0) {
                System.out.println("Nghiệm đúng của phương trình là: x = " + p);
            } else {
                p = p - function(p) / derivFunc(p);
            }
            error = Math.abs(p - prevP);
            counter += 1;
        }
        System.out.println("Nghiệm gần đúng của phương trình: p = " + p);
        System.out.println("Sai số: " + error);
        System.out.println("Số lần lặp: " + counter);
    }
}
