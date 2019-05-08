package VideoCodealong;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph<T> implements GraphInterface<T> {

    //Instance data
    private Map<T, Vertex<T>> vertexes;
    private int vertCount;

    //Constructor
    public DirectedGraph(){
        vertexes = new HashMap<T, Vertex<T>>();
        vertCount = 0;
    }


    public boolean addVertex(T vertexLabel) {
        return false;
    }

    public boolean addEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    public boolean addEdge(T begin, T end) {
        return false;
    }

    public boolean hasEdge(T begin, T end) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int getNumberOfVertices() {
        return 0;
    }

    public int getNumberOfEdges() {
        return 0;
    }

    public void clear() {

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
