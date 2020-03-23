package devideAndConquer;

import java.util.Arrays;

public class SumUtil {

    public static int sum(int[] table) {
        if (table.length == 0) {
            return 0;
        }
        return table[0] + sum(Arrays.copyOfRange(table, 1,table.length));
    }

}
