package chapter5;

public class LinkQueue<E> {

    private final LinkedList<E> queue = new LinkedList<>();

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public void insert(E element) {
        queue.insertLast(element);
    }


    public E remove() {
        return queue.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        E e = queue.removeFirst();

        queue.insertFirst(e);

        return e;
    }

}
