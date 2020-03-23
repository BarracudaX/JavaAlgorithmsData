package binarySearch;

public class BinarySearchUtil {

    public static <T extends Comparable<T>> int binarySearch(T[] elements, T element) {
        int low = 0;

        int high = elements.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = elements[mid].compareTo(element);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                low = mid +1;
            } else{
                high = mid -1;
            }

        }

        return -1;
    }



}
