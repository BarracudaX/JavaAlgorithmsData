package chapter4;

import java.util.Comparator;

public class PriorityQueue<E extends Comparable<E>> {

    private final E[] elements;

    private int numOfItems = 0;

    private final int size;

    private final Comparator<E> comparator ;

    public PriorityQueue(int size) {
        this(size, (e, t1) -> e.compareTo(t1));
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int size, Comparator<E> comparator) {
        this.size = size;
        this.comparator = comparator;
        this.elements = (E[]) new Comparable[size];
    }


    public void insert(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("The queue is full");
        }

        if (isEmpty()) {
            elements[numOfItems++] = element;
            return;
        }

        int i = numOfItems;

        while (i > 0 && comparator.compare(elements[i-1],element) < 0) {
            elements[i] = elements[i - 1];
            i = i - 1;
        }

        elements[i] = element;

        numOfItems = numOfItems + 1;
    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty.");
        }

        E element = elements[numOfItems - 1];

        elements[numOfItems - 1] = null;

        numOfItems = numOfItems - 1;

        return element;
    }

    public boolean isEmpty() {
        return numOfItems == 0;
    }

    public boolean isFull() {
        return numOfItems == size;
    }

    public E peek() {
        return elements[numOfItems - 1];
    }
}
