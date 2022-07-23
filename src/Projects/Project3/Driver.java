package Projects.Project3;



/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creates test with nodes 0 - 10
        //Run exactly as is should output 4 connected segments | 0-5 | 6,7,9 | 10 | 8
        Graph test = new Graph(11);
        test.addEdge(0,1);
        test.addEdge(0,2);
        test.addEdge(1,3);
        test.addEdge(2,4);
        test.addEdge(3,5);
        test.addEdge(4,5);
        test.addEdge(6,7);
        test.addEdge(9,7);
//        test.addEdge(10,1);
        int vertex = 5;

        test.printConnectedComponents();
    }
}
