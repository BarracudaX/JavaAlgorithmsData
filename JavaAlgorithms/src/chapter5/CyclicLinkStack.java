package chapter5;

public class CyclicLinkStack<E> {

    private final CyclicLinkedList<E> stack = new CyclicLinkedList<>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(E element) {
        stack.insert(element);
    }

    public E pop(){
        return stack.remove();
    }

    public E peek(){
        E element = stack.remove();

        stack.insert(element);

        return element;
    }

}
