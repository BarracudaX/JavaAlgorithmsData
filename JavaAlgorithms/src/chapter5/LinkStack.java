package chapter5;

public class LinkStack<E> {

    private final LinkedList<E> stack = new LinkedList<>();


    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean isFull(){
        return false;
    }

    public void push(E element) {
        stack.insertFirst(element);
    }


    public E pop(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        }
        return stack.removeFirst();
    }

    public E peek(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        }

        E e = stack.removeFirst();

        stack.insertFirst(e);

        return e;
    }


}
