package Projects.Project4;

/**
 *
 * @author yaw
 */
public class Edge implements Comparable<Edge> {

    private int vertex1;
    private int vertex2;
    private double weight;

    public Edge(int vertex1, int vertex2, double weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public int[] getVertices() {
        return new int[]{vertex1, vertex2};
    }

    public int getVertex1(){ return vertex1; }

    public int getVertex2(){ return vertex2; }

    public double getWeight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return "(" + vertex1 + "," + vertex2 + "): " + weight;
    }
    
    @Override
    public int hashCode() {
        return vertex1 + vertex2;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge)) {
            return false;
        }
        
        Edge otherEdge = (Edge) obj;
        
        if ((vertex1 == otherEdge.vertex1 && vertex2 == otherEdge.vertex2) || (vertex1 == otherEdge.vertex2 && vertex2 == otherEdge.vertex1)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        if (weight < otherEdge.weight) {
            return -1;
        } else if (weight > otherEdge.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}