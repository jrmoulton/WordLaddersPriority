
package WordLadders;

/**
 * Generic {@link LinkedList} implementation for a {@link Queue}
 */
public class LinkedList<E> {
	private Node<E> head;
	private Node<E> tail;

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
    }

    public void pushBack(E val) {
		this.tail.setNext(new Node<E>(val));
		this.tail = this.tail.getNext();
		if (this.head == null) {
			 this.head = this.tail;
		}
	}
	
	public void pushFront(E val) {
		 Node<E> temp = this.head;
		 this.head = new Node<E>(val);
		 this.head.setNext(temp);
		 if (temp == null) {
			  this.tail = this.head;
		 }
	}

	public E popFront() {
		Node<E> temp = this.head;
		this.head = this.head.getNext();
		return temp.getVal();
	}

	public E popBack() {
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
 
