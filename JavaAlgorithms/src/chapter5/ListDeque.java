package chapter5;

public class ListDeque<E> {

    private final DoubleLinkedList<E> deque = new DoubleLinkedList<>();

    public void insertLeft(E element) {
        deque.insertFirst(element);
    }

    public void insertRight(E element) {
        deque.insertLast(element);
    }

    public E removeRight(){
        return deque.removeLast();
    }

    public E removeLeft(){
        return deque.removeFirst();
    }



}
