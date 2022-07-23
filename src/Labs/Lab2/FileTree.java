package Labs.Lab2;

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
//        String[] tempPath = directory.split("/");
//
//        if (tempPath[0].equals(root)){
//            current = moveDown(tempPath.)
//            while tempPath[]
//        }

        for (Node c : children) {
            if (directory.equals(c.getName())) {
                current = c;
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

    public String getPath(){
        ArrayList<Node> tempList = new ArrayList<>();
        Node currentNode = current;
        String filePath = "/";
        while (currentNode != null){
             tempList.add(currentNode);
             currentNode = currentNode.getParent();
        }
        for (int j = tempList.size() - 1 ; j >= 0; j--){
            filePath += tempList.get(j).getName() + "/";
        }
        return filePath;
    }

    public boolean remove(String directory){
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
            if (c.getName() == directory){
                current.removeChild(directory);
                return true;
            }
        }
        return false;
    }

}
