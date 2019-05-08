package VideoCodealong;

import java.util.ArrayList;
import java.util.List;

public class Vertex <T> {

    //Instance data
    private T data;
    private List<Edge<T>> edges;
    private boolean visted;

    //Constructor
    protected Vertex(T data){
        this.data = data;
        this.edges = new ArrayList<Edge<T>>();
        visted = false;
    }

    //Core methods
    protected void setData(T data){
        this.data = data;
    }

    protected T getData(){
        return data;
    }

    protected void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
    }

    protected List<Edge<T>> getEdges(){
        return new ArrayList<Edge<T>>(edges);
    }


}//Vertex
