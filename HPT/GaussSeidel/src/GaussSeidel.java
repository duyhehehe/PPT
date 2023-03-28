import java.util.Scanner;

public class GaussSeidel {
    /**
     * 2x1 - x2 + x3 = -1
     * 2x1 + 2x2 +2x3 = 4
     * -x1 - x2 + 2x3 = -5
     * <p>
     * =>
     * <p>
     * x1 = (-1 + x2 - x3) / 2
     * x2 = (4 - 2x1 - 2x3) / 2
     * x3 = (-5 + x1 + x2) / 2
     */
    private static double f1(double x1, double x2, double x3) {
        return (-1 + x2 - x3) / 2;
    }

    private static double f2(double x1, double x2, double x3) {
        return (4 - 2 * x1 - 2 * x3) / 2;
    }

    private static double f3(double x1, double x2, double x3) {
        return (-5 + x1 + x2) / 2;
    }

    public static void main(String[] args) {
        double x1 = 0, x2 = 0, x3 = 0;
        double x11, x21, x31;
        double e1, e2, e3;
        int count = 1;
        int timeOfLoop = 25;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap sai so cho phep:");
        double e = Double.parseDouble(sc.next());
        System.out.println("Lan\t\t" + "x1\t\t" + "x2\t\t" + "x3\t\t" + "e");
        do {
            x11 = f1(x1, x2, x3);
            x21 = f2(x11, x2, x3);
            x31 = f3(x11, x21, x3);

            e1 = Math.abs(x1 - x11);
            e2 = Math.abs(x2 - x21);
            e3 = Math.abs(x3 - x31);
            double eMax = Math.max(Math.max(e1, e2), e3);

            System.out.println(count + "\t\t" + x11 + "\t\t" + x21 + "\t\t" + x31 + "\t\t" + eMax);

            ++count;

            x1 = x11;
            x2 = x21;
            x3 = x31;
        } while (e1 > e && e2 > e && e3 > e && count < timeOfLoop);
        x1 = Math.round((x1 * 1000) / 1000);
        x2 = Math.round((x2 * 1000) / 1000);
        x3 = Math.round((x3 * 1000) / 1000);
        System.out.println();
        System.out.println("x1 = " + x1 + "\tx2 = " + x2 + "\tx3 = " + x3);
    }
}