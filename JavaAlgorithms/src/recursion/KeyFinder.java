package recursion;

public class KeyFinder {

    public static Item findKey(Item item) {

        if (item.isKey()) {
            return item;
        }

        for (Item itemItem : item.getItems()) {
            Item key = findKey(itemItem);
            if (key != null) {
                return key;
            }
        }

        return null;
    }


}
