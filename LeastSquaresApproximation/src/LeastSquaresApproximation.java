public class LeastSquaresApproximation {
    public static void main(String[] args) {
        // Dữ liệu đầu vào (ví dụ: dữ liệu y = f(x) = 2x + 1)
        double[] xData = {1, 2, 3, 4, 5};
        double[] yData = {3, 5, 7, 9, 11};

        // Bậc của hàm số
        int degree = 2;

        // Tính xấp xỉ hàm số
        double[] coefficients = leastSquaresApproximation(xData, yData, degree);

        // In kết quả xấp xỉ
        System.out.print("Xấp xỉ hàm số: y = ");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print(coefficients[i] + "x^" + (coefficients.length - i - 1));
            if (i < coefficients.length - 1) {
                System.out.print(" + ");
            }
        }

        // Đánh giá sai số
        double[] yApprox = evaluateApproximation(xData, coefficients);
        double error = calculateError(yData, yApprox);
        System.out.println("\nSai số: " + error);
    }

    public static double[] leastSquaresApproximation(double[] xData, double[] yData, int degree) {
        int n = xData.length;

        // Tính ma trận Vandermonde
        double[][] vandermondeMatrix = new double[n][degree + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= degree; j++) {
                vandermondeMatrix[i][j] = Math.pow(xData[i], degree - j);
            }
        }

        // Tính ma trận chuyển vị của Vandermonde
        double[][] vandermondeTranspose = transposeMatrix(vandermondeMatrix);

        // Tính ma trận nhân Vandermonde với chuyển vị Vandermonde
        double[][] vandermondeMultiply = matrixMultiply(vandermondeTranspose, vandermondeMatrix);

        // Tính ma trận nghịch đảo của ma trận Vandermonde nhân chuyển vị Vandermonde
        double[][] vandermondeInverse = matrixInverse(vandermondeMultiply);

        // Tính ma trận nhân chuyển vị Vandermonde với vector y
        double[] yMatrix = new double[n];
        for (int i = 0; i < n; i++) {
            yMatrix[i] = yData[i];
        }
        double[] vandermondeYMultiply = matrixVectorMultiply(vandermondeTranspose, yMatrix);

        // Tính vector hệ số
        double[] coefficients = matrixVectorMultiply(vandermondeInverse, vandermondeYMultiply);

        return coefficients;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] transpose = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        double[][] multiply = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    multiply[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return multiply;
    }

    public static double[][] matrixInverse(double[][] matrix) {
        int n = matrix.length;
        double[][] inverse = new double[n][n];

        // Khởi tạo ma trận nghịch đảo là ma trận đơn vị
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Áp dụng phép biến đổi Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];

            for (int j = 0; j < n; j++) {
                matrix[i][j] /= pivot;
                inverse[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];

                    for (int j = 0; j < n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                        inverse[k][j] -= factor * inverse[i][j];
                    }
                }
            }
        }

        return inverse;
    }

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

    public static double[] evaluateApproximation(double[] xData, double[] coefficients) {
        int n = xData.length;
        double[] yApprox = new double[n];

        for (int i = 0; i < n; i++) {
            double x = xData[i];
            double y = 0.0;

            for (int j = 0; j < coefficients.length; j++) {
                y += coefficients[j] * Math.pow(x, coefficients.length - j - 1);
            }

            yApprox[i] = y;
        }

        return yApprox;
    }

    public static double calculateError(double[] yData, double[] yApprox) {
        int n = yData.length;
        double sumSquaredError = 0.0;

        for (int i = 0; i < n; i++) {
            double error = yData[i] - yApprox[i];
            sumSquaredError += error * error;
        }

        double meanSquaredError = sumSquaredError / n;
        double rootMeanSquaredError = Math.sqrt(meanSquaredError);

        return rootMeanSquaredError;
    }
}
