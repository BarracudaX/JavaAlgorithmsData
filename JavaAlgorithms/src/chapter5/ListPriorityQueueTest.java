package chapter5;

import chapter4.PriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListPriorityQueueTest {


    ListPriorityQueue<Integer> sut ;

    @BeforeEach
    public void setUp(){
        sut = new ListPriorityQueue<>();
    }

    @Test
    public void shouldInsertNewElements(){
        assertTrue(sut.isEmpty());

        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        assertFalse(sut.isEmpty());
        assertEquals(1,sut.peek());
    }

    @Test
    public void shouldReturnElementsWithGreaterPriority(){
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
    public void shouldThrowIAEWhenAskingForElementInEmptyQueue(){
        assertTrue(sut.isEmpty());
        System.out.println(assertThrows(IllegalArgumentException.class, () -> sut.remove()).getMessage());
    }


}