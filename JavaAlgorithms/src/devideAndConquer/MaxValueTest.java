package devideAndConquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxValueTest {

    @Test
    public void shouldReturnTheMaxValue(){
        Integer[] ints = new Integer[]{1, 5, 100, 143, 1_000, 1_001};
        assertEquals(1001,MaxValue.findMax(Arrays.asList(ints)));
    }

}