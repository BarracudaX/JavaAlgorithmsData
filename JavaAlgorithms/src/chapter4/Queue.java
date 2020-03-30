package chapter4;

public class Queue<E> {

    protected final int size;

    protected int numOfItems = 0;

    protected final E[] elements;

    protected int tail = -1, head = 0;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.size = size;
        this.elements = (E[]) new Object[size];
    }

    public synchronized int getNumOfItems(){
        return numOfItems;
    }

    public synchronized boolean isEmpty() {
        return numOfItems == 0;
    }

    public synchronized boolean isFull() {
        return numOfItems == size;
    }

    public synchronized void insert(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("The queue is full");
        }

        if(tail == size - 1) tail = -1;

        elements[++tail] = element;


        numOfItems = numOfItems + 1;
    }


    public synchronized E remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        E element = elements[head];

        elements[head] = null;

        head = head == size - 1 ? 0 : head + 1;

        numOfItems = numOfItems - 1;

        return element;
    }

    public synchronized E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }
        return elements[head];
    }

    public synchronized void display(){
        for (int i = head; ; i++) {
            if (i == tail) {
                System.out.println(elements[i]+",");
                break;
            }
            if (i == size) {
                i = -1;//going to be increments by for loop to 0
            }else if (elements[i] != null) {
                System.out.print(elements[i]+",");
            }
        }
    }

}
