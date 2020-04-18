package chapter8;

public class Tree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public boolean contains(E key) {
        return contains(root,key);
    }

    private boolean contains(TreeNode<E> node, E key) {
        //NOT RECURSIVE SOLUTION
        for(TreeNode<E> current = root;
            current != null ;
            current = current.getElement().compareTo(key) < 0 ? current.getLeftNode() : current.getRightNode()
        ){
            if (current.getElement().equals(key)) {
                return true;
            }
        }

        return false;

        //RECURSIVE SOLUTION
//        if (node != null && node.getElement().equals(key)) {
//            return true;
//        }
//
//        if (node == null) {
//            return false;
//        }
//
//        if (node.getElement().compareTo(key) < 0) {
//            return contains(node.getLeftNode(), key);
//        }else{
//            return contains(node.getRightNode(), key);
//        }
    }

    public void insert(E element) {
        if (root == null) {
            root = new TreeNode<>(null, element, null);
            return;
        }

        TreeNode<E> current = root;

        while(true){
            if (current.getElement().compareTo(element) < 0 && current.getRightNode() != null) {
                current = current.getRightNode();
            } else if (current.getElement().compareTo(element) >= 0 && current.getLeftNode() != null) {
                current = current.getLeftNode();
            }else{
                break;
            }
        }

        if (current.getElement().compareTo(element) < 0) {
            current.setRightNode(new TreeNode<>(null,element,null));
        } else {
            current.setLeftNode(new TreeNode<>(null,element,null));
        }

        //RECURSIVE SOLUTION
//        insert(root, element);
    }

    public void printInOrder(){
        if (root == null) {
            return ;
        }
        System.out.println("\n");
        printInOrder(root);
        System.out.println("\n");
    }

    private void printInOrder(TreeNode<E> node) {
        if (node == null) {
            return ;
        }

        printInOrder(node.getLeftNode());

        System.out.print(node.getElement() + ",");

        printInOrder(node.getRightNode());
    }

    private void insert(TreeNode<E> node, E element) {
        if (node.getRightNode() == null && node.getElement().compareTo(element) >= 0) {
            node.setRightNode(new TreeNode<>(null, element, null));
        } else if (node.getLeftNode() == null && node.getElement().compareTo(element) < 0) {
            node.setLeftNode(new TreeNode<>(null, element, null));
        } else if (node.getElement().compareTo(element) < 0) {
            insert(node.getLeftNode(),element);
        }else{
            insert(node.getRightNode(),element);
        }
    }

    public E minimum(){
        if (root == null) {
            return null;
        }

        TreeNode<E> current = root;

        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }

        return current.getElement();

        //RECURSIVE SOLUTION
//        return minimum(root);
    }

    private E minimum(TreeNode<E> node) {
        if (node.getLeftNode() == null) {
            return node.getElement();
        }
        return minimum(node.getLeftNode());
    }

    public E maximum(){
        if (root == null) {
            return null;
        }

        TreeNode<E> current = root;

        while (current.getRightNode() != null) {
            current = current.getRightNode();
        }

        return current.getElement();

        //RECURSIVE SOLUTION
//        return maximum(root);
    }

    private E maximum(TreeNode<E> node) {
        if (node.getRightNode() == null) {
            return node.getElement();
        }
        return maximum(node.getRightNode());
    }

    public boolean remove(E key) {
        if (root == null) {
            return false;
        }

        TreeNode<E> parent = root,current = root;

        boolean isLeftNode = true;

        while (!current.equals(key)) {

            parent = current;

            if (current.getElement().compareTo(key) > 0) {
                isLeftNode = true;
                current = current.getLeftNode();
            } else {
                isLeftNode = false;
                current = current.getRightNode();
            }

            if (current == null) {
                return false;
            }

        }

        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftNode) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }
        } else if (current.getLeftNode() == null) {
            if( root == current){
                root = root.getRightNode();
            }else if (isLeftNode) {
                parent.setLeftNode(current.getRightNode());
            } else {
                parent.setRightNode(current.getRightNode());
            }
        } else if (current.getRightNode() == null) {
            if( root == current){
                root = root.getLeftNode();
            }else if (isLeftNode) {
                parent.setLeftNode(current.getLeftNode());
            } else {
                parent.setRightNode(current.getLeftNode());
            }
        }else{
            TreeNode<E> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftNode) {
                parent.setLeftNode(successor);
            }else{
                parent.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        }

        return true;
    }

    private TreeNode<E> getSuccessor(TreeNode<E> node){
        TreeNode<E> successor = node;
        TreeNode<E> successorParent = node;
        TreeNode<E> current = node.getRightNode();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }

        if (node.getRightNode() != successor) {
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(node.getRightNode());
        }

        return  successor;
    }


}
