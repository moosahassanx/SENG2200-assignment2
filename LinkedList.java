import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// TITLE:                   Assignment1
// COURSE:                  SENG2200
// AUTHOR:                  Moosa Hassan
// STUDENT NUMBER:          3331532 
// DATE:                    22/03/2020 
// DESCRIPTION:             linked list class to manipulate nodes

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

        // no preconditions
        public boolean hasNext() {
            if(current.getNext() != sentinel){
                return true;
            }else{
                return false;
            }
        }

        // 2 preconditions: returns true and ________
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
        sentinel = null;
        length = 0;
    }

    // return list of polygons as a string
    public String toString() {
        // declare and instantiate string
        String printer = "";

        // loop for each node
        Iterator<T> iterator = iterator();

        if(sentinel == null){
            return printer;
        }
        
        printer += sentinel.getData().toString();
        printer += "\n";
        

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

        if (length == 0) { // no nodes exist
            // sentinel becomes temp
            sentinel = temp;

            // setting next and previous for sentinel
            sentinel.setNext(sentinel);
            sentinel.setPrevious(sentinel);

        } else { // 1 or more nodes exist
            temp.setNext(sentinel);
            temp.setPrevious(sentinel.getPrevious());

            // setting next of node before current
            sentinel.getPrevious().setNext(temp);
            sentinel.setPrevious(temp);

        }
        length++;
    }

    public void insertOrdered(T shape){

        Node<T> newNode = new Node<T>(shape);

        // SENTINEL MUST ALWAYS BE NULL AND MUST BE AT TOP OF THE LIST AT ALL TIMES
        // case: there are no nodes in the list
        if(sentinel == null){
            sentinel = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        }

        Node<T> afterNode = sentinel.getNext();

        // iterate through list until iterator finds node with greater value and assign afterNode
        while(afterNode != sentinel && afterNode.getData().compareTo(newNode.getData()) == 1){
            afterNode = afterNode.getNext();
        }

        // case: afterNode is the sentinel (full loop) AND afterNode value is equal to / greater than newNode
        if(afterNode == sentinel && afterNode.getData().compareTo(newNode.getData()) > 0){
            newNode.setData(sentinel.getData());
            sentinel.setData(shape);
        }

        // place newNode before afterNode
        Node<T> temp = afterNode.getPrevious();
        afterNode.setPrevious(newNode);
        newNode.setPrevious(temp);
        newNode.setNext(afterNode);
        temp.setNext(newNode);
    }

    /*
    JOSHS SUGGESTION:
    go back through and fuck around with it
    - afterNode == sentinel is wrong
    - trust in the sentinel null
    */

    // • take (then remove) an item from the head of the list
    public T remove() {
        Node<T> current = sentinel.getNext();

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

    // accessor method
    public int getLength() {
        return length;
    }

    // iterator method
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }
}