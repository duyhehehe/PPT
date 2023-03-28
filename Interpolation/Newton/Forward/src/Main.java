import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhâp số điểm cho trước: ");
        int n = sc.nextInt();

        System.out.println("Nhập các điểm: ");
        double[] x = new double[n];
        double[][] y = new double[n][n];
        // x trước, y sau
        for (int i = 0; i < n; ++i) {
            x[i] = Double.parseDouble(sc.next());
            y[i][0] = Double.parseDouble(sc.next());
        }

        System.out.print("Nhập giá trị cần tính: ");
        double xi = Double.parseDouble(sc.next());

/*        System.out.print("Nhập bậc nội suy: ");
        int k = sc.nextInt();*/

        NewtonForward.interpolation(x, y, xi, n);
    }
}
