package chapter2;

import java.util.Arrays;

public class HighArray<E extends Comparable<E>> {

    protected E[] elements;

    protected final int size;

    protected int nextPos = 0;

    private int copies;

    private int comprations;

    @SuppressWarnings("unchecked")
    public HighArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The size must be positive.");
        }
        this.size = size;

        //The elements of the array are all going to be of type that extends Comparable
        this.elements = (E[]) new Comparable[size];
    }

    public HighArray<E> insert(E element) {
        if (nextPos >= size) {
            return this;
        }

        elements[nextPos] = element;

        nextPos = nextPos + 1;

        return this;
    }

    public void insert(E... elements) {
        for (E element : elements) {
            insert(element);
        }
    }

    public boolean search(E element) {
        return Arrays.stream(elements, 0, nextPos)
                .anyMatch(e -> e.equals(element));
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
            return;
        }

        /**
         * Removes obsolete reference automatically
         */
        for (int i = found; i < nextPos; i++) {
            elements[i] = elements[i + 1];
        }

        nextPos = nextPos - 1;
    }

    public void display() {
        System.out.println("\n");
        Arrays.stream(elements, 0, nextPos)
                .forEach(e -> System.out.print(e + ","));
        System.out.println("\n");
    }

    public E getMax() {
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

    public E removeMax() {
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

    public long howManyDuplicates(E element) {
        return Arrays.stream(elements, 0, nextPos)
                .filter(e -> e.equals(element)).count() - 1;
    }

    public int getNumberOfElements() {
        return nextPos;
    }

    public void quickSort() {
        copies = 0;

        comprations = 0;

        recQuickSort(0, nextPos - 1);

        System.out.println("Copies done : " + copies + ",comprations done : " + comprations);
    }

    private void recQuickSort(int left, int right) {

        int size = right - left + 1;

        if (size <= 3) {
            manualSort(left, right);
        } else {
            int mid = (left + right) / 2;

            E median = medianOf3(left, mid, right);

            int index = partitionIn(left, right, median);

            //index - 2 because index shows at the first element after the pivot.
            recQuickSort(left, index - 1);
            recQuickSort(index + 1, right);

        }
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;

        comprations++;

        if (size <= 1) {

        } else if (size == 2) {
            comprations++;
            if (elements[left].compareTo(elements[right]) > 0) {
                swap(left, right);
            }
        } else {
            comprations += 3;
            if (elements[left].compareTo(elements[right - 1]) > 0) {
                swap(left, right - 1);
            }

            if (elements[left].compareTo(elements[right]) > 0) {
                swap(left, right);
            }

            if (elements[right - 1].compareTo(elements[right]) > 0) {
                swap(right - 1, right);
            }
        }
    }

    /**
     * Partitions the array into two parts:left part contains the elements that are
     * greater than the given pivot element,right part contains elements that are less than the
     * given pivot element;
     * Returns the index of the first element that is less than or equal to the pivot
     *
     * @param left
     * @param right
     * @return
     */
    private int partitionIn(int left, int right, E pivot) {
        int leftPtr = left;

        int rightPtr = right - 1;

        while (true) {

            while (elements[++leftPtr].compareTo(pivot) < 0) {
                comprations++;
            }

            while (elements[--rightPtr].compareTo(pivot) > 0) {
                comprations++;
            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr,rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;

    }

    /**
     * Finds the medium element based on the three elements at positions:left,mid,right.
     * After that,puts the medium in the mid position,element that is less than or equal to medium
     * in the right position,and element that is greater than or equal to the medium in the left position.
     *
     * @param left
     * @param mid
     * @param right
     */
    private E medianOf3(int left, int mid, int right) {

        comprations+=3;

        if (elements[left].compareTo(elements[mid]) > 0) {
            swap(left, mid);
        }

        if (elements[left].compareTo(elements[right]) > 0) {
            swap(left, right);
        }

        if (elements[mid].compareTo(elements[right]) > 0) {
            swap(mid, right);
        }

        swap(mid, right - 1);

        return elements[right - 1];
    }

    private void swap(int source, int dest) {
        copies+=3;
        E temp = elements[source];
        elements[source] = elements[dest];
        elements[dest] = temp;
    }

    public void partitionIn() {
        partitionIn(nextPos - 1,0);
    }

    private void partitionIn(int right, int left) {
        int leftPtr = left - 1;

        int rightPtr = right;

        while (true) {
            while (leftPtr < right && elements[++leftPtr].compareTo(elements[right]) > 0) {

            }

            while (rightPtr > left && elements[--rightPtr].compareTo(elements[right]) < 0) {

            }

            if (leftPtr >= rightPtr) {
                break;
            }else{
                swap(leftPtr,rightPtr);
            }

        }

        swap(leftPtr,right);

    }

    public E mediana() {
        return mediana(0, nextPos - 1);
    }

    private E mediana(int left, int right) {
        int pivotIndex = (left + right) / 2;
        E pivot = elements[pivotIndex];

        int leftPtr = left - 1;

        int rightPtr = right + 1;

        while (true) {

            while (leftPtr < right && elements[++leftPtr].compareTo(pivot) < 0) {

            }

            while (rightPtr > left && elements[--rightPtr].compareTo(pivot) > 0) {

            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                if (elements[leftPtr].equals(elements[pivotIndex])) {
                    pivotIndex = rightPtr;
                } else if (elements[rightPtr].equals(elements[pivotIndex])) {
                    pivotIndex = leftPtr;
                }

                E temp = elements[leftPtr];
                elements[leftPtr] = elements[rightPtr];
                elements[rightPtr] = temp;
            }
        }

        if (pivotIndex == (nextPos - 1)/2) {
            return pivot;
        } else if (pivotIndex > (left+right)/2) {
            return mediana(left, pivotIndex - 1);
        } else {
            return mediana(pivotIndex+1, right);
        }
    }
}
