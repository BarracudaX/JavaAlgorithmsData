package chapter7;

import chapter2.HighArray;

public class MedianaWithPartition {

    public static void main(String[] args) {
        HighArray<Integer> ints = new HighArray<>(9);
        ints.insert(4, 5, 2, 1, 3, 0, 6,8,10);
        System.out.println(ints.mediana());
    }

}
