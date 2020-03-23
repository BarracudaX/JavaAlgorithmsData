package devideAndConquer;

public class BinarySearch {

    public static <E extends Comparable<E>> int binarySearch(E[] elements, E key) {
        return binarySearch(elements, key, 0, elements.length - 1);
    }

    private static <E extends Comparable<E>> int binarySearch(E[] elements, E key, int low, int high) {
        int mid = (low + high) / 2;
        if (elements[mid].compareTo(key) == 0) {
            return mid;
        } else if (low > high) {
            return -1;
        } else if (elements[mid].compareTo(key) < 0) {
            return binarySearch(elements, key, mid + 1, high);
        }else{
            return binarySearch(elements, key, low, mid - 1);
        }

    }

}
