import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Số lượng điểm cho trước
        System.out.print("Nhập số điểm: ");
        int n = sc.nextInt();


        // Nhập các điểm, x trước, y sau
        Data[] f = new Data[n];
        System.out.println("Nhập các điểm cho trước");
        for (int i = 0; i < n; ++i) {
            double xl = Double.parseDouble(String.valueOf(sc.next()));
            double yl = Double.parseDouble(String.valueOf(sc.next()));
            f[i] = new Data(xl, yl);
        }

        // Nhập điểm cần tính
        System.out.print("Điểm cần tính: ");
        double x = Double.parseDouble(String.valueOf(sc.next()));

        // Nhập số bậc của đa thức nội suy
        System.out.print("Số bậc của đa thức nội suy: ");
        int k = sc.nextInt();

        // Kết quả
        System.out.println("P(x) = " + Lagrange.interpolate(f, x, k));
    }
}