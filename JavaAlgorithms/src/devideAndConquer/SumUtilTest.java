package devideAndConquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumUtilTest {

    @Test
    public void shouldReturnTheSumOfInts(){
        int[] ints = new int[]{};

        assertEquals(0, SumUtil.sum(ints));

        ints = new int[]{1, 2, 3, 4, 5};

        assertEquals(15, SumUtil.sum(ints));
    }

}