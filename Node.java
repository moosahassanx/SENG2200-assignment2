// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			node class with next and previous pointers for linked list

public class Node{
	// declare private variables and objects
	private Polygon data;
	private Node next, previous;
	private int position;

	// constructor
	public Node(final Polygon d) {
		// instantiate variables and objects
		data = d;
		next = null;
		previous = null;
	}

	// mutator methods
	public void setData(final Polygon d) {
		data = d;
	}

	public void setPosition(final int pos) {
		position = pos;
	}

	public void setNext(final Node n) {
		next = n;
	}

	public void setPrevious(final Node n) {
		previous = n;
	}

	// accessor methods
	public Polygon getData(){
		return data;
	}

	public int getPosition(){
		return position;
	}

	public Node getNext(){
		return next;
	}

	public Node getPrevious(){
		return previous;
	}
}