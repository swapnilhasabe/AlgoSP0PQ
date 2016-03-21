
import java.util.Comparator;


/**
 * @author swapnil
 *
 * @param <E>
 */
public class BinaryHeap<E> implements Comparator<Edge> {

	Object[] arr1;
	int maxLength;
	int size;

	/**
	 * @param length
	 *            create a array of length+1 because first element is not used.
	 */
	BinaryHeap(int length) {

		arr1 = new Object[length + 1];
		size = 0;
	}

	int size() {

		return size;

	}

	void percolateDown(int position) {

int max=position;
int left=2*position;
int right=2*position+1;
if(left<=size && compare((Edge)arr1[left],(Edge)arr1[position])<0){
	max=left;
}
if(right<=size && compare((Edge)arr1[right],(Edge)arr1[max])<0){
	max=right;
}		
  if(max!=position){
	Object temp=(Edge)arr1[max];
	arr1[max]=arr1[position];
	arr1[position]=temp;
	percolateDown(max);
  
   }		

}

	void percolateUp(int position) {

		arr1[0] = arr1[position];

		while (compare((Edge) arr1[position / 2], (Edge) arr1[0]) > 0) {

			arr1[position] = arr1[position / 2];
			position = position / 2;
		}
		arr1[position] = arr1[0];
	}

	/**
	 * @param val
	 *            adding values to the array.
	 */
	void add(E val) {

		if (size < arr1.length) {
			size++;
			arr1[size] = (Edge)val;

			percolateUp(size);

		} else {

			throw new IndexOutOfBoundsException();
		}
	}

	E remove() {
		arr1[0] = arr1[1];
		arr1[1] = arr1[size];
		size--;
		percolateDown(1);
		return (E) arr1[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Edge o1, Edge o2) {
		return o1.Weight - o2.Weight;

	}

}
