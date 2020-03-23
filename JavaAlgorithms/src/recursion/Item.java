package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {

    private static int counter = 0;

    private final boolean isBox ;

    private final boolean isKey ;

    private final boolean isItem;

    private final int itemId ;

    private final List<Item> items = new ArrayList<>();

    public Item(boolean isBox, boolean isKey, boolean isItem) {
        if (isBox == true && isKey == true) {;
            throw new IllegalArgumentException("Item cannot be both key and box");
        }
        this.itemId = counter++;
        this.isItem = isItem;
        this.isBox = isBox;
        this.isKey = isKey;
    }

    public void addItem(Item item) {
        if (isBox) {
            items.add(item);
        }
    }

    public boolean isKey() {
        return isKey;
    }

    public boolean isBox() {
        return isBox;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }
}
