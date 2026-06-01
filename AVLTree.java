class AVLNode {
    int key;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
    }
}

public class AVLTree {

    static boolean search(AVLNode root, int key) {
        while (root != null) {
            if (key == root.key)
                return true;
            else if (key < root.key)
                root = root.right;   // smaller → go RIGHT
            else
                root = root.left;    // larger → go LEFT
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("AVL Tree Search Program");
    }
}