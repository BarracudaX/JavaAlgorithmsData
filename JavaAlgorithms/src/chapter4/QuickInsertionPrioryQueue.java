package chapter4;

public class QuickInsertionPrioryQueue<E> extends Queue<E> {

    public QuickInsertionPrioryQueue(int size) {
        super(size);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        int min = 0;

        for (int i = 1; i < size; i++) {
            if (elements[min] == null
                    || elements[i] != null && ((Comparable)elements[i]).compareTo(elements[min]) < 0) {
                min = i;
            }
        }

        E element = elements[min];

        elements[min] = null;

        numOfItems--;

        return element;

    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        int min = 0;

        for (int i = 1; i < size; i++) {
            if (elements[i] != null && ((Comparable)elements[i]).compareTo(elements[min]) < 0) {
                min = i;
            }
        }

        return elements[min];
    }

    @Override
    public void display() {
        if (isEmpty()) {
            return ;
        }

        E prevMin = elements[0];

        for (int i = 1; i < size; i++) {
            if (prevMin == null || (elements[i] != null && ((Comparable)elements[i]).compareTo(prevMin) < 0)) {
                prevMin = elements[i];
            }
        }

        System.out.print(prevMin+",");

        for (int i = 0; i < size; i++) {
            E currentMin = null;

            for (int j = i; j < size; j++) {
                if ( ( currentMin == null && elements[j] != null
                        && ((Comparable)elements[j]).compareTo(prevMin) > 0 )
                        || (elements[j] != null && ((Comparable)elements[j]).compareTo(prevMin) > 0
                            && ((Comparable)elements[j]).compareTo(prevMin) < 0)) {
                    currentMin = elements[j];
                }
            }
            if (currentMin != null) {
                System.out.print(currentMin+",");
                prevMin = currentMin;
            } else {
                break;
            }

        }

    }
}
