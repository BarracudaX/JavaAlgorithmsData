package chapter6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    public void shouldSortElements(){
        Integer[] box = new Integer[]{5, 29, 3, 1, 28, 3, 4, 5};

        MergeSort.sort(box);

        for (int i = 0; i < box.length; i++) {
            System.out.print(box[i] + ",");
        }
    }

}