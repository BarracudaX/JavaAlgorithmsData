package insertionSort;

public class InsertionSortUtil {

    public static <T extends Comparable<T>> void insertionSortAscendingOrder(T[] elements) {

        for (int nextPos = 0; nextPos < elements.length; nextPos++) {
            T min = elements[nextPos];

            for (int j = nextPos + 1; j < elements.length; j++) {
                if (elements[j].compareTo(min)  < 0) {
                    min = elements[j];
                }
            }

            elements[nextPos] = min;
        }

    }

}
