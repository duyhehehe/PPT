package HPT.Cholesky;

public class Main {
    public static void main(String[] args) {
        double[][] a = {
                {2, -1, 3},
                {-1, 5, -3},
                {3, -1, 10}
        };
        Cholesky.decomposition(3, a);
    }
}
