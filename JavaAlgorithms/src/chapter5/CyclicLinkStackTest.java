package chapter5;

import chapter4.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicLinkStackTest {


    CyclicLinkStack<Integer> sut ;

    @BeforeEach
    public void setUp(){
        sut = new CyclicLinkStack<>();
    }

    @Test
    public void shouldInsertNewElements(){
        sut.push(1);
        sut.push(2);
        sut.push(3);

        assertEquals(3,sut.peek());
    }

    @Test
    public void shouldRemoveAndReturnTheTopElement(){
        sut.push(1);
        sut.push(2);
        sut.push(3);

        assertEquals(3, sut.pop());

        assertEquals(2, sut.pop());

    }

    @Test
    public void shouldThrowIAEWhenAskingForElementInEmptyStack(){
        assertThrows(IllegalArgumentException.class, () -> sut.peek());
        assertThrows(IllegalArgumentException.class, () -> sut.pop());
    }

    @Test
    public void shouldReturnTopElementWithoutRemovingItFromTheStack(){
        sut.push(1);
        sut.push(2);

        assertEquals(2,sut.peek());
        assertEquals(2,sut.peek());
    }

    @Test
    public void charactersReversed(){
        Stack<Character> word = new Stack<>(11);
        word.push('h');
        word.push('e');
        word.push('l');
        word.push('l');
        word.push('o');
        word.push(',');
        word.push('w');
        word.push('o');
        word.push('r');
        word.push('l');
        word.push('d');

        while (!word.isEmpty()) {
            System.out.print(word.pop());
        }

    }

}