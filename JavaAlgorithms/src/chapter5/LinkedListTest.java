package chapter5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> sut;

    @BeforeEach
    public void setUp(){
        sut = new LinkedList<>();
    }

    @Test
    public void shouldInsertNewElement(){
        assertTrue(sut.isEmpty());

        sut.insertFirst(2);

        assertFalse(sut.isEmpty());
        assertEquals(2, sut.removeFirst());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldRemoveAndReturnTheLastElementInserted(){
        sut.insertFirst(2);
        sut.insertFirst(3);
        sut.insertFirst(5);

        assertEquals(5,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(2,sut.removeFirst());
    }

    @Test
    public void shouldThrowIAEWhRemovingFromEmptyList(){
        assertTrue(sut.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> sut.removeFirst());
    }

    @Test
    public void shouldRemoveTheGivenElement(){
        sut.insertFirst(3);
        sut.insertFirst(5);
        sut.insertFirst(2);
        sut.insertFirst(4);

        sut.display();
        assertTrue(sut.remove(5));
        sut.display();

        assertEquals(4,sut.removeFirst());
        assertEquals(2,sut.removeFirst());
        assertEquals(3, sut.removeFirst());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldAddElementAsLast(){
        sut.insertFirst(1);
        sut.insertFirst(2);
        sut.insertLast(3);

        assertEquals(2, sut.removeFirst());
        assertEquals(1, sut.removeFirst());
        assertEquals(3, sut.removeFirst());
        assertTrue(sut.isEmpty());
    }

}