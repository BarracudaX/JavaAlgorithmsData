package chapter4;

public class Deque<E> {

    private final E[] elements;

    private final int size;

    private int numOfElements;

    private int head = 0;

    private int tail = 0;

    @SuppressWarnings("unchecked")
    public Deque(int size) {
        this.size = size;
        this.elements = (E[]) new Object[size];
    }

    public boolean isEmpty(){
        return numOfElements == 0;
    }

    public boolean isFull(){
        return numOfElements == size;
    }

    public void insertLeft(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("The queue is full.");
        }
        if (!isEmpty()) {
            tail = tail + 1;
        }

        if (tail == size) {
            tail = 0;
        }

        elements[tail] = element;

        numOfElements++;
    }

    public void insertRight(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("The queue is full.");
        }

        if (!isEmpty()) {
            head = head - 1;
        }

        if (head == -1) {
            head = size - 1;
        }

        elements[head] = element;

        numOfElements++;
    }

    public E removeLeft() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty.");
        }

        E element = elements[tail];
        elements[tail] = null;
        tail = tail - 1;

        if (tail == -1) {
            tail = size - 1;
        }


        numOfElements--;

        if (isEmpty()) {
            head = tail;
        }

        return element;
    }

    public E removeRight() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty.");
        }

        E element = elements[head];
        elements[head] = null;
        head = head + 1;

        if (head == size) {
            head = 0;
        }

        numOfElements--;

        if (isEmpty()) {
            tail = head;
        }

        return element;
    }

}
