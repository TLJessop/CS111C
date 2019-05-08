package VideoCodealong;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public void connect(Vertex<T> endVertex, double weight){
        edges.add(new Edge<T>(weight , endVertex));
    }

    public void connect(Vertex<T> endVertex){
        edges.add(new Edge<T>(endVertex));
    }

    public boolean hasNeighbor(){
        return !edges.isEmpty();
    }

    public Iterator<Vertex<T>> getNeighborIterator(){
        return new NeighborIterator();
    }

    public Iterator<Double> getWeightIterator(){
        return new WeightIterator();
    }

    public Vertex<T> getUnvistedNeighbor(){
        Vertex<T> result = null;
        Iterator<Vertex<T>> neighborIterator = new NeighborIterator();

        while ((neighborIterator.hasNext()) && (result == null)){
            Vertex<T> nextVert = neighborIterator.next();
            if (nextVert.visted == false){
                result = nextVert;
            }
        }
        return result;
    }


    //Overridden methods
    @Override
    public String toString(){
        return data.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (getClass() == obj.getClass()){
            Vertex<?> other = (Vertex<?>) obj;

            if (this.data.equals(other.data) && (visted == other.visted)
                && (this.edges.size() == other.edges.size())){
                for (int i = 0; i < edges.size(); i++){
                    if (!edges.get(i).getEndVertex().equals(other.edges.get(i).getEndVertex()) ||
                            (edges.get(i).getWeight() != other.edges.get(i).getWeight())){
                        return false;
                    }
                }
            } else {
                return false;
            }

            return true;

        } else {
            return false;
        }
    }


    //private subclasses

    private class NeighborIterator implements Iterator<Vertex<T>>{
        //subclass data
        private Iterator<Edge<T>> edgeIterator;

        private NeighborIterator(){
            edgeIterator = edges.iterator();
        }

        public boolean hasNext() {
            return edgeIterator.hasNext();
        }

        public Vertex<T> next() {
            Vertex<T> nextNeighbor = null;

            if (edgeIterator.hasNext()){
                Edge<T>  nextEdge = edgeIterator.next();
                nextNeighbor = nextEdge.getEndVertex();

            } else {
                throw new NoSuchElementException();
            }

            return nextNeighbor;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    private class WeightIterator implements Iterator<Double>{
        //Subclass data
        private Iterator<Edge<T>> edgeIterator;

        private WeightIterator(){
            edgeIterator = edges.iterator();
        }

        public boolean hasNext() {
            return edgeIterator.hasNext();
        }

        public Double next() {
            Double nextWeight = null;

            if(edgeIterator.hasNext()){
                nextWeight = edgeIterator.next().getWeight();
            } else {
                throw new NoSuchElementException();
            }

            return nextWeight;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}//Vertex
