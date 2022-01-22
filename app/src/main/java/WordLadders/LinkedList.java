
package WordLadders;

/**
 * Generic {@link LinkedList} implementation for a {@link Queue}
 */
public class LinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	/**
	 * Constructor for a {@link LinkedList}
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public LinkedList(Node<E> head) {
		this.head = head;
		this.tail = head;
		this.size += 1;
	}

	public void pushBack(E val) {
		this.size += 1;
		Node<E> temp = this.tail;
		this.tail = new Node<E>(val);
		if (temp != null) {
			temp.setNext(this.tail);
		}
		if (this.head == null) {
			this.head = this.tail;
		}
	}

	public void pushFront(E val) {
		this.size += 1;
		Node<E> temp = this.head;
		this.head = new Node<E>(val);
		this.head = temp;
		if (temp == null) {
			this.tail = this.head;
		}
	}

	public E popFront() {
		this.size -= 1;
		Node<E> temp = this.head;
		this.head = this.head.getNext();
		return temp.getVal();
	}

	public E popBack() {
		this.size -= 1;
		Node<E> temp = this.tail;
		this.head = this.head.getNext();
		return temp.getVal();
	}

	public E peekFront() {
		return this.head.getVal();
	}

	public E peekBack() {
		return this.tail.getVal();
	}

	public boolean isEmpty() {
		return this.head == null;
	}
}
