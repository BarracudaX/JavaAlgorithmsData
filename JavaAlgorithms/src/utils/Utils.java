package utils;

public class Utils {

    public static <T extends Comparable<T>> boolean isSortedAscendingOrder(T[] elements) {
        for (int current = 0; current < elements.length; current++) {
            for (int i = current + 1; i < elements.length; i++) {
                if (elements[current].compareTo(elements[i]) > 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
