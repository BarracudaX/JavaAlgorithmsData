package insertionSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

class InsertionSortUtilTest {

    @Test
    public void shouldSortTheGivenArray(){
        Integer[] ints = new Integer[]{10_000, 5_000, 4_000, -10, 5, 20_000, 40_000, 5_5000, -5000};
        Assertions.assertFalse(Utils.isSortedAscendingOrder(ints));

        InsertionSortUtil.insertionSortAscendingOrder(ints);

        Assertions.assertTrue(Utils.isSortedAscendingOrder(ints));
    }


}