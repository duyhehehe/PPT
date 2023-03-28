public class Spline {
    public static void interpolate(int n, double[] x, double[] y) {
        double[] a = new double[n + 1];
        double[] b = new double[n + 1];
        double[] c = new double[n + 1];
        double[] d = new double[n + 1];
        System.arraycopy(y, 0, a, 0, y.length);
        double[] h = new double[n + 1];
        for (int i = 0; i < n; ++i) {
            h[i] = x[i + 1] - x[i];
        }
        double[] alpha = new double[n + 1];
        for (int i = 1; i < n; ++i) {
            alpha[i] = 3 / h[i] * (y[i + 1] - y[i]) - 3 / h[i - 1] * (y[i] - y[i - 1]);
        }
        double[] l = new double[n + 1];
        double[] mu = new double[n + 1];
        double[] z = new double[n + 1];
        l[0] = 1;
        mu[0] = 0;
        z[0] = 0;
        for (int i = 1; i < n; ++i) {
            l[i] = 2 * (x[i + 1] - x[i - 1]) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - h[i] * z[i - 1]) / l[i];
        }
        l[n] = 1;
        z[n] = 0;
        c[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            c[i] = z[i] - mu[i] * c[i + 1];
            b[i] = (a[i + 1] - a[i]) / h[i] - h[i] * (c[i + 1] + 2 * c[i]) / 3;
            d[i] = (c[i + 1] - c[i]) / (3 * h[i]);
        }
        for (int j = 0; j < n; ++j) {
            System.out.println("j = " + j + ": a" + j + " = " + a[j] + "\tb" + j + " = " +
                    b[j] + "\tc" + j + " = " + c[j] + "\td" + j + " = " + d[j]);
        }
    }
}
