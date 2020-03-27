package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionArrayTest {

    @Test
    public void shouldSortTheArray(){
        InsertionArray<Integer> ints = new InsertionArray<>(10);
        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);

        ints.display();

        ints.insertionSort();

        ints.display();

    }

    @Test
    public void checkAndCopies(){
        InsertionArray<Integer> ints = new InsertionArray<>(10_000);

        for (int i = 10_000; i > 0; i--) {
            ints.insert(i);
        }

        ints.insertionSort();

        System.out.println("\n");

        ints = new InsertionArray<>(10_000);

        for (int i = 0; i < 10_000; i++) {
            ints.insert(i);
        }

        ints.insertionSort();

    }

    @Test
    public void shouldRemoveAllDuplicates() {
        InsertionArray<Integer> ints = new InsertionArray<>(10);
        ints.insert(4);
        ints.insert(4);
        ints.insert(4);
        ints.insert(2);
        ints.insert(2);
        ints.insert(3);
        ints.insert(3);
        ints.insert(4);
        ints.insert(2);
        ints.insert(3);

        ints.display();

        ints.noDuplicates();

        ints.display();

    }

    /**
     * In the position of each duplicate a -1 is inserted.Then,when insertion sort is going to work,all -1 are going to
     * gather at the beginning of the array(because negative numbers are not allowed).
     */
    @Test
    public void insertionSortWithDuplicateDeletion(){
        int[] ints = new int[100];//only positive numbers

        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random()*200);
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] == ints[i]) {
                    ints[i] = -1;
                }
            }
        }

        for (int i = 1; i < ints.length; i++) {

            int j = i;

            int currentElement = ints[i];

            for (; j > 0 && ints[j-1] > currentElement; j--) {
                ints[j] = ints[j - 1];
            }

            ints[j] = currentElement;

        }

        int strPos = 0;

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

        System.out.println("\n");

        for (int i = 0; i < ints.length; i++) {
            strPos = i;
            if (ints[i] != -1) {
                break;
            }
        }

        for (int i = strPos; i < ints.length; i++) {
            ints[i - strPos] = ints[i];
            ints[i] = 0;
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

    }

}