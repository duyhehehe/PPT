import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static double[][] a = new double[20][20];

    public static void enter(int n) {
        System.out.println("Nhap he phuong trinh");
        System.out.println("Nhap n hang, moi hang co n + 1 phan tu.\n" +
                "Phan tu cuoi cung moi hang la ve phai");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= n; ++j) {
                a[i][j] = sc.nextDouble();
            }
        }
    }

    public static void gauss(int n) {
        double[] x = new double[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (j > i) {
                    double c = a[j][i] / a[i][i];
                    for (int k = 0; k <= n; ++k) {
                        a[j][k] = a[j][k] - c * a[i][k];
                    }
                }
            }
        }
        x[n - 1] = a[n - 1][n] / a[n - 1][n - 1];
        for (int i = n - 2; i >= 0; --i) {
            double sum = 0;
            for (int j = i + 1; j < n; ++j) {
                sum = sum + a[i][j] * x[j];
            }
            x[i] = (a[i][n] - sum) / a[i][i];
        }
        System.out.println();
        if (Double.isNaN(x[0])) {
            System.out.println("He phuong trinh co vo so nghiem");
        } else {
            System.out.println("Nghiem cua he phuong trinh:");
            for (int i = 0; i < n; ++i) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap so hang, cot cua he phuong trinh");
        int n = sc.nextInt();
        enter(n);
        gauss(n);
    }
}