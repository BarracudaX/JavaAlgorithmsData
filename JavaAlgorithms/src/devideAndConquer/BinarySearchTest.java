package devideAndConquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    public void shouldReturnTheIndexAtWhichTheElementResides(){
        Integer[] ints = new Integer[]{-4, 50, 102, 204, 402, 40_000, 55_102, 5_000_000, 5_000_001};
        assertEquals(0, BinarySearch.binarySearch(ints,-4));
        assertEquals(ints.length-1, BinarySearch.binarySearch(ints,5_000_001));
        assertEquals(4, BinarySearch.binarySearch(ints,402));
    }

    @Test
    public void shouldReturnNegativeIndexIfElementsWasNotFound(){
        Integer[] ints = new Integer[]{-4, 50, 102, 204, 402, 40_000, 55_102, 5_000_000, 5_000_001};
        assertTrue(BinarySearch.binarySearch(ints, -5) < 0);
        assertTrue(BinarySearch.binarySearch(ints, 10_000_000) < 0);
    }

}