package VideoCodealong;

import java.util.*;

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
        boolean foundIt = false;
        Vertex<T> beginVert = vertexes.get(begin);
        Vertex<T> endVert = vertexes.get(end);

        if (beginVert != null && endVert != null){
            Iterator<Vertex<T>> neighborIterator = beginVert.getNeighborIterator();
            while (neighborIterator.hasNext() && !foundIt){
                Vertex<T> neighbor = neighborIterator.next();
                if (endVert.equals(neighbor)){
                    foundIt = true;
                }
            }
        }

        return foundIt;
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
        resetVertices();
        Queue<T> transOrder = new LinkedList<T>();
        Queue<Vertex<T>> vertexQueue = new LinkedList<Vertex<T>>();

        Vertex<T> originVert = vertexes.get(origin);
        if (originVert != null){
            originVert.visit();

            transOrder.add(origin);
            vertexQueue.add(originVert);
        }

        while (!vertexQueue.isEmpty()){
            Vertex<T> frontVert = vertexQueue.remove();
            Iterator<Vertex<T>> neighborIterator = frontVert.getNeighborIterator();

            while (neighborIterator.hasNext()){
                Vertex<T> neighbor = neighborIterator.next();
                transOrder.add(neighbor.getData());
                vertexQueue.add(neighbor);
            }
        }
        return transOrder;
    }

    public Queue<T> getDepthFirstTraversal(T origin) {
        return null;
    }

    public Stack<T> getTopologicalOrder() {
        return null;
    }

    //Helper methods

    protected void resetVertices(){
        Iterator<Vertex<T>> vertexIterator = vertexes.values().iterator();
        while (vertexIterator.hasNext()){
            vertexIterator.next().unvisit();
        }
    }

    protected Vertex<T> findTerminal(){
        boolean found = false;
        Vertex<T> result = null;

        Iterator<Vertex<T>> vertexIterator = vertexes.values().iterator();

        while (!found && vertexIterator.hasNext()){
            Vertex<T> nextVert = vertexIterator.next();

            if (!nextVert.isVisted()){
                if (nextVert.getUnvistedNeighbor() == null){
                    found = true;
                    result = nextVert;
                }
            }
        }
        return result;
    }
}//DirectedGraph
