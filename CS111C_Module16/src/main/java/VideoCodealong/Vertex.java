package VideoCodealong;

import java.util.ArrayList;
import java.util.List;

public class Vertex <T> {

    //Instance data
    private T data;
    private List<Edge<T>> edges;
    private boolean visted;

    //Constructor
    public Vertex(T data){
        this.data = data;
        this.edges = new ArrayList<Edge<T>>();
        visted = false;
    }

    //Core methods
    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
    }

    public List<Edge<T>> getEdges(){
        return new ArrayList<Edge<T>>(edges);
    }


}//Vertex
