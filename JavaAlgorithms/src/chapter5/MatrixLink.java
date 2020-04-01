package chapter5;

public class MatrixLink<E> {

    private E element;

    private MatrixLink<E> next;

    private MatrixLink<E> down;

    public MatrixLink(MatrixLink<E> next, E element, MatrixLink<E> down) {
        this.element = element;
        this.next = next;
        this.down = down;
    }

    public E getElement() {
        return element;
    }

    public MatrixLink<E> getNext() {
        return next;
    }

    public MatrixLink<E> getDown() {
        return down;
    }

    public void setNext(MatrixLink<E> next) {
        this.next = next;
    }

    public void setDown(MatrixLink<E> down) {
        this.down = down;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "{" +
                "element=" + element +
                '}';
    }
}
