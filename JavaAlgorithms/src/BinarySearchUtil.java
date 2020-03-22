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

    public static void main(String[] args) {
        Integer[] elements = new Integer[]{5, 20, 21, 22, 34, 50, 100, 1000, 10002};
        System.out.println(binarySearch(elements,50));
        System.out.println(binarySearch(elements,5));
        System.out.println(binarySearch(elements,10002));
        System.out.println(binarySearch(elements,10005));
        System.out.println(binarySearch(elements,-1));
    }

}
