package chapter3;

import chapter2.HighArray;

public class InsertionArray<E extends Comparable<E>> extends HighArray<E> {

    public InsertionArray(int size) {
        super(size);
    }

    public void insertionSort(){
        int checkes = 0;

        int copies = 0;

        for (int i = 1; i < nextPos; i++) {

            E nextElement = elements[i];

            int j = i;

            for (; j > 0; j--) {
                checkes = checkes + 1;
                if (elements[j - 1].compareTo(nextElement) > 0) {
                    copies = copies + 1;
                }else{
                    break;
                }
                elements[j] = elements[j - 1];
            }

            elements[j] = nextElement;

        }

        System.out.println("Copies performed : " + copies);
        System.out.println("Checkes performed : "+checkes);

    }

    @Override
    public void noDuplicates() {

        insertionSort();

        E[] temp = (E[]) new Comparable[size];

        int j = 0;

        temp[0] = elements[0];

        for (int i = 1; i < nextPos; i++) {
            if (!temp[j].equals(elements[i])) {
                j = j + 1;
                temp[j] = elements[i];
            }
        }

        this.elements = temp;
        this.nextPos = j + 1 ;
    }
}
