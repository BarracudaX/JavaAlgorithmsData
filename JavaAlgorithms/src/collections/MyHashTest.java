package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTest {

    private final MyHash<Integer> sut = new MyHash<>(5);

    @Test
    public void shouldAddNewElement(){
        assertFalse(sut.contains(5));

        sut.insert(5);

        assertTrue(sut.contains(5));
    }

    @Test
    public void shouldThrowIAEWhenInsertingDuplicates(){
        sut.insert(5);

        assertThrows(IllegalArgumentException.class, () -> sut.insert(5));
    }

    @Test
    public void shouldRemoveElement(){
        sut.insert(5);

        sut.remove(5);

        assertFalse(sut.contains(5));
    }

    @Test
    public void shouldAddMoreSpaceWhenNeeded(){
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);
        sut.insert(7);
        sut.insert(8);

        assertTrue(sut.contains(6));
        assertTrue(sut.contains(7));
        assertTrue(sut.contains(8));
    }

}