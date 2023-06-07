public class SecondDerivative {
    public static void main(String[] args) {
        double a = 0.0; // Cận dưới
        double b = 1.0; // Cận trên
        int n = 50; // Số điểm mốc cách đều
        double x0 = 0.5; // Điểm cần tính đạo hàm
        double absoluteError = Math.abs(secondDerivative(x0) - approximateSecondDerivative(a, b, n, x0));
        System.out.println("Xấp xỉ f''(" + x0 + ") = " + approximateSecondDerivative(a, b, n, x0));
        System.out.println("Sai số tuyệt đối: " + absoluteError);
    }

    public static double function(double x) {
        return Math.sin(x);
    }

    public static double secondDerivative(double x) {
        return -Math.sin(x);
    }

    public static double approximateSecondDerivative(double a, double b, int n, double x0) {
        double h = (b - a) / n;
        return (function(x0 - h) - 2 * function(x0) + function(x0 + h)) / (h * h);
    }
}
