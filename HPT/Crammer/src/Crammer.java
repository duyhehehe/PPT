public class Crammer {
    public static double[] getSolution(double[][] A, int n, double[] B) {
        double[] res = new double[n];
        double d = Determinant.determinant(A, n);
        double[] D = new double[n];
        for (int i = 0; i < n; ++i) {
            double[][] tmp = new double[n][n];
            copyA(tmp, A, n);
            swapCol(tmp, i, B, n);
            D[i] = Determinant.determinant(tmp, n);
        }
        for (int i = 0; i < n; ++i) {
            res[i] = D[i] / d;
        }
        return res;
    }

    public static void swapCol(double[][] A, int i, double[] B, int n) {
        for (int k = 0; k < n; ++k) {
            A[k][i] = B[k];
        }
    }

    public static void copyA(double[][] des, double[][] src, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                des[i][j] = src[i][j];
            }
        }
    }
}
