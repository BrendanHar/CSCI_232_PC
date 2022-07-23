package Projects.Project1;

import java.util.ArrayList;

public class Node {
    private String animal;
    private String characteristic;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(String name, String characteristic) {
        this.animal = name;
        this.characteristic = characteristic;
    }

    public String getAnimal() {
        return animal;
    }

    public String getCharacteristic(){
        return characteristic;
    }


    public Node getParent() {
        return parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }
    public Node getRightChild() {
        return rightChild;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void addLeftChild(Node child) {
        this.leftChild = child;
    }

    public void addLeftChild(String animal, String characteristic) {
        Node child = new Node(animal, characteristic);
        this.leftChild = child;
    }

    public void addRightChild(Node child){
        this.rightChild = child;
    }

    public void addRightChild(String animal, String characteristic){
        Node child = new Node(animal, characteristic);
        this.rightChild = child;
    }


}
