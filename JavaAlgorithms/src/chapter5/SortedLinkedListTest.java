package chapter5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {

    SortedLinkedList<Integer> sut;

    @BeforeEach
    public void setUp(){
        sut = new SortedLinkedList<>();
    }

    @Test
    public void shouldInsertElementsKeepElementsInSortedOrder(){
        sut.insert(3);
        sut.insert(5);
        sut.insert(1);
        sut.insert(-1);

        assertEquals(-1,sut.removeFirst());
        assertEquals(1,sut.removeFirst());
        assertEquals(3,sut.removeFirst());
        assertEquals(5,sut.removeFirst());
    }

    @Test
    public void sortOfArrayUsingSortedLinkedList(){

        int[] box = new int[]{10, 23, 5, 18, 2, 6};

        for (int i = 0; i < box.length; i++) {
            sut.insert(box[i]);
        }

        for (int i = 0; i < box.length; i++) {
            box[i] = sut.removeFirst();
        }

        for (int i = 0; i < box.length; i++) {
            System.out.print(box[i]+",");
        }

    }

}
