package Projects.Project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree {

    private Node root;
    private Node current;
    private ArrayList<String> characteristicListTrue = new ArrayList<>();
    private ArrayList<String> characteristicListFalse = new ArrayList<>();

    public  Tree() {
        root = new Node("dog", "furry");
        root.addLeftChild("human", "bipedal");
        root.getLeftChild().setParent(root);
        root.addRightChild("snake", "scaly");
        root.getRightChild().setParent(root);
        current = root;
    }

    public String getCurrentLocation() {
        return current.getAnimal();
    }

    public void treeExplore(){
        String command = "";
        String animal;
        String characteristic;
        Scanner input = new Scanner(System.in);
        boolean check = false;
        Tree animalTree = treeCreate();
        Node tempCurrent = animalTree.current;
        while (check != true){
            String trueOutput = "";
            String falseOutput = "";
            System.out.print("Is this Animal " + current.getCharacteristic() +"? ");
            command = input.nextLine();
            if(command.equals("Y")|| command.equals("y")){
                characteristicListTrue.add(current.getCharacteristic());
                if (current.getLeftChild() != (null)) {
                    current = current.getLeftChild();
                }
                else{
                    System.out.print("Is this animal a " + current.getAnimal() + "? ");
                    command = input.nextLine();
                    if(command.equals("Y") || command.equals("y")){
                        System.out.println("Good.");
                        current = root;
                        characteristicListTrue = new ArrayList<>();
                        characteristicListFalse = new ArrayList<>();
                        check = true;
                    }
                    else if (command.equals("N") || command.equals("n")){
                        System.out.println("I don't know any" + characteristicTruePrint(trueOutput) + characteristicFalsePrint(falseOutput) + " animals that aren't a " + current.getAnimal() + ".");
                        System.out.print("What is the new animal? > ");
                        animal = input.nextLine();
                        System.out.print("What characteristic does a " + animal + " have that a " + current.getAnimal() + " does not? > ");
                        characteristic = input.nextLine();
                        current.addLeftChild(animal, characteristic);
                        current.getLeftChild().setParent(current);
                        System.out.println();
                        current = root;
                        characteristicListTrue = new ArrayList<>();
                        characteristicListFalse = new ArrayList<>();
                        check = true;
                    }
                    else {
                        System.out.println("Invalid Command. Please try again");
                    }
                }
            }

            else if (command.equals("N") || command.equals("n")){
                characteristicListFalse.add(current.getCharacteristic());
//                falseOutput += "not " + current.getCharacteristic() + ", ";
                if (current.getRightChild() != (null)){
                    current = current.getRightChild();
                }
//                else if(current.getRightChild() == null && current.getLeftChild() == null){
//                    System.out.println("I don't know any" + characteristicTruePrint(trueOutput) + characteristicFalsePrint(falseOutput) + " animals.");
//                    System.out.print("What is the new animal? > ");
//                    animal = input.nextLine();
//                    System.out.print("What characteristic does a " + animal + " have that a " + current.getParent().getAnimal() + " does not? > ");
//                    characteristic = input.nextLine();
//                    current.addRightChild(animal, characteristic);
//                    current.getRightChild().setParent(current);
//                    System.out.println();
//                    current = root;
//                    characteristicListTrue = new ArrayList<>();
//                    characteristicListFalse = new ArrayList<>();
//                    check = true;
//                }
                else {
                    System.out.print("Is this animal a " + current.getParent().getAnimal() + "? ");
                    command = input.nextLine();
                    if(command.equals("Y") || command.equals("y")){
                        System.out.println("Good.");
                        current = root;
                        characteristicListTrue = new ArrayList<>();
                        characteristicListFalse = new ArrayList<>();
                        check = true;
                    }
                    else if (command.equals("N") || command.equals("n")){
                        System.out.println("I don't know any" + characteristicTruePrint(trueOutput) + characteristicFalsePrint(falseOutput) + " animals that aren't a " + current.getParent().getAnimal() + ".");
                        System.out.print("What is the new animal? > ");
                        animal = input.nextLine();
                        System.out.print("What characteristic does a " + animal + " have that a " + current.getParent().getAnimal() + " does not? > ");
                        characteristic = input.nextLine();
                        current.addRightChild(animal, characteristic);
                        current.getRightChild().setParent(current);
                        System.out.println();
                        current = root;
                        characteristicListTrue = new ArrayList<>();
                        characteristicListFalse = new ArrayList<>();
                        check = true;
                    }
                    else {
                        System.out.println("Invalid Command. Please try again");
                    }
                }
            }

            else {
                System.out.println("Invalid Command. Please try again");
            }

        }

    }

    private String characteristicTruePrint(String output){
        for (int i =0; i< characteristicListTrue.size(); i++){
            output += ", " + characteristicListTrue.get(i) ;
        }
        return output;
    }
    private String characteristicFalsePrint(String output){
        for (int i =0; i< characteristicListFalse.size(); i++){
            output += ", not " + characteristicListFalse.get(i) ;
        }
        return output;
    }

    private Tree treeCreate(){
        Tree babyTree = new Tree();
        babyTree.root.setAnimal("dog");
        babyTree.root.setCharacteristic("furry");
        Node rightChild = new Node("Lizard", "Scaly");
        babyTree.root.addRightChild(rightChild);
        return babyTree;
    }

}
