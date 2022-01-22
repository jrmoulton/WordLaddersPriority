
package WordLadders;

/**
 * Generic {@link Node} implementation for a {@link LinkedList}
 */
public class Node<E> {
	private E val;
	private Node<E> next;

	public Node() {
		 this.val = null;
		 this.next = null;
	}
	public Node(E val, Node<E> next) {
		 this.val = val;
		 this.next = next;
	}
	public Node(E val) {
		 this.val = val;
		 this.next = null;
	}
    public E getVal() {
        return val;
    }
	public void setVal(E val) {
		 this.val = val;
	}
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
