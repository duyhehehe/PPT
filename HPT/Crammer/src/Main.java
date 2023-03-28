import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang, cot cua he phuong trinh");
        int n = sc.nextInt();
        double[][] A = new double[n][n];
        double[] B = new double[n];
        System.out.println("Nhap he phuong trinh");
        System.out.println("Nhap n hang, moi hang co n + 1 phan tu.\n" +
                "Phan tu cuoi cung moi hang la ve phai");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = sc.nextDouble();
            }
            B[i] = sc.nextDouble();
        }
        double[] solution = Crammer.getSolution(A, n, B);
        System.out.println("Nghiem cua he phuong trinh:");
        for (int i = 0; i < n; ++i) {
            System.out.println("x[" + (i + 1) + "] = " + solution[i]);
        }
    }
}