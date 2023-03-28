package PT.DayCung;

public class Main {
    static final double EPSILON = 0.0001;

    // cos(x) - x =0
    static double function(double x) {
        return Math.cos(x) - x;
    }


    static void secant(double x0, double x1, int n) {
        int i = 0; // Iterator
        double h = (function(x1) * (x1 - x0)) / (function(x1) - function(x0));
        while (Math.abs(h) >= EPSILON) {
            double temp = x1 - h;
            x0 = x1;
            x1 = temp;
            h = h = (function(x1) * (x1 - x0)) / (function(x1) - function(x0));
            ++i;
        }
        System.out.println("Nghiem gan dung la: " + Math.round(x0 * 10000.0) / 10000.0);
    }

    public static void main(String[] args) {
        // x0 =0.5, x1 = pi/4
        secant(0.5, Math.PI / 4, 7);
    }
}
