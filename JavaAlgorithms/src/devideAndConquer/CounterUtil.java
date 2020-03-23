package devideAndConquer;

import java.util.List;

public class CounterUtil {

    public static <E> int countElements(List<E> elements) {
        if (elements.isEmpty()) {
            return 0;
        }
        return 1 + countElements(elements.subList(0, elements.size()));
    }

}
