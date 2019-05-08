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

    //Unlike the professor's version I am going to allow cyclic graphs thus there is no check againist itself
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

    @Override
    public String toString(){
        return data.toString();
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
            return null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}//Vertex
