
package WordLadders;

/**
 * Generic {@link Queue} implementation
 */
public class Queue<E> {
	private LinkedList<E> data = new LinkedList<E>();

	public void enqueue(E value) {
		data.pushBack(value);
	}

	public E dequeue() {
		 return data.popFront();
	}

	public boolean isEmpty() {
		 return data.isEmpty();
	}
}

