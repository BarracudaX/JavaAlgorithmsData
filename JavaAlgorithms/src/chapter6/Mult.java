package chapter6;

public class Mult {


    public static void main(String[] args) {
        System.out.println(mult(3,4));
    }

    public static long mult(long x, long y) {
        if (y == 1) {
            return x;
        }
        return x + mult(x, y - 1);
    }

}
