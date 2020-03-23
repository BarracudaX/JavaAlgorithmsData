package collections;

import java.util.ArrayList;
import java.util.List;

public class MyHash<E> {

    private List<E>[] elements;

    private int hashSize;

    private int elementsInHash;

    private double load ;

    @SuppressWarnings("unchecked")
    public MyHash(int hashSize) {
        this.hashSize = hashSize;
        this.elements = (List<E>[]) new List[hashSize];
        this.elementsInHash = 0;
        this.load = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new ArrayList<>();
        }
    }

    public void insert(E element) {
        elementsInHash = elementsInHash + 1;
        load = elementsInHash/ ( hashSize*1.0) ;

        int pos = element.hashCode() % elements.length;

        if (elements[pos].contains(element)) {
            throw new IllegalArgumentException("Element " + element + " alread exists in the hash");
        }

        elements[pos].add(element);

        if (load >= 0.7) {
            reload();
        }

    }

    @SuppressWarnings("unchecked")
    private void reload() {
        List<E> oldElements = new ArrayList<>();

        for (List<E> list : elements) {
            oldElements.addAll(list);
        }


        elements = (List<E>[]) new List[elements.length * 2];
        elementsInHash = 0;
        hashSize = elements.length;

        for (int i = 0; i < elements.length; i++) {
            elements[i] = new ArrayList<>();
        }

        for (E oldElement : oldElements) {
            insert(oldElement);
        }

    }

    public void remove(E element) {
        elements[element.hashCode() % elements.length].remove(element);
    }

    public E get(E element) {
        E found = null;

        for (E e : elements[element.hashCode() % elements.length]) {
            if (e.equals(element)) {
                found = element;
            }
        }

        return element;
    }

    public boolean contains(E element) {
        return elements[element.hashCode()%elements.length].contains(element);
    }

}
