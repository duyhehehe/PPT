package PT.DayCung;

public class Main {
    public static void main(String[] args) {
        double p0 = 4;
        double p1 = 3.157;
        double tolerant = 0.0001; // Sai số cho phép
        int n = 20; // Số lần lặp tối đa
        secant(p0, p1, tolerant, n);
    }

    static double function(double x) {
        return Math.sin(x);
    }

    static void secant(double p0, double p1, double tolerant, int n) {
        double error = Double.MAX_VALUE;
        int i = 1; //Iterator
        while (error > tolerant && i < n) {
            if (function(p1) == 0) {
                System.out.println("Nghiệm đúng của phương trình là: x = " + p1);
                return;
            } else {
                double p0Tmp = p0;
                p0 = p1 - (function(p1) * (p1 - p0)) / (function(p1) - function(p0));
                p1 = p0Tmp;
            }
            i += 1;
            error = Math.abs(p1 - p0);
        }
        System.out.println("Nghiệm gần đúng của phương trình là: p = " + p1);
        System.out.println("Sai số: " + error);
        System.out.println("Số lần lặp: " + i);
    }

}
