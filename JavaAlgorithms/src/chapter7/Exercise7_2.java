package chapter7;

import chapter2.HighArray;

public class Exercise7_2 {

    public static void main(String[] args) {
        HighArray<Integer> array = new HighArray<>(10);
        array.insert(4).insert(10).insert(5);

        array.partitionIn();

        array.display();
    }

}
