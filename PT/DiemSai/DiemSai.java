package PT.DiemSai;

public class DiemSai {
    public static void main(String[] args) {
        // Khoảng [4 , 3]
        double a = 4;
        double b = 3;
        double tolerant = 0.000001; // Sai số cho phép
        int n = 20; // Số lần lặp tối đa
        getApproximateSolution(a, b, tolerant, n);
    }

    public static double function(double x) {
        return Math.sin(x);
    }

    public static void getApproximateSolution(double a, double b, double tolerant, int n) {
        double error = Double.MAX_VALUE;
        double p = (a * function(b) - b * function(a)) / (function(b) - function(a));
        int i = 1;
        while (error >= tolerant && i < n) {
            double prevP = p;
            if (function(p) < 0) {
                a = p;
            } else if (function(p) > 0) {
                b = p;
            } else {
                System.out.println("Nghiệm đúng của phương trình là: x = " + p);
                return;
            }
            p = (a * function(b) - b * function(a)) / (function(b) - function(a));
            error = Math.abs(prevP - p);
            ++i;
        }
        System.out.println("Nghiệm gần đúng của phương trình là: p = " + p);
        System.out.println("Sai số: " + error);
    }
}
