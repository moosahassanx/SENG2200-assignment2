// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			node class with next and previous pointers for linked list

public class Node<T> {
	// declare private variables and objects
	private PlanarShape data;
	private Node<T> next;
	private Node<T> previous;
	private int position;

	// constructor
	public Node(final PlanarShape shape) {
		// instantiate variables and objects
		data = shape;
		next = null;
		previous = null;
	}

	// mutator methods
	public void setData(final PlanarShape d) {
		data = d;
	}

	public void setPosition(final int pos) {
		position = pos;
	}

	public void setNext(final Node<T> n) {
		next = n;
	}

	public void setPrevious(final Node<T> n) {
		previous = n;
	}

	// accessor methods
	public PlanarShape getData() {
		return data;
	}

	public int getPosition(){
		return position;
	}

	public Node<T> getNext() {
		return next;
	}

	public Node<T> getPrevious() {
		return previous;
	}
}