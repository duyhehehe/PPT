public class MidPoint {
    // Hàm tính giá trị của hàm f(x)
    public static double f(double x) {
        return Math.sin(x);
    }
    public static double midpointRule(double a, double b, int n) {
        double h = (b - a) / n; // Kích thước của các đoạn
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double x = a + (i + 0.5) * h; // Tính giá trị x tại điểm giữa đoạn
            sum += f(x);
        }

        return h * sum;
    }

    public static void main(String[] args) {
        double a = 0; // Giới hạn dưới
        double b = Math.PI; // Giới hạn trên

        // Tính toán tích phân với số lượng đoạn khác nhau
        int[] numSegments = {10, 100, 1000, 10000};
        for (int n : numSegments) {
            double approximateResult = midpointRule(a, b, n);
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
