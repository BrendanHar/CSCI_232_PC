package Labs.Lab9;

import java.util.LinkedList;

/**
 *
 * @author yaw
 */
public class BFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        //was having problems with the javac command as it was one command line didn't recognize

        //So if the code doesn't run comment out test, runner, startIndex, endIndex and printer
        //and then just use the test1, runner1, and printer1 instances to check functionality

        //should create a graph from the first argument <String graphFileName>
        Graph test = new Graph(args[0]);
//        Graph test1 = new Graph("path");

        // creates to Ints from strings in argument positions 2 and 3
        int startIndex = Integer.parseInt(args[1]);
        int endIndex = Integer.parseInt(args[2]);

        //creates a BreadFirstSearch Instance using the graph created from commandline args
        BreadthFirstSearch runner = new BreadthFirstSearch(test, startIndex);
//        BreadthFirstSearch runner1 = new BreadthFirstSearch(test1, 0);

        //should get the output looking for
        LinkedList<Integer> printer = runner.getPathTo(endIndex);
        System.out.print("Route: " + printer.getFirst());
        for (int i = 1; i < printer.size(); i++){
            System.out.print("->" + printer.get(i));
        }
        System.out.println();

        //printer section for the test code
//        LinkedList<Integer> printer1 = runner1.getPathTo(5);
//        System.out.print("Route: " + printer1.getFirst());
//        for (int i = 1; i < printer1.size(); i++){
//            System.out.print("->" + printer1.get(i));
//        }
//        System.out.println();


    }
}
