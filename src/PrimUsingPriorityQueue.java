import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author swapnil
 *
 */
public class PrimUsingPriorityQueue  {
   
	public static void main(String[] args) throws FileNotFoundException {

		File f1 = new File("D:/EcNeon/SP0PQ/input.txt");
    	Timer timer = new Timer();
        
		Scanner sc = new Scanner(f1);
		Graph g = Graph.readGraph(sc, false);
		timer.start();
		int weight=PrimMstIndex(g);
    System.out.println("Weight of Graph Using IndexedHeap "+ weight);
    timer.end();
    System.out.println(timer);
    }

	public static int PrimMstIndex(Graph g) {
		ComparatorPQ c = new ComparatorPQ();
		IndexedHeap<Vertex> h = new IndexedHeap<Vertex>(g.numNodes, c);
		int weight = 0;
		g.verts.get(1).distance = 0;
		// make the weight of first vertex to be 0 so that it will not cause
		// problems in the algorithm.

		for (int i = 1; i <= g.numNodes; i++) {

			h.add(g.verts.get(i));

		}

		while (h.size > 0) {

			Vertex v = h.remove();
			v.seen = true;
			weight += v.distance;

			for (Edge e : v.Adj) {

				Vertex u = e.otherEnd(v);

				if (u.seen == false && u.distance > e.Weight) {
                   
					u.distance = e.Weight;
					h.percolateUp(u.getIndex());
				}
			
			}

		}
		return weight;
}	


}

