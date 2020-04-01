package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicLinkedListTest {

    CyclicLinkedList<Integer> sut = new CyclicLinkedList<>();


    @Test
    public void shouldInsertNewElement(){
        assertTrue(sut.isEmpty());

        sut.insert(2);

        assertFalse(sut.isEmpty());
        assertEquals(2, sut.remove());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldFindElement(){
        assertFalse(sut.search(2));

        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        assertTrue(sut.search(1));

        assertFalse(sut.search(6));

        assertEquals(3,sut.remove());
        assertEquals(2,sut.remove());
        assertEquals(1, sut.remove());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldThrowIAEWhenAskingForElementInEmptyList(){
        assertThrows(IllegalArgumentException.class, () -> sut.remove());
    }

    @Test
    public void IosiftFlaviya(){
        int numOfPeople = 7;

        int count = 3;

        sut.insert(1);

        for (int i = numOfPeople; i >= 2; i--) {
            sut.insert(i);
        }

        int last = -1;
        while (!sut.isEmpty()) {
            //STOP ON THE PERSON WHOSE NEXT IS GOING TO PERFORM THE RITUAL
            for (int i = 0; i < count-1; i++) {
                sut.step();
            }

            Integer next = sut.remove();
            if (sut.isEmpty()) {
                last = next;
                break;
            } else {
                System.out.print(next + ",");
                sut.step();//one more step because counting stops on the person before the person that is going to
                          //perform the "bad" ritual.
            }
        }

        System.out.println("\nLast : "+last);
    }

}