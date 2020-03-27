package chapter3;

import chapter2.HighArray;

public class SelectionArray<E extends Comparable<E>> extends HighArray<E> {

    public SelectionArray(int size) {
        super(size);
    }

    public void selectionSort(){

        for (int i = 0; i < nextPos - 1; i++) {

            int min = i;

            for (int j = i + 1; j < nextPos - 1; j++) {

                if (elements[j].compareTo(elements[min]) < 0) {
                    min = j;
                }

            }

            E temp = elements[i];

            elements[i] = elements[min];

            elements[min] = temp;

        }

    }

}
