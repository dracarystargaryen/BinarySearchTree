public class bst {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
 
        //generates the code 
        tree.place(10);
        for (int i = 0; i < 20; i++)
            tree.place((int) (Math.random() * 100));
        tree.display();
    }
}
 //main class
class BinarySearchTree {
    private Node root;
 
    private class Node {
        public static final int data = 0;
        private int key;
        private Node left, right;
        public Node next;
 
        Node(int l) {
            key = l;
        }
    }
 //places node 
    public boolean place(int key) {
        if (root == null)
            root = new Node(key);
        else {
            Node f = root;
            Node parent;
            while (true) {
                if (f.key == key)
                    return false;
 
                parent = f;
 
                boolean goLeft = key < f.key;
                f = goLeft ? f.left : f.right;
 
                if (f == null) {
                    if (goLeft) {
                        parent.left = new Node(key);
                    } else {
                        parent.right = new Node(key);
                    }
                    break;
                }
            }
        }
        return true;
    }
    void deleteNode(int key) 
    { 
        //Declares head node
        Node rode = root, prev = null;

        // Key holds node to be delted
        if (rode != null && Node.data == key) {
            root = rode.next; 
            return; 
        } 
  
        //Finds the next node to delete
        while (rode != null && Node.data != key) 
        { 
            prev = rode; 
            rode = rode.next; 
        }     
  
        // If key was not present in the tree
        if (rode == null) return; 
  
        // Remove the node from tree
        prev.next = rode.next; 
    } 
 //displays the binary tree
    public void display() {
        final int height = 9, width = 65;
 
        int len = width * height * 2 + 2;
        StringBuilder sr = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sr.append(i < len - 2 && i % width == 0 ? "\n" : ' ');
 
        displayR(sr, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sr);
    }
 
    private void displayR(StringBuilder sr, int v, int m, int k, int w, Node f,
            String edge) {
        if (f != null) {
            displayR(sr, v - k, m + 2, k / 2, w, f.left, " /");
 
            String s = String.valueOf(f.key);
            int idx1 = m * w + v - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sr.length())
                sr.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);
 
            displayR(sr, v + k, m + 2, k / 2, w, f.right, "\\ ");
        }
    }
}
