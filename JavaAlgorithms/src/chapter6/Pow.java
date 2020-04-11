package chapter6;

public class Pow {

    public static void main(String[] args) {
        System.out.println(pow(2,4));
    }

    public static long pow(int x, int y) {
        if (y == 1) {
            return x;
        }else{
            long res = pow(x * x, y / 2);
            if (y % 2 == 1) {
                res = res * x;
            }
            return res;
        }
    }

}
