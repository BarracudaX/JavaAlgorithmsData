package chapter5;

import java.util.Iterator;

public class DoubleLinkedList<E> implements Iterable<E> {

    private DoubleLink<E> first,last;

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(E element){
        if (first == null) {
            first = last = new DoubleLink<>(null, element, null);
        }else{
            DoubleLink<E> newFirst = new DoubleLink<>(null, element, first);
            first.setPrevious(newFirst);
            first = newFirst;
        }
    }

    public void insertLast(E element){
        if (last == null) {
            last = first = new DoubleLink<>(null, element, null);
        }else{
            DoubleLink<E> newLast = new DoubleLink<>(last, element, null);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public void insertAfter(E key,E element) {
        if (isEmpty()) {
            return;
        }
        DoubleLink<E> current = first;

        while (current != null && !current.getElement().equals(key)) {
            current = current.getNext();
        }

        if ( current != null && current.getNext() == null) {
            DoubleLink<E> newLink = new DoubleLink<>(last, element, null);
            last.setNext(newLink);
            last = newLink;
        } else if(current != null) {
            DoubleLink<E> next = current.getNext();

            DoubleLink<E> newLink = new DoubleLink<>(current, element, next);

            current.setNext(newLink);

            next.setPrevious(newLink);
        }
    }

    public E removeFirst(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }
        E element = first.getElement();

        first = first.getNext();

        if (first != null) {
            first.setPrevious(null);
        }else{
            last = null;
        }

        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        E element = last.getElement();

        last = last.getPrevious();

        if (last != null) {
            last.setNext(null);
        }else{
            first = null;
        }

        return element;
    }

    public boolean remove(E element) {
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        DoubleLink<E> current = first;

        while (current != null && !current.getElement().equals(element)) {
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            first.getNext().setPrevious(null);
            first = first.getNext();
        } else if (current == last) {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        }else{
            current.getPrevious().setNext(current.getNext());

            current.getNext().setPrevious(current.getPrevious());
        }
        return true;

    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleListIterator(first,this);
    }

}
