package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionArrayTest {

    @Test
    public void shouldSortTheArray(){
        SelectionArray<Integer> ints = new SelectionArray<>(10);

        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);

        ints.display();

        ints.selectionSort();

        ints.display();

    }


}