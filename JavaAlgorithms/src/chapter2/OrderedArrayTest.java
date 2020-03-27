package chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedArrayTest {

    OrderedArray<Integer> sut = new OrderedArray<>(10);

    @Test
    public void shouldInsertNewElement(){
        assertFalse(sut.search(1));

        sut.insert(1);

        assertTrue(sut.search(1));

    }

    @Test
    public void shouldRemoveElement(){
        sut.insert(1);

        sut.delete(1);

        assertFalse(sut.search(1));

    }

    @Test
    public void shouldReturnThePositionOfTheElementInTheArrayOrNegative(){
        assertTrue(sut.findPos(1) < 0);

        sut.insert(1);

        assertEquals(0, sut.findPos(1));

    }

    @Test
    public void shouldReturnMax(){
        assertNull(sut.getMax());

        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        assertEquals(3, sut.getMax());
    }

    @Test
    public void shouldRemoveAndReturnMax(){
        sut.insert(2);
        sut.insert(3);
        sut.insert(5);

        assertEquals(5, sut.removeMax());
        assertEquals(3, sut.removeMax());
        assertEquals(2, sut.removeMax());
        assertNull(sut.removeMax());
    }

}