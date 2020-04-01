package chapter5;

public class ListPriorityQueue<E extends Comparable<E>> {

    private final SortedLinkedList<E> queue = new SortedLinkedList<>();

    public void insert(E element) {
        queue.insert(element);
    }

    public E remove(){
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public E peek() {
        E element = remove();

        insert(element);

        return element;
    }
}
