// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					15/05/2020 
// DESCRIPTION: 			generic node class with next and previous pointers for linked list

public class Node<T> {
	// declare private variables and objects
	private T data;
	private Node<T> next;
	private Node<T> previous;
	private int position;

	// constructor
	public Node(final T shape) {
		// instantiate variables and objects
		data = shape;
		next = null;
		previous = null;
	}

	// mutator methods
	public void setData(final T d) {
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
	public T getData() {
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