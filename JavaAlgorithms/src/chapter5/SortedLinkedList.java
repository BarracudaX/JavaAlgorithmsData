package chapter5;

public class SortedLinkedList<E extends Comparable<E>> {

    private Link<E> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(E element) {
        if (isEmpty()) {
            first = new Link<>(element, null);
            return ;
        }

        if (first.getElement().compareTo(element) > 0) {
            first = new Link<>(element, first);
            return ;
        }

        Link<E> current = first;

        while (current.getNext() != null && current.getNext().getElement().compareTo(element) < 0) {
            current = current.getNext();
        }


        if (current.getNext() == null) {
            current.setNext(new Link<>(element, null));
        } else {
            current.setNext(new Link<>(element, current.getNext()));
        }

    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        E element = first.getElement();

        first = first.getNext();

        return element;
    }

    public boolean remove(E element) {
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }

        if (first.getElement().equals(element)) {
            first = first.getNext();

            return true;
        }

        Link<E> current = first;

        while (current.getNext() != null && !current.getElement().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());

        return true;


    }

}
