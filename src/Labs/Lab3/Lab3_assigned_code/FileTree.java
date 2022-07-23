package Labs.Lab3.Lab3_assigned_code;

import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class FileTree {

    private Node root;
    private Node current;

    public FileTree() {
        root = new Node("~");
        current = root;
    }

    public String getCurrentLocation() {
        return current.getName();
    }
    
    public boolean moveDown(String directory) {
        ArrayList<Node> children = current.getChildren();
        for (Node child : children) {
            if (directory.equals(child.getName())) {
                current = child;
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
        }
    }

    public void goHome() {
        current = root;
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            files += c.getName() + " ";
        }
        return files;
    }

    public boolean insert(String directory) {
        if (directory != null && !directory.equals(" ")) {
            Node newFile = new Node(directory);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }
    
    public String getSubTree() {
        System.out.println(current.getName());
        int count = 0;
        int indent = 0;
        Node tempCurrent = current;
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
//            while (c != children.get(-1)){
//                System.out.println(c);
//            }
            if (c.getChildren() !=null){
                indent += 4;
                count += 1;
                System.out.println(c.getName().indent(indent));
                current = c;
                getSubTree(indent);
            }
            else{
                System.out.println(c.getName());
            }
        }
        current = tempCurrent;
        return null;
    }
    public String getSubTree(int num) {
        int count = 0;
        int indent = num;
        Node tempCurrent = current;
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
//            while (c != children.get(-1)){
//                System.out.println(c);
//            }
            if (c.getChildren() !=null){
                indent += 4;
                System.out.println(count + " " +  c.getName());
                current = c;
                getSubTree();
            }
            else{
                System.out.println(count + " " + c.getName());
            }
        }
        current = tempCurrent;
        return null;
    }
}
