package Labs.Lab4;

/**
 *
 * @author yaw
 */
public class BinaryTree {

    private Node root;
    private Node current;

    public BinaryTree() {
        root = null;
        current = null;
    }

    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public void modify(int oldValue, int newValue) {
        if (root != null) {
            Node currentNode = root;
            boolean found = false;
            while (!found) {
                if (oldValue < currentNode.getValue()) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else if (oldValue > currentNode.getValue()) {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else {
                    currentNode.setValue(newValue);
                    found = true;
                }
            }
        }
    }


    public void printTree() {
        printTree(root, "");
    }

    public void printTree(Node in) {
        if (in == null) return;
        System.out.println(in.getValue());
        printTree(in.getLeft());
        printTree(in.getRight());
    }

    void printTree(Node node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " + " + node.getValue());
        printTree(node.getLeft() , prefix + " ");
        printTree(node.getRight() , prefix + " ");
    }


    boolean isBST()  {
        return isBST(root, -9999999,
                9999999);
    }

    boolean isBST(Node in, int min, int max){
        boolean check;
        if (in == null) {
            check = true;
            return true;
        }
        if (in.getValue() < min) {
            System.out.println("node found that is out of place: " + in.getValue());
            check = false;
            return false;
        }
        else if (in.getValue() > max){
            System.out.println("node found that is out of place: " + in.getValue());
            check = false;
            return false;
        }
        else {
            isBST(in.getLeft(), min, in.getValue()-1);
            isBST(in.getRight(), in.getValue()+1, max);
            check = true;
        }
        return check;
//        return (isBST(in.getLeft(), min, in.getValue()-1) && isBST(in.getRight(), in.getValue()+1, max));
    }
}
