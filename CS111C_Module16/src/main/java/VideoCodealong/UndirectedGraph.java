package VideoCodealong;

import java.util.Stack;

public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T> {

    //Constructor
    public UndirectedGraph(){
        super();
    }

   @Override
    public boolean addEdge(T begin, T end, double weight){
        return super.addEdge(begin,end,weight) && super.addEdge(end, begin, weight);
    }

    @Override
    public boolean addEdge(T begin, T end){
        return this.addEdge(begin,end,0);
    }

    @Override
    public int getNumberOfEdges(){
        return super.getNumberOfEdges() / 2;
    }

    @Override
    public Stack<T> getTopologicalOrder(){
        throw new UnsupportedOperationException();
    }
}//UndirectedGraph
