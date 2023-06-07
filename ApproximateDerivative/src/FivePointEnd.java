public class FivePointEnd {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 1.0;
        double x0 = 0.5;
        int n = 50;
        double error = Math.abs(derivative(x0) - fivePointEnd(a, b, n, x0));
        System.out.println("Xấp xỉ f'(" + x0 + ") = " + fivePointEnd(a, b, n, x0));
        System.out.println("Sai số tuyệt đối: " + error);
    }

    public static double function(double x) {
        return Math.sin(x);
    }

    public static double derivative(double x) {
        return Math.cos(x);
    }

    public static double fivePointEnd(double a, double b, int n, double x0) {
        // a: Cận dưới
        // b: Cận trên
        // n: Số mốc
        double h = (b - a) / n; // Kích thước bước
        return (-25 * function(x0) + 48 * function(x0 + h) - 36 * function(x0 + 2 * h)
                + 16 * function(x0 + 3 * h) - 3 * function(x0 + 4 * h)) / (12 * h);
    }
}
