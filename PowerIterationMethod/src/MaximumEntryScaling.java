import java.util.Arrays;

public class MaximumEntryScaling {
    public static void maximumEntryScaling(double[][] A, double[] x, int n){
        double[][] vectors = new double[n][2];
        double[] eigenvalues = new double[n];
        for (int i = 0; i < n; ++i) {
            double[] Ax = MatrixCalc.matrixVectorMultiply(A, x);
            double maxAx = MatrixCalc.getMaxEntry(Ax);
            x = MatrixCalc.vectorNumberMultiply(Ax, 1 / maxAx);
            vectors[i] = x;
        }
        for (int i = 0; i < n; ++i) {
            double[] Ax = MatrixCalc.matrixVectorMultiply(A, vectors[i]);
            double numerator=MatrixCalc.dotProduct(Ax,vectors[i]);
            double denominator=MatrixCalc.dotProduct(vectors[i],vectors[i]);
            eigenvalues[i]=numerator/denominator;
        }
        System.out.println("Vector riêng: " + Arrays.toString(x));
        System.out.println("Giá trị riêng tương ứng: " + eigenvalues[n - 1]);
    }
    public static void main(String[] args) {
        double[][] A = {{3, 2}, {2, 3}};
        double[] x = {1, 0};
        int n = 5;
        maximumEntryScaling(A, x, n);
    }
}
