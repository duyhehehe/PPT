package HPT.Cholesky;

public class Cholesky {
    public static void decomposition(int n, double[][] a) {
        double[][] l = new double[n][n];
        l[0][0] = Math.sqrt(a[0][0]);
        for (int j = 1; j < n; ++j) {
            l[j][0] = a[j][0] / l[0][0];
        }
        for (int i = 1; i < n - 1; ++i) {
            double tmp1 = 0;
            for (int k = 0; k <= i - 1; ++k) {
                tmp1 += l[i][k] * l[i][k];
            }
            l[i][i] = Math.sqrt(a[i][i] - tmp1);
            for (int j = i + 1; j < n; ++j) {
                double tmp2 = 0;
                for (int k = 0; k <= i - 1; ++k) {
                    tmp2 += l[j][k] * l[i][k];
                }
                l[j][i] = (a[j][i] - tmp2) / l[i][i];
            }
        }
        double tmp = 0;
        for (int k = 0; k < n - 1; ++k) {
            tmp += l[n - 1][k] * l[n - 1][k];
        }
        l[n - 1][n - 1] = Math.sqrt(a[n - 1][n - 1] - tmp);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(l[i][j] + " ");
            }
            System.out.println();
        }
    }
}
