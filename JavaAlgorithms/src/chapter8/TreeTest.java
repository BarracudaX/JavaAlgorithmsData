package chapter8;

public class TreeTest {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(9);
        tree.insert(-1);
        tree.insert(8);

        tree.printInOrder();

        System.out.println("Minimum : "+tree.minimum());
        System.out.println("Maximum : "+tree.maximum());
    }

}
