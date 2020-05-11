// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			node class with next and previous pointers for linked list

public class Node<T> {
	// declare private variables and objects
	private T data;
	private T next;
	private T previous;
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

	public void setNext(final T n) {
		next = n;
	}

	public void setPrevious(final T n) {
		previous = n;
	}

	// accessor methods
	public T getData() {
		return data;
	}

	public int getPosition(){
		return position;
	}

	public T getNext(){
		return next;
	}

	public T getPrevious(){
		return previous;
	}
}