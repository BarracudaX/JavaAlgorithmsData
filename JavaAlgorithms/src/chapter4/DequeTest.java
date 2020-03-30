package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    Deque<Integer> sut = new Deque<>(10);

    @Test
    public void shouldWorkAsStack(){
        sut.insertLeft(1);
        sut.insertLeft(2);
        sut.insertLeft(3);

        assertEquals(3,sut.removeLeft());
        assertEquals(2,sut.removeLeft());
        assertEquals(1, sut.removeLeft());

        sut.insertRight(1);
        sut.insertRight(2);
        sut.insertRight(3);

        assertEquals(3,sut.removeRight());
        assertEquals(2,sut.removeRight());
        assertEquals(1, sut.removeRight());

    }

    @Test
    public void shouldWorkAsQueue(){
        sut.insertLeft(1);
        sut.insertLeft(2);
        sut.insertLeft(3);

        assertEquals(1,sut.removeRight());
        assertEquals(2,sut.removeRight());
        assertEquals(3, sut.removeRight());

        sut.insertRight(1);
        sut.insertRight(2);
        sut.insertRight(3);

        assertEquals(1,sut.removeLeft());
        assertEquals(2,sut.removeLeft());
        assertEquals(3, sut.removeLeft());

    }

}