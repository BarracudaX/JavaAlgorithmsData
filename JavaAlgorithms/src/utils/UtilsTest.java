package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {


    @Test
    public void shouldReturnTrueIfTheArrayOfElementsIsSortedInAscendingOrder(){
        Integer[] ints = new Integer[]{-5,-3,10,200,10_000,11_000,11_001};
        assertTrue(Utils.isSortedAscendingOrder(ints));
    }

    @Test
    public void shouldReturnFalseIfTheArrayOfElementsIsNotSortedInAScendingOrder(){
        Integer[] ints = new Integer[]{-5,-6,10,200,10_000,11_000,11_001};
        assertFalse(Utils.isSortedAscendingOrder(ints));

        ints = new Integer[]{-5,-6,10,200,10_000,11_000,11_001,10_999};
        assertFalse(Utils.isSortedAscendingOrder(ints));


    }

}