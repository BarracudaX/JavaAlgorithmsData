package chapter3;

import chapter6.MergeSort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestDrive {

    public static void main(String[] args) {

        int maxSize = 10_000;

        BubbleArray<Integer> bubbleArray = new BubbleArray<>(maxSize);

        SelectionArray<Integer> selectionArray = new SelectionArray<>(maxSize);

        InsertionArray<Integer> insertionArray = new InsertionArray<>(maxSize);

        Integer[] mergeArray = new Integer[maxSize];

        for (int i = 0; i < maxSize; i++) {

            int random = (int) (Math.random() * maxSize);

            bubbleArray.insert(random);
            selectionArray.insert(random);
            insertionArray.insert(random);
            mergeArray[i] = random;
        }

        System.out.println("Staring Merge Sort...");

        long mergeNanoStr = System.nanoTime();

        MergeSort.sort(mergeArray);

        long mergeNanoEnd = System.nanoTime();

        System.out.println("Merge Sort Took : "+(mergeNanoEnd - mergeNanoStr)+" nanoseconds\n");

        System.out.println(isSorted(mergeArray));

        System.out.println("Starting bubble sort...");

        long bubbleNanoStr = System.nanoTime();

        bubbleArray.bubbleSort();

        long bubbleNanoEnd = System.nanoTime();

        System.out.println("Bubble Sort Took : "
                + TimeUnit.NANOSECONDS.toNanos((bubbleNanoEnd - bubbleNanoStr))+"\n");


        System.out.println("Starting selection sort...");

        long selectionNanoStr = System.nanoTime();

        bubbleArray.bubbleSort();

        long selectionNanoEnd = System.nanoTime();

        System.out.println("Selection Sort Took : "
                + TimeUnit.NANOSECONDS.toNanos((selectionNanoEnd - selectionNanoStr))+"\n");


        System.out.println("Starting insertion sort...");

        long insertionNanoStr = System.nanoTime();

        bubbleArray.bubbleSort();

        long insertionNanoEnd = System.nanoTime();

        System.out.println("Insertion Sort Took : "
                + TimeUnit.NANOSECONDS.toNanos((insertionNanoEnd - insertionNanoStr)));



    }

    public static <T extends Comparable<T>> boolean isSorted(T[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i].compareTo(elements[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}
