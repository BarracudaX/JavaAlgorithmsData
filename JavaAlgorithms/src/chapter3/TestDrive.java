package chapter3;

import java.util.concurrent.TimeUnit;

public class TestDrive {

    public static void main(String[] args) {

        int maxSize = 10_000;

        BubbleArray<Integer> bubbleArray = new BubbleArray<>(maxSize);

        SelectionArray<Integer> selectionArray = new SelectionArray<>(maxSize);

        InsertionArray<Integer> insertionArray = new InsertionArray<>(maxSize);

        for (int i = 0; i < maxSize; i++) {

            int random = (int) (Math.random() * maxSize);

            bubbleArray.insert(random);
            selectionArray.insert(random);
            insertionArray.insert(random);

        }

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

}
