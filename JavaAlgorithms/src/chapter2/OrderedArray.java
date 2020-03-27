package chapter2;

public class OrderedArray<E extends Comparable<E>> {

    private final E[] elements;

    private final int size;

    private int nextPos = 0;

    @SuppressWarnings("unchecked")
    public OrderedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size must be positive.");
        }
        this.size = size;

        this.elements = (E[]) new Comparable[size];
    }

    public void insert(E element) {

        if (nextPos == size) {
            return ;
        }

        if (nextPos == 0) {
            elements[nextPos] = element;
            nextPos = nextPos + 1;
            return;
        }

        int low = 0;

        int high = nextPos - 1;

        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (elements[mid].equals(element)) {
                throw new IllegalArgumentException("Elements already exists");
            } else if (element.compareTo(elements[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        mid = element.compareTo(elements[mid]) < 0 ? mid : mid + 1;

        for (int i = nextPos; i > mid; i--) {
            elements[i] = elements[i - 1];
        }

        elements[mid] = element;

        nextPos = nextPos + 1;
    }

    public boolean search(E element) {
        return findPos(element) >= 0;
    }

    public int findPos(E element) {
        int low = 0;

        int high = nextPos - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (elements[mid].equals(element)) {
                return mid;
            } else if (element.compareTo(elements[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public void delete(E element) {
        int found = findPos(element);

        if (found == -1) {
            return ;
        }

        /**
         * Removes obsolete reference automatically
         */
        for (int i = found; i < nextPos; i++) {
            elements[i] = elements[i + 1];
        }

        nextPos = nextPos - 1;
    }

    public void display(){
        for (int i = 0 ; i < nextPos ; i++) {
            System.out.print(elements[i]+",");
        }
        System.out.println("\n");
    }

    public E getMax(){
        if (nextPos == 0) {
            return null;
        }

        E max = elements[0];

        for (int i = 1; i < nextPos; i++) {
            if (elements[i].compareTo(max) > 0) {
                max = elements[i];
            }
        }

        return max;
    }

    public E removeMax(){
        E max = getMax();

        delete(max);

        return max;
    }


    public static Number[] merge(Number[] t1, Number[] t2) {
        Number[] elements = new Number[t1.length + t2.length];

        int pos1 = 0;

        int pos2 = 0;

        int pos3 = 0;

        while (pos1 < t1.length || pos2 < t2.length) {

            Number nextElement = null;

            if (pos1 < t1.length && pos2 < t2.length) {
                if (t1[pos1].doubleValue() < t2[pos2].doubleValue() ) {
                    nextElement = t1[pos1];
                    pos1 = pos1 + 1;
                }else{
                    nextElement = t2[pos2];
                    pos2 = pos2 + 1;
                }
            } else if (pos1 < t1.length) {
                nextElement = t1[pos1];
                pos1 = pos1 + 1;
            } else {
                nextElement = t2[pos2];
                pos2 = pos2 + 1;
            }

            elements[pos3]= nextElement;

            pos3 = pos3 + 1;
        }

        return elements;
    }
}
