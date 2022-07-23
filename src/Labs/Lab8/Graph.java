package Labs.Lab8;

import java.util.HashSet;
import java.util.LinkedList;


/**
 *
 * @author yaw
 */
public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public int getNumVertices() {
        return adjacencyList.length;
    }
    
    public int getNumEdges() {
        return numEdges;
    }
    
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
        
        numEdges++;
    }
    
    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
    
    // Return the degree value of the provided vertex.
    public int getDegree(int vertex){
        int num = adjacencyList[vertex].size();
        return num;
    }
    
    // Return the degree value of the vertex with the largest degree value in the graph.
    public int getMaxDegree() {
        int max = 0;
//        int maxIndex = 0;
        for (int i = 0; i < adjacencyList.length; i++){
            if (adjacencyList[i].size() > max){
                max = adjacencyList[i].size();
            }
        }
        return max;
    }
    
    // Return whether or not the graph is a simple graph.
    public boolean isSimple() {
        for (int i = 0; i <adjacencyList.length; i++){
            int currentVertex = i;
//            int current = adjacencyList[i].getFirst();
            for (int k = 0; k < adjacencyList[i].size(); k++){
            }
            for (int j = 0; j <adjacencyList[i].size(); j++){
                int current = adjacencyList[i].get(j);
                for (int k = 0; k<adjacencyList[i].size();k++){
                    if (k != j){
                        int compare = adjacencyList[i].get(k);
                        if (current == currentVertex || current == compare){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
