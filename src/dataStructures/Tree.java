package dataStructures;

class Tree {

    class Node {
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key) {
            this.key = key;
        }

        public void display() {
            System.out.print(key + " ");
        }
    }

    Node root;

    public Tree() {
        root = null;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if(root == null)
            root = node;
        else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if(current.key > key) {
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }

                }
            }
        }

    }

    public int size(Node root) {
        if(root == null)
            return 0;
        return size(root.leftChild) + 1 + size(root.rightChild);
    }

    public int height(Node root) {
        if(root == null)
            return 0;
        int leftHeight = 1 + height(root.leftChild);
        int rightHeight = 1 + height(root.rightChild);

        return Math.max(leftHeight, rightHeight);
    }

    // revise
    public void morrisTraversal(Node root) {
        if(root == null)
            return;
        Node current = root;
        Node pre;
        while (current != null) {
            if(current.leftChild == null){
                current.display();
                current = current.rightChild;
            } else {
                pre = current.leftChild;
                while (pre.rightChild != null && pre.rightChild != current)
                    pre = pre.rightChild;

                // no cyclic link -> create
                if(pre.rightChild == null) {
                    pre.rightChild = current;
                    current = current.leftChild;
                } else {
                    pre.rightChild = null;
                    current.display();
                    current = current.rightChild;
                }
            }
        }
    }

}

class BSTMain {
    public static void main(String[] args) {
        /*
                  20
               /      \
              10        30
             /  \      /  \
            5   15    25  35
         */
        Tree bst = new Tree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);

//        bst.traverse(1);
//        System.out.println();
//        bst.traverse(2);
//        System.out.println();
//        bst.traverse(3);
//        System.out.print("min: ");
//        bst.findMin(bst.root);
//        System.out.println("level order ");
//        bst.levelOrderTraversal(bst.root);
//        System.out.println("spiral order ");
//        bst.printSpiralOrder(bst.root);
//
//        System.out.println("LCA");
//        bst.LCA(bst.root, 10, 14).display();
//        System.out.println("LCA_Iterative");
//        bst.LCA_Iterative(bst.root, 10, 14).display();
//
//        System.out.println("printKthSmallestElement");
//        bst.printKthSmallestElement(bst.root, 3);
//
//        System.out.println("size:" + bst.size(bst.root));
//        System.out.println("height" + bst.height(bst.root));
//        System.out.println("--Level Order--");
//        bst.printLevelOrder(bst.root);
//        System.out.println("--Left Order--");
//        bst.printLeftView(bst.root, 1);
//        System.out.println("--Vertical Order--");
//        bst.printVerticalOrder(bst.root);
//        System.out.println("--distanceBetween2Nodes--");
//        System.out.println(bst.distanceBetween2Nodes(bst.root, 10, 5));
    }
}