public class Simpson {
    // Hàm tính giá trị của hàm f(x)
    public static double function(double x) {
        return Math.sin(x);
    }

    // Hàm tính gần đúng tích phân xác định bằng công thức Simpson
    public static double simpsonRule(double a, double b, int n) {
        double h = (b - a) / n; // Kích thước của các đoạn
        double sum = function(a) + function(b); // Tính tổng đầu và cuối

        for (int i = 1; i < n; i++) {
            double x = a + i * h; // Tính giá trị x tại vị trí thứ i
            if (i % 2 == 0) {
                sum += 2 * function(x); // Cộng giá trị của f(x) lẻ vào tổng
            } else {
                sum += 4 * function(x); // Cộng giá trị của f(x) chẵn vào tổng
            }
        }

        return (h / 3) * sum; // Trả về giá trị tích phân gần đúng
    }

    public static void main(String[] args) {
        double a = 0; // Giới hạn dưới
        double b = Math.PI; // Giới hạn trên

        // Tính toán tích phân với số lượng đoạn khác nhau
        int[] numSegments = {10, 100, 1000, 10000};
        for (int n : numSegments) {
            double approximateResult = simpsonRule(a, b, n);
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
