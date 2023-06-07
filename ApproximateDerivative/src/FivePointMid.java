public class FivePointMid {
    public static void main(String[] args) {
        double a = 0.0; // Cận dưới
        double b = 1.0; // Cận trên
        double x0 = 0.5; // Giá trị cần tính đạo hàm
        int n = 50; // Số điểm mốc cách đều cho trước
        double error = Math.abs(derivative(x0) - fivePointMid(a, b, n, x0));
        System.out.println("Xấp xỉ f'(" + x0 + ") = " + fivePointMid(a, b, n, x0));
        System.out.println("Sai số tuyệt đối: " + error);
    }

    public static double function(double x) {
        return Math.sin(x);
    }

    public static double derivative(double x) {
        return Math.cos(x);
    }

    public static double fivePointMid(double a, double b, int n, double x0) {
        // a: Cận dưới
        // b: Cận trên
        // n: Số mốc
        double h = (b - a) / n; // Kích thước bước
        return (function(x0 - 2 * h) - 8 * function(x0 - h) + 8 * function(x0 + h)
                - function(x0 + 2 * h)) / (12 * h);
    }
}
