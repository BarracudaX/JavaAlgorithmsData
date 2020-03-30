package chapter4;

public class Stack<E> {

    private final E[] elements;

    private final int size;

    private int top;


    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.size = size;
        this.elements = (E[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public void push(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("The stack is full.");
        }
        top = top + 1;
        elements[top] = element;
    }


    public E pop(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        }

        E topElement = elements[top];

        elements[top] = null;//obsolete reference

        top = top - 1;

        return topElement;
    }

    public E peek(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        }

        return elements[top];
    }

}
