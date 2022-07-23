package Projects.Project3;

import java.util.HashSet;
import java.util.LinkedList;


/**
 *
 * @author yaw
 */
public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    private boolean check[];
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        check = new boolean[getNumVertices()];
        
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
    
    public void printConnectedComponents() {
        for (int i = 0; i < adjacencyList.length; i++){
            if(!check[i]){
                System.out.print("|  {");
                pcc(i);
                System.out.print("}  |");
            }
        }
    }

    public void pcc(int n){
        System.out.print(n + ",");
        check[n] = true;
        for (int neighbor : getNeighbors(n)){
            if (!check[neighbor]){
                pcc(neighbor);
            }
        }
    }
}
