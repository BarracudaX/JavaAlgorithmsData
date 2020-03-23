package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyFinderTest {


    @Test
    public void shouldReturnTheKey(){
        Item outerBox = new Item(true, false, false);

        Item innerBox1 = new Item(true, false, false);
        Item innerInnerBox1 = new Item(true, false, false);
        Item innerBox2 = new Item(true, false, false);
        Item item1 = new Item(false, false, true);
        Item item2 = new Item(false, false, true);
        Item innerItem1 = new Item(false, false, true);
        Item innerItem1_2 = new Item(false, false, true);
        Item innerItem1_3 = new Item(false, false, true);
        Item innerItem2 = new Item(false, false, true);
        Item innerItem2_2 = new Item(false, false, true);
        Item innerItem2_3 = new Item(false, false, true);
        Item innerInnerItem1 = new Item(false, false, true);
        Item innerInnerItem2 = new Item(false, false, true);
        Item key = new Item(false, true, false);

        innerInnerBox1.addItem(innerInnerItem1);
        innerInnerBox1.addItem(innerInnerItem2);
        innerInnerBox1.addItem(key);

        innerBox1.addItem(innerInnerBox1);
        innerBox1.addItem(innerItem1);
        innerBox1.addItem(innerItem1_2);
        innerBox1.addItem(innerItem1_3);

        innerBox2.addItem(innerItem2);
        innerBox2.addItem(innerItem2_2);
        innerBox2.addItem(innerItem2_3);

        outerBox.addItem(innerBox1);
        outerBox.addItem(innerBox2);
        outerBox.addItem(item1);
        outerBox.addItem(item2);

        Item foundKey = KeyFinder.findKey(outerBox);

        assertNotNull(foundKey);
        assertEquals(key, foundKey);
    }

    @Test
    public void shouldReturnNullIfKeyWasNotFound(){

        Item outerBox = new Item(true, false, false);

        Item innerBox1 = new Item(true, false, false);
        Item innerInnerBox1 = new Item(true, false, false);
        Item innerBox2 = new Item(true, false, false);
        Item item1 = new Item(false, false, true);
        Item item2 = new Item(false, false, true);
        Item innerItem1 = new Item(false, false, true);
        Item innerItem1_2 = new Item(false, false, true);
        Item innerItem1_3 = new Item(false, false, true);
        Item innerItem2 = new Item(false, false, true);
        Item innerItem2_2 = new Item(false, false, true);
        Item innerItem2_3 = new Item(false, false, true);
        Item innerInnerItem1 = new Item(false, false, true);
        Item innerInnerItem2 = new Item(false, false, true);

        innerInnerBox1.addItem(innerInnerItem1);
        innerInnerBox1.addItem(innerInnerItem2);

        innerBox1.addItem(innerInnerBox1);
        innerBox1.addItem(innerItem1);
        innerBox1.addItem(innerItem1_2);
        innerBox1.addItem(innerItem1_3);

        innerBox2.addItem(innerItem2);
        innerBox2.addItem(innerItem2_2);
        innerBox2.addItem(innerItem2_3);

        outerBox.addItem(innerBox1);
        outerBox.addItem(innerBox2);
        outerBox.addItem(item1);
        outerBox.addItem(item2);

        assertNull(KeyFinder.findKey(outerBox));
    }
}