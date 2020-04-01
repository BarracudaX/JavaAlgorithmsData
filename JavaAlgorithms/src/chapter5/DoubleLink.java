package chapter5;

public class DoubleLink<E> {

    private DoubleLink<E> previous;

    private final E element;

    private DoubleLink<E> next;

    public DoubleLink(DoubleLink<E> previous, E element, DoubleLink<E> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public DoubleLink<E> getPrevious() {
        return previous;
    }

    public E getElement() {
        return element;
    }

    public DoubleLink<E> getNext() {
        return next;
    }

    public void setPrevious(DoubleLink<E> previous) {
        this.previous = previous;
    }

    public void setNext(DoubleLink<E> next) {
        this.next = next;
    }
}
