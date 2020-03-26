package chapter1;

public class HighArray<E extends Comparable<E>> {

    private final E[] elements;

    private final int size;

    private int nextPos = 0;

    @SuppressWarnings("unchecked")
    public HighArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size must be positive.");
        }
        this.size = size;

        this.elements = (E[]) new Comparable[size];
    }

    public void insert(E element) {
        if (nextPos >= size) {
            return ;
        }

        elements[nextPos] = element;

        nextPos = nextPos + 1;
    }

    public boolean search(E element) {
        for (E e : elements) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void delete(E element) {
        int found = -1;

        for (int i = 0; i < nextPos; i++) {
            if (elements[i].equals(element)) {
                found = i;
                break;
            }
        }

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

    public void noDuplicates() {
        for (int i = 0; i < nextPos; i++) {

            E unique = elements[i];
            if (unique != null) {
                for (int j = i + 1; j < nextPos; j++) {
                    if (unique.equals(elements[j])) {
                        elements[j] = null;
                    }
                }
            }

        }

        E[] temp = (E[]) new Comparable[size];

        int foundHoles = 0;

        int nextEmptySlot = 0;

        for (int i = 0; i < nextPos; i++) {
            if (elements[i] != null) {
                temp[nextEmptySlot] = elements[i];
                nextEmptySlot = nextEmptySlot + 1;
            } else {
                foundHoles = foundHoles + 1;
            }
        }

        nextPos = nextPos - foundHoles;

        for (int i = 0; i < nextPos; i++) {
            elements[i] = temp[i];
        }

    }

    public int howManyDuplicates(E element) {
        int count = -1;

        for (E e : elements) {
            if (element.equals(e)) {
                count = count + 1;
            }
        }

        return count;
    }

    public int getNumberOfElements() {
        return nextPos;
    }
}
