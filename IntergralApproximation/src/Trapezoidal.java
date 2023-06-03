public class Trapezoidal {
    public static double function(double x) {
        return Math.sin(x);
    }

    public static double trapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (function(a) + function(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h; // Tính giá trị x tại vị trí thứ i
            sum += function(x);
        }

        return h * sum;
    }

    public static void main(String[] args) {
        double a = 0; // Giới hạn dưới
        double b = Math.PI; // Giới hạn trên
        int[] numSegments = {10, 100, 1000, 10000};
        for (int n : numSegments) {
            double approximateResult = trapezoidalRule(a, b, n);
            double exactResult = -Math.cos(b) + Math.cos(a); // Kết quả tích phân chính xác

            double error = Math.abs(approximateResult - exactResult);
            System.out.println("Số lượng đoạn: " + n);
            System.out.println("Kết quả gần đúng: " + approximateResult);
            System.out.println("Kết quả chính xác: " + exactResult);
            System.out.println("Sai số: " + error);
            System.out.println("-----------------------");
        }
    }
}
