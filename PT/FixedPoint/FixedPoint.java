package PT.FixedPoint;

public class FixedPoint {
    public static void main(String[] args) {
        double p = 3;
        double tolerant = 0.00001; // Sai số cho phép
        int n = 3; // Số lần lặp tối đa
        fixedPoint(p, tolerant, n);
    }

    public static double function(double x) {
        return Math.sin(x);
    }

    public static void fixedPoint(double p, double tolerant, double n) {
        double error = Double.MAX_VALUE;
        for (int i = 0; i < n && error > tolerant; ++i) {
            double prevP = p;
            if (function(p) == 0) {
                System.out.println("Nghiệm đúng của phương trình là: x = " + p);
                return;
            } else {
                p = function(p) + p;
            }
            error = Math.abs(p - prevP);
        }
        System.out.println("Nghiệm gần đúng của phương trình: p = " + p);
        System.out.println("Sai số: " + error);
    }
}
