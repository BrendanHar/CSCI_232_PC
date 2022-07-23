package Labs.Lab10;

/**
 *
 * @author yaw
 */
public class MaxST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EdgeWeightedGraph graph = EdgeWeightedGraph.defaultGraph();


//        String filename = args[0];
        String filename = "src/Labs/Lab10/graph.txt";
        EdgeWeightedGraph test = new EdgeWeightedGraph(filename);

        MinimumSpanningTree mst = new MinimumSpanningTree(test);
        for(Edge edge : mst.getMST()) {
            System.out.println(edge);
        }

    }
    
}
