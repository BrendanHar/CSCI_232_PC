package Labs.Lab4;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(44);
        tree.insert(38);
        tree.insert(90);
        tree.insert(78);
        tree.insert(12);
        tree.insert(16);
        tree.insert(42);
        tree.insert(37);
        tree.insert(8);
        tree.insert(71);
        tree.modify(12, 98);
        tree.printTree();
        if (tree.isBST()){
            System.out.println("The tree is a BST");
        }
        else {
            System.out.println("the tree is not a BST");
        }
    }
}
