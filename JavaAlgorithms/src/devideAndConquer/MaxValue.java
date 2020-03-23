package devideAndConquer;

import java.util.List;

public class MaxValue {

    public static <E extends Comparable<E>>  E findMax(List<E> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        E element = list.get(0);

        E element2 = findMax(list.subList(1, list.size()));

        return element.compareTo(element2) >= 0 ? element : element2;
    }

}
