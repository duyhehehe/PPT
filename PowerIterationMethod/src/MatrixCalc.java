public class MatrixCalc {
    // Tính định thức ma trận vuông
    public static double calculateDeterminant(double[][] A) {
        int n = A.length;

        if (n == 1) {
            return A[0][0]; // Trường hợp ma trận 1x1
        } else if (n == 2) {
            return A[0][0] * A[1][1] - A[0][1] * A[1][0]; // Trường hợp ma trận 2x2
        } else {
            double determinant = 0;

            for (int j = 0; j < n; j++) {
                determinant += A[0][j] * getCofactor(A, 0, j) * Math.pow(-1, j);
            }

            return determinant;
        }
    }

    // Lấy ma trận con
    public static double getCofactor(double[][] A, int row, int col) {
        int n = A.length;
        double[][] submatrix = new double[n - 1][n - 1];

        int subRow = 0;
        int subCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col) {
                    submatrix[subRow][subCol] = A[i][j];
                    subCol++;

                    if (subCol == n - 1) {
                        subCol = 0;
                        subRow++;
                    }
                }
            }
        }

        return calculateDeterminant(submatrix);
    }

    // Nhân hai ma trận
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int m = A.length; // Số hàng của ma trận A
        int n = B[0].length; // Số cột của ma trận B
        int p = B.length; // Số hàng của ma trận B (phải bằng số cột của ma trận A)
        if (m != p) {
            return null;
        }
        double[][] C = new double[m][n];

        // Nhân hai ma trận A và B
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Tính ma trận chuyển vị
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    // Nhân ma trận với vector
    public static double[] matrixVectorMultiply(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[] multiply = new double[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                multiply[i] += matrix[i][j] * vector[j];
            }
        }

        return multiply;
    }

    // Nhân vector với một số
    public static double[] vectorNumberMultiply(double[] vector, double n) {
        int length = vector.length;

        double[] multiply = new double[length];

        for (int i = 0; i < length; i++) {
            multiply[i] = vector[i] * n;
        }

        return multiply;
    }

    // Tính độ dài vector
    public static double getVectorLength(double[] x) {
        double sumOfSquares = 0;
        for (double v : x) {
            sumOfSquares += v * v;
        }
        return Math.sqrt(sumOfSquares);
    }

    // Nhân vô hướng hai vector
    public static double dotProduct(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Hai vector phải có cùng độ dài.");
        }
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    // Lấy giá trị phần tử lớn nhất trong vector
    public static double getMaxEntry(double[] vector) {
        double max = vector[0];
        int length = vector.length;
        for (int i = 1; i < length; ++i) {
            if (max < vector[i]) {
                max = vector[i];
            }
        }
        return max;
    }
}
