import java.util.Comparator;

public class ComparatorPQ implements Comparator<Vertex> {

	@Override
	public int compare(Vertex u, Vertex v) {
		
		return u.distance-v.distance;
	}

}
