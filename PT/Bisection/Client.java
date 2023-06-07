package PT.Bisection;

public class Client {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        //Khoảng [3 , 4]
        double tolerant = 0.000001; // Sai số cho phép
        int n = 3; //Số lần lặp tối đa
        Bisection.divide(n, a, b, tolerant);
    }
}
