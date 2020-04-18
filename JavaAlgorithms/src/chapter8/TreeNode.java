package chapter8;

public class TreeNode<E> {

    private final E element;

    private TreeNode<E> leftNode;

    private TreeNode<E> rightNode;

    public TreeNode(TreeNode<E> leftNode, E element, TreeNode<E> rightNode) {
        this.element = element;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }
}
