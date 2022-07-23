package Projects.Project1;

import Labs.Lab3.Lab3_assigned_code.FileTree;

import java.util.Locale;
import java.util.Scanner;

public class TreeManager {

    private Tree tree;

    public TreeManager() {
        tree = new Tree();
    }

    public void run() {
        String command = "";
        Scanner input = new Scanner(System.in);
        boolean check = false;

        while (check != true) {
            System.out.print("Do you have another animal to identify?(Y/N) ");
            command = input.nextLine();
            if (command.equals("Y") || command.equals("y")) {
//                System.out.println("Good its working now enter again");
                tree.treeExplore();
            } else if (command.equals("N") || command.equals("n")) {
                check = true;
            }
            else {
                System.out.println("Invalid Command. Please try again");
            }

        }
    }

}
