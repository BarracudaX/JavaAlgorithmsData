package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTest {

    private final MyHash<String, Integer> sut = new MyHash<>(5);


    @Test
    public void shouldInsertNewElement(){
        assertFalse(sut.contains("one"));

        sut.insert("one", 1);

        assertTrue(sut.contains("one"));
    }

    @Test
    public void shouldReturnElement(){
        assertNull(sut.get("one"));

        sut.insert("one", 1);

        assertNotNull(sut.get("one"));

        assertEquals(1, sut.get("one"));
    }

    @Test
    public void shouldRemoveElement(){
        sut.insert("one", 1);

        sut.remove("one");

        assertNull(sut.get("one"));
    }

}