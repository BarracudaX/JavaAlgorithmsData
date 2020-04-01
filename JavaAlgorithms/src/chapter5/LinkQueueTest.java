package chapter5;

import chapter4.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkQueueTest {


    LinkQueue<Integer> sut ;

    @BeforeEach
    public void setUp(){
        sut = new LinkQueue<>();
    }

    @Test
    public void shouldInsertNewElements(){
        assertTrue(sut.isEmpty());

        sut.insert(1);

        assertFalse(sut.isEmpty());

        assertEquals(1, sut.peek());

    }

    @Test
    public void shouldRemoveAndReturnTheFirstElementInserted(){
        sut.insert(1);
        sut.insert(2);

        assertEquals(1,sut.remove());
        assertEquals(2, sut.remove());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldThrowIAEWhenAskingForElementInEmptyQueue(){
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        sut.remove();
        sut.remove();
        sut.remove();

        assertThrows(IllegalArgumentException.class, () -> sut.remove());

        sut.insert(4);

        assertEquals(4, sut.remove());
    }

}