package chapter5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    DoubleLinkedList<Integer> sut;

    @BeforeEach
    public void setUp(){
        sut = new DoubleLinkedList<>();
    }

    @Test
    public void shouldInsertAtTheBeginning(){
        sut.insertFirst(2);
        sut.insertFirst(3);
        sut.insertFirst(4);

        assertFalse(sut.isEmpty());
        assertEquals(4,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(2, sut.removeFirst());
        assertTrue(sut.isEmpty());

        sut.insertFirst(2);
        sut.insertFirst(3);
        sut.insertFirst(4);

        assertEquals(2,sut.removeLast());
        assertEquals(3,sut.removeLast());
        assertEquals(4,sut.removeLast());
    }

    @Test
    public void shouldInsertAtTheEnd(){
        sut.insertLast(4);
        sut.insertLast(3);
        sut.insertLast(2);

        assertFalse(sut.isEmpty());
        assertEquals(2,sut.removeLast());
        assertEquals(3,sut.removeLast());
        assertEquals(4, sut.removeLast());
        assertTrue(sut.isEmpty());

        sut.insertLast(4);
        sut.insertLast(3);
        sut.insertLast(2);

        assertEquals(4,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(2,sut.removeFirst());
    }

    @Test
    public void shouldInsertAfterGivenElement(){
        sut.insertFirst(4);
        sut.insertFirst(3);
        sut.insertFirst(2);

        sut.insertAfter(3, 5);

        assertEquals(2,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(5,sut.removeFirst());
        assertEquals(4, sut.removeFirst());
        assertTrue(sut.isEmpty());
    }

    @Test
    public void shouldRemoveGivenElement(){
        sut.insertFirst(4);
        sut.insertFirst(3);
        sut.insertFirst(2);
        sut.insertFirst(1);

        assertFalse(sut.remove(5));
        assertTrue(sut.remove(2));

        assertEquals(1,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(4,sut.removeFirst());

    }

    @Test
    public void shouldThrowIEWhenAskingForElementInEmptyList(){
        assertThrows(IllegalArgumentException.class, () -> sut.removeFirst());
        assertThrows(IllegalArgumentException.class, () -> sut.removeLast());
        assertThrows(IllegalArgumentException.class, () -> sut.remove(2));
    }

    @Test
    public void shouldReturnIterator(){
        sut.insertFirst(2);
        sut.insertFirst(8);
        sut.insertFirst(10);
        sut.insertFirst(12);

        Iterator<Integer> iterator = sut.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(12,iterator.next());
        assertEquals(10,iterator.next());
        assertEquals(8,iterator.next());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorShouldThrowNSEExceptionIfNoElementsLeft(){
        assertThrows(NoSuchElementException.class, () -> sut.iterator().next());

        sut.insertFirst(12);
        sut.insertFirst(10);

        Iterator<Integer> iterator = sut.iterator();

        iterator.next();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void iteratorShouldRemoveElements(){
        sut.insertFirst(2);
        sut.insertFirst(8);
        sut.insertFirst(10);
        sut.insertFirst(12);

        Iterator<Integer> iterator = sut.iterator();

        iterator.remove();
        iterator.remove();

        assertEquals(8,sut.removeFirst());
        assertEquals(2, sut.removeFirst());
        assertTrue(sut.isEmpty());
    }

}