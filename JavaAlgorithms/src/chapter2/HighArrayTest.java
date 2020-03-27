package chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighArrayTest {

    HighArray<Integer> sut = new HighArray<>(10);

    @Test
    public void shouldInsertNewElements(){
        assertFalse(sut.search(1));

        sut.insert(1);

        assertTrue(sut.search(1));
    }

    @Test
    public void shouldDeleteElement(){
        sut.insert(1);

        sut.delete(1);

        assertFalse(sut.search(1));
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

    @Test
    public void shouldReturnHowManyDuplicatesExist(){
        sut.insert(1);

        assertEquals(0, sut.howManyDuplicates(1));

        sut.insert(1);

        assertEquals(1, sut.howManyDuplicates(1));
    }

    @Test
    public void shouldReturnNegativeNumberWhenAskingForDuplicatesOfNotExistingElement(){
        assertTrue(sut.howManyDuplicates(1) < 0);
    }

    @Test
    public void shouldRemoveAllTheDuplicatesOfEachElement(){
        sut.insert(1);
        sut.insert(2);
        sut.insert(1);
        sut.insert(3);
        sut.insert(1);
        sut.insert(4);
        sut.insert(3);

        assertEquals(7,sut.getNumberOfElements());
        assertEquals(2, sut.howManyDuplicates(1));
        assertEquals(1, sut.howManyDuplicates(3));

        sut.noDuplicates();

        assertEquals(4,sut.getNumberOfElements());
        assertEquals(0, sut.howManyDuplicates(1));
        assertEquals(0, sut.howManyDuplicates(3));

    }
}