import java.util.Comparator;

/**
 * @author swapnil
 *
 * @param <E>
 */
public class IndexedHeap<E> {

	Object[] arr;
	E arr1[];
	int maxLength;
	int size;
	Comparator<E> c;

	/**
	 * @param length
	 *            create a array of length+1 because first element is not used.
	 */
	IndexedHeap(int length, Comparator<E> c) {

		arr = new Object[length + 1];
		arr1 = (E[]) arr; // this is needed for the program to work.
		size = 0;
		this.c = c;
	}

	int size() {

		return size;

	}

	/**
	 * @param position
	 */
	void percolateDown(int position) {
				
		int max=position;
		int left=2*position;
		int right=2*position+1;
		if(left<=size && c.compare(arr1[left], arr1[position])<0){
			max=left;
		}
		if(right<=size && c.compare(arr1[right],arr1[max])<0){
			max=right;
		}		
		  if(max!=position){
			E temp=arr1[max];
			arr1[max]=arr1[position];
			arr1[position]=temp;
			((Vertex)arr1[max]).setIndex(max);
			((Vertex)arr1[position]).setIndex(position);
			percolateDown(max);
		  
		   }		

		
	}

	/**
	 * @param position
	 */
	void percolateUp(int position) {

		
		arr1[0] = arr1[position];

		while (c.compare(arr1[position / 2], arr1[0]) > 0) {

			arr1[position] = arr1[position / 2];
			((Vertex) arr1[position / 2]).setIndex(position);
			position = position / 2;
		}
		arr1[position] = arr1[0];
		((Vertex) arr1[position]).setIndex(position);

	}

	/**
	 * @param val
	 *            adding values to the array.
	 */
	void add(E val) {

		if (size < arr1.length) {
			size++;
			arr1[size] = val;
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

		return arr1[0];
	}

}