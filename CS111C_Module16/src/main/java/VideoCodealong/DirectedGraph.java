package VideoCodealong;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph<T> implements GraphInterface<T> {

    //Instance data
    private Map<T, Vertex<T>> vertexes;
    private int edgeCount;

    //Constructor
    public DirectedGraph(){
        vertexes = new HashMap<T, Vertex<T>>();
        edgeCount = 0;
    }


    public boolean addVertex(T vertexLabel) {
        Vertex<T> result = vertexes.put(vertexLabel, new Vertex<T>(vertexLabel));
        return result == null;
    }

    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;
        Vertex<T> beginVert = vertexes.get(begin);
        Vertex<T> endVert = vertexes.get(end);

        if (beginVert != null && endVert != null){
            beginVert.connect(endVert, edgeWeight);
            edgeCount ++;
            result = true;
        }

        return result;
    }

    public boolean addEdge(T begin, T end) {
        return addEdge(begin,end,0);
    }

    public boolean hasEdge(T begin, T end) {
        return false;
    }

    public boolean isEmpty() {
        return vertexes.isEmpty();
    }

    public int getNumberOfVertices() {
        return vertexes.size();
    }

    public int getNumberOfEdges() {
        return edgeCount;
    }

    public void clear() {
        vertexes.clear();
        edgeCount = 0;
    }

    public Queue<T> getBreadthFirstTraversal(T origin) {
        return null;
    }

    public Queue<T> getDepthFirstTraversal(T origin) {
        return null;
    }

    public Stack<T> getTopologicalOrder() {
        return null;
    }
}//DirectedGraph
