package PT.Bisection;

import java.util.Scanner;

import static PT.Bisection.Bisection.divide;


public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so lan chia: ");
        int n = sc.nextInt();
        double a = 0;
        double b = 1;
        divide(n, a, b);
        System.out.println("Sai so = " + (b - a) / (Math.pow(2, n)));
    }
}
