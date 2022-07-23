package Labs.Lab8;

/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph test = new Graph(6);
        test.addEdge(0,1);
//        test.addEdge(1,0);
        test.addEdge(0,2);
//        test.addEdge(1,2);
        test.addEdge(1,3);
        test.addEdge(2,4);
//        test.addEdge(1,4);
//        test.addEdge(3,4);
        test.addEdge(3,5);
        test.addEdge(4,5);
        int vertex = 5;
        System.out.println("Number of Edges at vertex " + vertex + ": " + test.getDegree(vertex));
        System.out.println("Max number of Edges at any given vertex: " + test.getMaxDegree());
        System.out.println("Is the graph simple?: " + test.isSimple());
    }
}
