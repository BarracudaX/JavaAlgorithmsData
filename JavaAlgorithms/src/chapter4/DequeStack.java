package chapter4;

public class DequeStack<E> {

    private final Deque<E> deque;

    public DequeStack(int size) {
        this.deque = new Deque<>(size);
    }


    public boolean isEmpty(){
        return deque.isEmpty();
    }

    public boolean isFull(){
        return deque.isFull();
    }

    public void push(E element) {
        deque.insertLeft(element);
    }


    public E pop(){
        return deque.removeLeft();
    }

    public E peek(){
        E element = deque.removeLeft();

        deque.insertLeft(element);

        return element;
    }


}
