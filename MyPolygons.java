// TITLE:                   Assignment1
// COURSE:                  SENG2200
// AUTHOR:                  Moosa Hassan
// STUDENT NUMBER:          3331532 
// DATE:                    22/03/2020 
// DESCRIPTION:             linked list class to manipulate nodes

public class MyPolygons{
    // declare private variables
    private Node current;
    private Node sentinel;
    private int length;
    private int nodePosition;

    // the one with an object of polygon being passed through
    public MyPolygons(){
        // instantiate private variables
        current = null;
        sentinel = null;
        length = 0;
        nodePosition = 0;
    }

    // return list of polygons as a string
    public String toString(){
        // declare and instantiate string
        String printer = "";

        // loop for each node
        for (int i = 0; i < length; i++){
            // add string to polygon
            printer = printer + current.getData().toString() + "\n";
            // iterate to next node
            next();
        }

        // return string
        return printer;
    }

    // add items into the start of the list
    public void prepend(Polygon polygonObject){
        // same as append but with extra steps
        append(polygonObject);
        
        // (current item is the new first in list)
        sentinel = sentinel.getPrevious();
        reset();
    }

    // items into the end of the list (current item is the first in list),
    public void append(Polygon polygonObject){
        // create new temp node
        Node temp = new Node(polygonObject);

        if (length == 0){                               // no nodes exist
            // sentinel becomes temp
            sentinel = temp;
            
            // setting next and previous for sentinel
            sentinel.setNext(sentinel);
            sentinel.setPrevious(sentinel);
            
            // current = sentinel
            reset();
        }else{                                          // 1 or more nodes exist
            temp.setNext(sentinel);
            temp.setPrevious(sentinel.getPrevious());
            
            // setting next of node before current
            sentinel.getPrevious().setNext(temp);
            sentinel.setPrevious(temp);
            
            // current = sentinel
            reset();
        }
        length++;
    }

    public MyPolygons insertSort(){                                // note to self: double check prepend()
        System.out.println("Sorted List:");

        MyPolygons sortedList = new MyPolygons();

        reset();                // set current as sentinel (first position) TOP LIST

        // iterate through unsorted list
        for (int i = 0; i < length; i++){
            // current = sentinel but for sorted list
            sortedList.reset();
            
            if (sortedList.getLength() == 0){                                                   // no nodes in sorted list
                // simply add to the list
                sortedList.append(sentinel.getData());
            }else if (current.getData().comesBefore(sortedList.current.getData())){             // node being added is less than the first node in the list
                // add before the current node int he list
                sortedList.prepend(current.getData());
            }else{
                // go to node after current (sentinel)
                sortedList.next();

                // iterate through what is currently in the sorted list
                for (int j = 1; j < sortedList.getLength(); j++){
                    if (current.getData().comesBefore(sortedList.getCurrent())){                // node being added is less than the node being tested in the sorted list
                        break;
                    }else{
                        // iterate to next node
                        sortedList.next();
                    }
                }
                // insert before the node being tested
                sortedList.insert(current.getData());
            }
            // test next node
            next();
        }
        // return new list
        return sortedList;
    }

    // accessor method for position of node
    public int getPosition(Node n){
        // create temporary node
        Node tempNode = sentinel;

        int i = 1;
        while (i <= length){
            if (tempNode == n){                        // sentinel matches the input node
                return i;
            }else{
                // iterate to next node
                tempNode = tempNode.getNext();
            }
            i++;
        }
        return 1;
    }

    // • insert before a specified (current) item
    public void insert(Polygon polygonObject){
        if (length == 0){                                   // no nodes exist
            // follow append steps
            append(polygonObject);
            current = sentinel;
        }else{                                              // 1 or more nodes exist
            // new temp node with data
            Node tempNode = new Node(polygonObject);
            
            // setting previous and next of temp node
            tempNode.setPrevious(current.getPrevious());
            tempNode.setNext(current);
            
            // setting next of node before current
            current.getPrevious().setNext(tempNode);
            current.setPrevious(tempNode);
            length++;
        }
    }

    // • take (then remove) an item from the head of the list
    public Polygon remove(){            
        current = sentinel.getNext();

        if (length == 0){                        // if there are no nodes in the linked list
            // do nothing
        }else if (length == 1){                    // if there is 1 node in the linked list
            sentinel = null;
        }else{
            // create a temporary node which will duplicate sentinel
            Node temp = sentinel;

            // remove the original sentinel by tying the nodes before and after with each other
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

    // set next node of current as current current
    public void next(){
        current = current.getNext();
    }

    // reset position of circular doubly linked list
    public void reset(){
        current = sentinel;
        nodePosition = 1;
    }

    // accessor methods
    public Polygon getCurrent(){
        return current.getData();
    }

    public Polygon getSentinel(){
        return sentinel.getData();
    }

    // accessor method
    public int getLength(){
        return length;
    }
}