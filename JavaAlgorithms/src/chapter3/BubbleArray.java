package chapter3;

import chapter2.HighArray;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BubbleArray<E extends Comparable<E>> extends HighArray<E> {

    private ReentrantLock[] locks;


    public BubbleArray(int size) {
        super(size);
        locks = new ReentrantLock[size];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < nextPos - 1; i++) {
            for (int j = 0; j < nextPos - i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    E temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSort2() {
        for (int i = 0; i < nextPos - 1; i++) {
            for (int j = 0; j < nextPos - i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    E temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
            for (int y = nextPos - i - 1; y > i; y--) {
                if (elements[y].compareTo(elements[y - 1]) < 0) {
                    E temp = elements[y - 1];
                    elements[y - 1] = elements[y];
                    elements[y] = temp;
                }
            }
        }
    }

    public E median() {
        bubbleSort2();

        return elements[(nextPos - 1) / 2];
    }

    public void oddEventSort() {
        boolean isSortedOdd = false;

        boolean isSortedEven = false;

        while (!isSortedOdd || !isSortedEven) {

            isSortedEven = true;

            isSortedOdd = true;

            for (int i = 0; i < nextPos; i+= 2) {
                if (i + 1 == nextPos) {
                    break;
                }
                if (elements[i].compareTo(elements[i + 1]) > 0) {
                    E temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                    isSortedEven = false;
                }
            }

            for (int i = 1; i < nextPos; i+= 2) {
                if (i + 1 == nextPos) {
                    break;
                }
                if (elements[i].compareTo(elements[i + 1]) > 0) {
                    E temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i+1]=temp;
                    isSortedOdd = false;
                }
            }

        }

    }


}
