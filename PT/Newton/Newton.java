package PT.Newton;

public class Newton {
    static final double EPSILON = 0.0001;

    // 2x^3 + 6x^2 + 7x + 5 = 0
    static double function(double x) {
        return 2 * x * x * x + 6 * x * x + 7 * x + 5;
    }

    static double derivFunc(double x) {
        return 6 * x * x + 12 * 7;
    }

    static void newton(double x) {
        double h = function(x) / derivFunc(x);
        while (Math.abs(h) >= EPSILON) {
            h = function(x) / derivFunc(x);
            x = x - h;
        }
        System.out.println("Nghiem gan dung la: " + Math.round(x * 1000.0) / 1000.0);
    }

    public static void main(String[] args) {
        // [-1.9 , -1.8]
        double x0 = -1.9;
        newton(x0);
    }
}
