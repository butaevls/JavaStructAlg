package HomeWork6;

public class Tree {

    Node root;

    int insert(Person p) {
        int i = 1;
        Node node = new Node();
        node.person = p;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                i++;
                parent = current;
                if (p.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                }
            }
        }
        return i;
    }

    void order(Node root) {
        if (root != null) {
            order(root.leftChild);
            root.display();         //посещение узла
            order(root.rightChild);
        }
    }

    boolean isBalanced(boolean allChilds)
    {
        int leftSize;
        int rightSize;

        if (allChilds) {
            leftSize = size(this.root, true); // если рассматривать все ветки
            rightSize = size(this.root, false);
        } else {
            leftSize = size(this.root.leftChild, true); // если рассматривать только глубину левого
            rightSize = size(this.root.rightChild, true); // и правого ответвления
        }

        if (Math.abs(leftSize - rightSize) > 1) {
            return false;
        } else {
            return true;
        }
    }

    private int size(Node node, boolean max)
    {
        if ( node == null ) {
            return 0;
        }
        int left = size(node.leftChild, max);
        int right = size(node.rightChild, max);
        if (max) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }


    }
}


