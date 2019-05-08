package VideoCodealong;

public class Edge <T> {

    //Instance data
    private double weight;
    private Vertex<T> endVertex;

    //Constructor
    protected Edge(double weight, Vertex<T> endVertex){
        this.endVertex = endVertex;
        this.weight = weight;
    }

    protected Edge(Vertex<T> endVertex){
        this(0,endVertex);
    }

    //Primary methods
    protected double getWeight(){
        return weight;
    }

    protected Vertex<T> getEndVertex(){
        return endVertex;
    }
}//Edge
