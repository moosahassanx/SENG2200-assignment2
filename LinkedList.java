import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// TITLE:                   Assignment1
// COURSE:                  SENG2200
// AUTHOR:                  Moosa Hassan
// STUDENT NUMBER:          3331532 
// DATE:                    22/03/2020 
// DESCRIPTION:             linked list class to manipulate nodes

public class LinkedList<T> implements Iterable<T> {
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

    
    // CAN FOCUS ON THIS AFTER EVERYTHING ELSE IS DONE!
    public LinkedList<T> insertSort() {
        System.out.println("Sorted List:");

        LinkedList<T> sortedList = new LinkedList<T>();

        Node<T> current = sentinel;

        // THIS WILL CAUSE NULL POINTER EXCEPTION BUT BRUH IM STILL WORKING ON IT

        /*
        // iterate through unsorted list
        for (int i = 0; i < length; i++) {
            // current = sentinel but for sorted list
            sortedList.reset();

            // case1: no nodes in sorted list
            if (sortedList.getLength() == 0) {
                sortedList.append(sentinel.getData());      // simply add to the list
            }

            // case2: node being added is less than the first node in the list
            else if (current.getData().compareTo(sortedList.current.getData()) == 1) {
                sortedList.prepend(current.getData());                                      // add before the current node int he list
            }

            // case3:
            else {
                sortedList.next(); // go to node after current (sentinel)

                // iterate through what is currently in the sorted list
                for (int j = 1; j < sortedList.getLength(); j++) {
                    // node being added is less than the node being tested in the sorted list
                    if (current.getData().compareTo(sortedList.getCurrent()) == 1) {
                        break;
                    }

                    else {
                        sortedList.next(); // iterate to next node
                    }
                }

                // insert before the node being tested
                sortedList.insert(current.getData());
            }

            // test next node
            next();
        }
        */

        // return new list
        return sortedList;
    }

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