package chapter3;

import chapter2.HighArray;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class BubbleArrayTest {

    @Test
    public void shouldSortTheArray(){
        BubbleArray<Integer> ints = new BubbleArray<>(10);

        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);

        ints.display();

        ints.bubbleSort();

        ints.display();
    }

    @Test
    public void shouldSortTheArray2(){
        BubbleArray<Integer> ints = new BubbleArray<>(10);

        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);

        ints.display();

        ints.bubbleSort2();

        ints.display();
    }

    @Test
    public void shouldFindMedian(){
        BubbleArray<Integer> ints = new BubbleArray<>(10);

        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);

        //2,3,4,5,9,18,34

        assertEquals(5,ints.median());
    }

    @Test
    public void shouldSortTheArray3() {
        BubbleArray<Integer> ints = new BubbleArray<>(10);

        ints.insert(4);
        ints.insert(18);
        ints.insert(3);
        ints.insert(2);
        ints.insert(9);
        ints.insert(5);
        ints.insert(34);
        ints.insert(10);

        ints.display();

        ints.oddEventSort();

        ints.display();

    }

}