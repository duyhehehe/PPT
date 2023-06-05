import java.util.Arrays;

public class EuclideanScaling {
    public static void euclideanScaling(double[][] A, double[] x, int n) {
        double[][] vectors = new double[n][2];
        double[] eigenvalues = new double[n];
        for (int i = 0; i < n; ++i) {
            double[] Ax = MatrixCalc.matrixVectorMultiply(A, x);
            double lengthAx = MatrixCalc.getVectorLength(Ax);
            x = MatrixCalc.vectorNumberMultiply(Ax, 1 / lengthAx);
            vectors[i] = x;
        }
        for (int i = 0; i < n; ++i) {
            double[] Ax = MatrixCalc.matrixVectorMultiply(A, vectors[i]);
            eigenvalues[i] = MatrixCalc.dotProduct(Ax, vectors[i]);
        }
        System.out.println("Vector riêng: " + Arrays.toString(x));
        System.out.println("Giá trị riêng tương ứng: " + eigenvalues[n - 1]);
    }

    public static void main(String[] args) {
        double[][] A = {{3, 2}, {2, 3}};
        double[] x = {1, 0};
        int n = 8;
        euclideanScaling(A, x, n);
    }
}
