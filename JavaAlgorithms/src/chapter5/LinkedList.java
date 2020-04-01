package chapter5;

public class LinkedList<E> {

    private Link<E> first;

    private Link<E> last;

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(E element) {
        Link<E> link = new Link<>(element, first);

        first = link;

        if (last == null) {
            last = first;
        }

    }

    public E removeFirst(){
        if (isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        E element = first.getElement();

        first = first.getNext();

        if (first == null) {
            last = null;
        }

        return element;
    }

    public void insertLast(E element){
        Link<E> link = new Link<>(element, null);

        if (last == null) {
            first = last = link;
            return ;
        }

        last.setNext(link);

        last = link;

    }

    public boolean remove(E element){
        Link<E> current = first;

        if (first != null && first.getElement().equals(element)) {
            first = first.getNext();
            return true;
        }

        if (current == null) {
            return false;
        }

        while (current.getNext() != null && !current.getNext().getElement().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());

        return true;
    }

    public void display(){

        for (Link<E> current = first; current != null; current = current.getNext()) {
            System.out.print(current+",");
        }

        System.out.println("\n");
    }
}
