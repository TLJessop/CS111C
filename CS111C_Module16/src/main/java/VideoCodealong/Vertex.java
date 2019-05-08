package VideoCodealong;

import java.util.LinkedList;
import java.util.List;

public class Vertex <T> {

    //Instance data
    private T data;
    private List<Edge<T>> edges;
    private boolean visted;

    //Constructor
    public Vertex(T data){
        this.data = data;
        this.edges = new LinkedList<Edge<T>>();
        visted = false;
    }

    //Core methods
    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void visit(){
        visted = true;
    }

    public void unvisit(){
        visted = false;
    }

    public boolean isVisted() {
        return visted;
    }

    public void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
    }

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public void connect(Vertex<T> endVertex, double weight){
        edges.add(new Edge<T>(weight , endVertex));
    }

    public void connect(Vertex<T> endVertex){
        edges.add(new Edge<T>(endVertex));
    }

    @Override
    public String toString(){
        return data.toString();
    }

}//Vertex
