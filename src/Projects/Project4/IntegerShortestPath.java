package Projects.Project4;

import java.util.LinkedList;

/**
 *
 * @author yaw
 */
public class IntegerShortestPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EdgeWeightedGraph graph = EdgeWeightedGraph.defaultGraph();


        String filename = args[0];
//        String filename = "path";
        EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(filename);

        //takes in args 2 and 3 as the start and end points of the search
        int startIndex = Integer.parseInt(args[1]);
        int endIndex = Integer.parseInt(args[2]);
//        int startIndex = 1;
//        int endIndex = 4;

        int checker = weightedGraph.getNumVertices();


        //transforms weighted graph into unweighted graph
        Graph unWeightedGraph = new Graph(weightedGraph);

        //creates a breadthFirst search to search the unweighted graph
        BreadthFirstSearch bfs = new BreadthFirstSearch(unWeightedGraph, startIndex);


        //To print out the output in terms of vertices of the original graph
        LinkedList<Integer> printer = bfs.getPathTo(endIndex);
        int totalCost = 0;
        System.out.print("Route: " + printer.getFirst());
        for (int i = 1; i < printer.size(); i++){
            totalCost++;
            if (printer.get(i) < checker){
                System.out.print("->" + printer.get(i));
            }
        }
        System.out.println();
        System.out.println("Total cost: " + totalCost + ".0");

    }
    
}
