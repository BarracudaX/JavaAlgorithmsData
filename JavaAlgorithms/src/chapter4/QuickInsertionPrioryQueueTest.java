package chapter4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickInsertionPrioryQueueTest {

    QuickInsertionPrioryQueue<Integer> sut ;

    @BeforeEach
    public void setUp(){
        sut = new QuickInsertionPrioryQueue<>(3);
    }

    @Test
    public void shouldInsertNewElements(){
        assertTrue(sut.isEmpty());
        assertFalse(sut.isFull());

        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        assertTrue(sut.isFull());
        assertFalse(sut.isEmpty());
        assertEquals(1,sut.peek());
    }

    @Test
    public void shouldReturnElementsWithMinValue(){
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        assertEquals(1, sut.remove());
        assertEquals(2, sut.remove());
        assertEquals(3, sut.remove());

        sut.insert(4);
        sut.insert(8);
        sut.insert(2);

        assertEquals(2, sut.remove());
        assertEquals(4, sut.remove());
        assertEquals(8, sut.remove());
    }

    @Test
    public void shouldThrowIAEWhenInsertingIntoFullQueue(){
        sut.insert(4);
        sut.insert(8);
        sut.insert(2);

        assertTrue(sut.isFull());
        System.out.println(assertThrows(IllegalArgumentException.class, () -> sut.insert(1)).getMessage());

    }

    @Test
    public void shouldThrowIAEWhenAskingForElementInEmptyQueue(){
        assertTrue(sut.isEmpty());
        System.out.println(assertThrows(IllegalArgumentException.class, () -> sut.remove()).getMessage());
    }

    @Test
    public void testDisplay(){
        sut.insert(4);
        sut.insert(8);
        sut.insert(2);

        sut.display();
    }
}