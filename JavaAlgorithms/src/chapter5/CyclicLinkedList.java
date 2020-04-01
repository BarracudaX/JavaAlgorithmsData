package chapter5;

public class CyclicLinkedList<E> {

    private Link<E> current ;


    public void insert(E element) {
        if (isEmpty()) {
            current = new Link<>(element, null);
            current.setNext(current);
        }else{
            current.setNext(new Link<>(element, current.getNext()));
        }

    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        E element = current.getNext().getElement();

        if (current.getNext() == current) {//IF NEXT IS CURRENT,THEN IT'S LAST ELEMENT
            current = null;
        }else{//SET THE NEXT OF CURRENT AS THE NEXT OF THE NEXT
            current.setNext(current.getNext().getNext());
        }

        return element;
    }

    public boolean search(E element) {
        if (isEmpty()) {
            return false;
        }

        Link<E> start = current;

        while (current != null && !current.getElement().equals(start) && current != start) {
            current = current.getNext();
        }

        boolean result = current != null && current.getElement().equals(element);

        current = start;

        return result;
    }

    public void step(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }
        current = current.getNext();
    }

    public boolean isEmpty(){
        return current == null;
    }

}
