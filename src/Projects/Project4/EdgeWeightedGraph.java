package Projects.Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class EdgeWeightedGraph {

    private LinkedList<Edge>[] adjacencyList;
    private HashSet<Edge> edges;
    
    public EdgeWeightedGraph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        edges = new HashSet<>();
    }

    public EdgeWeightedGraph(String filename) {

        try {
            File graphIn = new File(filename);
            if (!graphIn.exists()) {
                System.out.println("Invalid input. Check your filename");
            }
            else {
                Scanner s = new Scanner(graphIn);
                Scanner count = new Scanner(graphIn);
                int lines = 0;
                count.nextLine();
                while (count.hasNextLine()) {
                    count.nextLine();
                    lines++;
                }

                String[] text = new String[lines];
                String input = "";
                int size = s.nextInt();
                int i = 0;


                while (s.hasNextLine()) {
                    input += s.nextLine();
                    input += "\n";
                }


                text = input.split("\n");

                String[] test = new String[2];
                int[] arr = new int[3];

                adjacencyList = new LinkedList[size];
                for (int j= 0; j < adjacencyList.length; j++){
                    adjacencyList[j] = new LinkedList<>();
                }
                edges = new HashSet<>();


                for (int j = 0; j < lines + 1; j++){
                    test = text[j].split(",");
                    for (int k = 0; k < test.length; k++){
                        if (!test[k].equals("")) {
                            arr[k] = Integer.parseInt(test[k]);
                        }
                    }

                    addEdge(arr[0], arr[1], arr[2]);
                }
            }
        }
        catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public int getNumVertices() {
        return adjacencyList.length;
    }

    public int getNumEdges() {
        return edges.size();
    }

    public void addEdge(int vertex1, int vertex2, double weight) {
        Edge edge = new Edge(vertex1, vertex2, weight);
        if (edges.add(edge)) {
            adjacencyList[vertex1].add(edge);
            adjacencyList[vertex2].add(edge);
        }
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }
    
    public static EdgeWeightedGraph defaultGraph() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(6);
        
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 4);
        
        return graph;
    }
}
