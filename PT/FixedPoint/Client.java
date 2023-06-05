package PT.FixedPoint;

import java.util.Scanner;

public class Client {
    // x=cbrt(4x+7)
    public static void main(String[] args) {
        double a = 2;
        double b = 3;
        double x = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so lan lap");
        int n = sc.nextInt();
        for (int i = 0; i <= n; ++i) {
            x = Math.cbrt(4 * x + 7);
            System.out.println("Lần " + i + ":");
            System.out.println("x" + i + " = " + x);
        }
    }
}
