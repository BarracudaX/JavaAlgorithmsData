package chapter6;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] elements) {
        sort(elements, 0, elements.length-1);
    }

    private static <T extends Comparable<T>> void sort(T[] elements, int low, int high) {
        if (low == high) {
            return ;
        }

        int mid = (low + high) / 2;

        sort(elements, low, mid);

        sort(elements, mid + 1, high);

        merge(elements, low, mid+1, high);
    }

    private static <T extends Comparable<T>> void merge(T[] elements, int lowPtr, int highPtr, int upperBound) {
        T[] temp = (T[]) new Comparable[upperBound - lowPtr + 1];
        int pos = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (elements[lowPtr] == null) {
                System.out.println(lowPtr+" null found.");
            }
            if (elements[lowPtr].compareTo(elements[highPtr]) < 0) {
                temp[pos++] = elements[lowPtr++];
            } else {
                temp[pos++] = elements[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            temp[pos++] = elements[lowPtr++];
        }

        while (highPtr <= upperBound) {
            temp[pos++] = elements[highPtr++];
        }

        for (int i = 0; i < pos; i++) {
            elements[lowerBound + i] = temp[i];
        }
    }

}
