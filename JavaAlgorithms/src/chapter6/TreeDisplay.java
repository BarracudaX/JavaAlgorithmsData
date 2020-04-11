package chapter6;

import java.util.Arrays;

public class TreeDisplay {

    private static char[][] tree;

    public static void main(String[] args) {
        int length = 16;

        //rows = log2(16) + 1
        int rows = (int) ((Math.log10(length) / Math.log10(2))) + 1;

        tree= new char[rows][length];

        init();

        makeBranches(0, length - 1, 0);

        display();
    }

    private static void makeBranches(int left, int right, int row) {
        int mid = (left + right + 1) / 2;

        tree[row][mid] = 'X';

        if (left == mid || right == mid) {
            return;
        }

        makeBranches(left, mid, (row + 1));
        makeBranches(mid, right, (row + 1));
    }

    private static void init(){
        for (char[] chars : tree) {
            Arrays.fill(chars, '-');
        }
    }

    private static void display(){
        for (char[] chars : tree) {
            for (char nextChar : chars) {
                System.out.print(nextChar);
            }
            System.out.println("\n");
        }
    }

}
