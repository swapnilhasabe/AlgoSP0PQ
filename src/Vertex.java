/**
 * Class to represent a vertex of a graph
 * 
 *
 */

import java.util.*;

public class Vertex {
    public int name; // name of the vertex
    public boolean seen; // flag to check if the vertex has already been visited
    public Vertex parent; // parent of the vertex
    public int distance; // distance to the vertex from the source vertex
    public List<Edge> Adj, revAdj; // adjacency list; use LinkedList or ArrayList
    public int incomingDegree; 
    public int outDegree;
    public int degree;
    public int top;
    public int componentNumber;
    public int index;
        /**
     * Constructor for the vertex
     * 
     * @param n
     *            : int - name of the vertex
     */
    Vertex(int n) {
	name = n;
	seen = false;
	parent = null;
	Adj = new ArrayList<Edge>();
	revAdj = new ArrayList<Edge>();   /* only for directed graphs */
    degree=0;
	incomingDegree=0;
    outDegree=0;
    top=1;
    componentNumber=0;
    distance=Integer.MAX_VALUE;  //set all vertices distance infinity for prim's algorithm
    index=n;
    }
    public int getIndex() {
		return index;

	}
    public void setIndex(int index) {
		this.index = index;

	}
    /**
     * Method to represent a vertex by its name
     */
    public String toString() {
	return Integer.toString(name);
    }
}