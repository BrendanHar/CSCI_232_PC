package Projects.Project4;



import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author yaw
 */
public class MinimumSpanningTree {

    private HashSet<Edge> mst;

    public MinimumSpanningTree(EdgeWeightedGraph graph) {
        mst = new HashSet<>();

        int[] connectedComponentMarker = new int[graph.getNumVertices()];
        for (int i = 0; i < connectedComponentMarker.length; i++) {
            connectedComponentMarker[i] = i;
        }

        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Edge edge : graph.getEdges()) {
            edgeQueue.add(edge);
        }

        while (!edgeQueue.isEmpty()) {
            Edge edge = edgeQueue.poll();
            if (connectedComponentMarker[edge.getVertices()[0]] != connectedComponentMarker[edge.getVertices()[1]]) {
                mst.add(edge);
                int newMarker = connectedComponentMarker[edge.getVertices()[0]];
                int oldMarker = connectedComponentMarker[edge.getVertices()[1]];
                for (int i = 0; i < connectedComponentMarker.length; i++) {
                    if (connectedComponentMarker[i] == oldMarker) {
                        connectedComponentMarker[i] = newMarker;
                    }
                }
            }
        }
    }

    public HashSet<Edge> getMST() {
        return mst;
    }
}
