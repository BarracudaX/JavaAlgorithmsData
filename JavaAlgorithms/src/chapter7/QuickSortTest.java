package chapter7;

import chapter2.HighArray;

public class QuickSortTest {

    public static void main(String[] args) {
        HighArray<Integer> highArray = new HighArray<>(15);
        highArray
                .insert(5).insert(10).insert(2).insert(11)
                .insert(6).insert(12).insert(1).insert(0);

        highArray.display();

        highArray.quickSort();

        highArray.display();

    }


}
