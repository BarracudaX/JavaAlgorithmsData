package chapter5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleListIterator<E> implements Iterator<E> {

    private DoubleLink<E> link;

    private final DoubleLinkedList<E> list;

    public DoubleListIterator(DoubleLink<E> link,DoubleLinkedList<E> list) {
        this.link = link;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (link == null) {
            return false;
        }
        return link.getNext() != null;
    }

    @Override
    public E next() {
        if (link == null) {
            throw new NoSuchElementException("No such element.");
        }
        E element = link.getElement();

        link = link.getNext();

        return element;
    }

    @Override
    public void remove() {
        if (link == null) {
            throw new NoSuchElementException("No such element.");
        }

        if (link.getPrevious() == null) {
            list.removeFirst();
        } else if (link.getNext() == null) {
            list.removeLast();
        }else{
            link.getPrevious().setNext(link.getNext());

            link.getNext().setPrevious(link.getPrevious());

        }
        link = link.getNext();
    }
}
