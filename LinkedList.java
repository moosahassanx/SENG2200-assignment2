// TITLE:                   Assignment2
// COURSE:                  SENG2200
// AUTHOR:                  Moosa Hassan
// STUDENT NUMBER:          3331532 
// DATE:                    15/05/2020 
// DESCRIPTION:             linked list class to manipulate nodes

// importing java libraries (file scanner and string output)
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T> {
    // declare private variables
    private Node<T> sentinel;
    private int length;

    private class SimpleIterator implements Iterator<T>{
        private int expectedModCount;
        private Node<T> current;

        // the one with an object of polygon being passed through
        public SimpleIterator() {
            // instantiate private variables
            expectedModCount = length;            // line needs to change
            current = sentinel;
        }

        // check existence of next element
        public boolean hasNext() {
            // case1: node after current is not sentinel
            if(current.getNext() != sentinel){
                return true;
            }
            
            // case2: node after current is sentinel (full loop)
            else{
                return false;
            }
        }

        // based off lecture slides
        public T next() {

            if(length != expectedModCount){
               throw new ConcurrentModificationException("Cannot mutate in context of iterator");
            }

            if(!hasNext()){
                throw new NoSuchElementException("There are no more elements");
            }

            current = current.getNext();
            
            return current.getData();
        }
    }

    // the one with an object of polygon being passed through
    public LinkedList() {
        // instantiate private variables
        sentinel = new Node<T>(null);
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
        length = 0;
    }

    // return list of polygons as a string
    public String toString() {
        // declare and instantiate string
        String printer = "";

        // loop for each node
        Iterator<T> iterator = iterator();

        // check existence of next element
        while(iterator.hasNext()){
            printer += iterator.next().toString();
            printer += "\n";
        }

        // return string
        return printer;
    }

    // add items into the start of the list
    public void prepend(T shape) {
        // same as append but with extra steps
        append(shape);

        // (current item is the new first in list)
        sentinel = sentinel.getPrevious();
    }

    // items into the end of the list (current item is the first in list),
    public void append(T shape) {
        // create new temp node
        Node<T> temp = new Node<T>(shape);

        // case1: no nodes exist
        if (length == 0) { 
            // sentinel becomes temp
            sentinel = temp;

            // setting next and previous for sentinel
            sentinel.setNext(sentinel);
            sentinel.setPrevious(sentinel);
        } 

        // case2: 1 or more nodes exist
        else { 
            temp.setNext(sentinel);
            temp.setPrevious(sentinel.getPrevious());

            // setting next of node before current
            sentinel.getPrevious().setNext(temp);
            sentinel.setPrevious(temp);

        }
        length++;       // increment length counter
    }

    public void insertOrdered(T shape){

        // declaring required nodes
        Node<T> newNode = new Node<T>(shape);        
        Node<T> afterNode = sentinel.getNext();

        // iterate through list until full loop && node with greater value has been found        
        while(afterNode != sentinel && afterNode.getData().compareTo(newNode.getData()) < 1){
            afterNode = afterNode.getNext();
        }

        // insert before
        newNode.setPrevious(afterNode.getPrevious());
        afterNode.getPrevious().setNext(newNode);
        afterNode.setPrevious(newNode);
        newNode.setNext(afterNode);
        
        // incrementing counter
        length++;
    }

    // • take (then remove) an item from the head of the list
    public T remove() {

        Node<T> current = sentinel.getNext();       // current node

        // case1: there are no nodes in the linked list
        if (length == 0) {
            // do nothing
        }

        // case2: there is 1 node in the linked list
        else if (length == 1) {
            sentinel = null;
        }

        // create a temporary node which will duplicate sentinel
        else {
            Node<T> temp = sentinel;

            // remove the original sentinel by tying the nodes before and after with each
            // other
            sentinel.getNext().setPrevious(sentinel.getPrevious());
            sentinel.getPrevious().setNext(sentinel.getNext());

            // the node after sentinel becomes the new sentinel
            sentinel = current;

            // iteration and returning
            length--;
            return temp.getData();
        }

        // returning current node
        return current.getData();
    }

    // accessor methods
    public T getSentinel() {
        return sentinel.getData();
    }

    public int getLength() {
        return length;
    }
    
    // iterator method
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }
}