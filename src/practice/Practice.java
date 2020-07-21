package practice;


class BinarySearchTree {

    class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);
    }
}