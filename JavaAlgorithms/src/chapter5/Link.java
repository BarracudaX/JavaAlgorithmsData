package chapter5;

public class Link<E> {

    private E element;

    private Link<E> next;

    public Link(E element, Link<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Link<E> getNext() {
        return next;
    }

    public void setNext(Link<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Link{" +
                "element=" + element+"}";
    }
}
