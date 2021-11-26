// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{




    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
        // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;

        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode)
        {
            data = theData;
            prev = prevNode;
            next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int length;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList()
    {
        length = 0;
        head = null;
        tail = null;
    }


    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: TODO
     *
     * Justification: theta(1)
     *  if statement takes theta(1) to run
     */
    public boolean isEmpty()
    {
        if (head == null) {
            return true;
        }else {
            return false;
        }

    }


    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  worst case scenario is the loop has to go through the whole list and insert data at the end. the for loop
     *  take N running time and all the operations inside it take theta(1). multiplying them give us theta(N) * theta(1).
     *  taking highest order term we get theta(N). the other operations like the if statement and else take constant running time
     */
    public void insertBefore( int pos, T data ) {
        if (isEmpty()) {
            DLLNode newNode = new DLLNode(data, null, null);
            head = newNode;
            tail = newNode;
        } else if (pos <= 0) {
            DLLNode newHead = new DLLNode(data, null, head);
            head.prev = newHead;
            head = newHead;
        } else if (pos >= length) {
            DLLNode newTail = new DLLNode(data, tail, null);
            tail.next = newTail;
            tail = newTail;
        } else {
            DLLNode tempNode = head;
            for(int i = 0; i < pos; i++) {
                tempNode = tempNode.next;
            }
            DLLNode newNode = new DLLNode(data, null, null);
            newNode.prev = tempNode.prev;
            newNode.next = tempNode;
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
        }
        length++;
    }






    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  calling the isEmpty method take theta(1),  the for loop takes theta(N) and all the other basic operations take constant time
     *  multiplying them together gives us theta(N) * theta(1) and taking the highest order term we get theta(N)
     *
     */
    public T get(int pos) {
        if (isEmpty()) {
            return null;
        }
        int counter = 0;
        for (DLLNode j = head; j != null; j = j.next){
            if(counter == pos){
                return j.data;
            }
            counter++;
        }
        return null;
    }



    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  the worst scenario for the deleteAt method is when the last else statement is run, it will iterate through the elements of the list
     *  by going through the for loop. the time cost for the for loop is theta(N) * the theta(1) for the basic operations inside the for loop.
     *  multiplying them give theta(N) by taking the highest order term.
     */
    public boolean deleteAt(int pos) {
        if(pos < 0 || pos >= length) {
            return false;
        }else if(head == tail) {
            head = null;
            tail = null;
        }else if(pos == length - 1) {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }else if(pos == 0) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }else{
            DLLNode temporaryNode = head;
            for(int i = 0; i < pos; i++) {
                temporaryNode = temporaryNode.next;
            }
            temporaryNode.prev.next = temporaryNode.next;
            temporaryNode.next.prev = temporaryNode.prev;
            temporaryNode.prev = null;
            temporaryNode.next = null;
        }
        length--;
        return true;
    }


    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     * it will go through the while loop N times and swapping takes theta(1) therefore multiplying them
     * will again give us theta(N) by taking the highest order term
     */
    public void reverse()
    {
        DLLNode tempNode;
        DLLNode current = head;
        while (current != null) {
            tempNode = current.prev;
            current.prev = current.next;
            current.next = tempNode;
            current = current.prev;
        }
        tempNode = head;
        head = tail;
        tail = tempNode;
    }




    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: theta (N^2)
     *
     *
     * Justification:
     *  for the worst case the program will go through all the data and compare. the while loop will iterate N times.
     *  the inner while loop will also iterate N times. all the other basic processes have a running time of theta(1)
     *  multiplying everything we have N*N+ theta(1) = N^2 + theta(1) = theta(N^2)
     *
     */
    public void makeUnique()
    {
        DLLNode integer1;
        DLLNode integer2;
        integer1 = head;
        while (integer1 != null && integer1.next != null) {
            integer2 = integer1;
            while (integer2.next != null) {
                if (integer1.data == integer2.next.data) {
                    integer2.next = integer2.next.next;
                } else {
                    integer2 = integer2.next;
                }
            }
            integer1 = integer1.next;
        }
    }


    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification: the method has basic processes meaning it will have constant running time.
     */
    public void push(T item) {
        DLLNode tempNode = new DLLNode(item, null, null);
        if (isEmpty()) {
            head =  tempNode;
        } else {
            tail.next =  tempNode;
            tempNode.prev = tail;
        }
        tail =  tempNode;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     * the method has basic processes meaning it will have constant running time.
     */
    public T pop()
    {
        if (tail == null ) {
            return null;
        }else if (tail.prev != null) {
            DLLNode node = tail;
            tail = tail.prev;
            tail.next = null;
            return node.data;
        }else {
            DLLNode newNode = tail;
            head = null;
            tail = null;
            return newNode.data;
        }

    }


    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  the method has basic processes meaning it will have constant running time.
     */
    public void enqueue(T item) {
        DLLNode tempNode;
        tempNode = new DLLNode(item, null, null);
        if (isEmpty()) {
            head = tempNode;
        } else {
            tail.next = tempNode;
            tempNode.prev = tail;
        }
        tail = tempNode;
    }

    /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification: the method has basic processes meaning it will have constant running time.
     *
     */
    public T dequeue()
    {
        if (head == null ) {
           return null;
        }else if (head.next != null) {
                DLLNode node = head;
                head = head.next;
                head.prev = null;
                return node.data;

            }else {
            DLLNode node = head;
            head = null;
            tail = null;
            return node.data;
        }
    }


    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        boolean isFirst = true;

        // iterate over the list, starting from the head
        for (DLLNode iter = head; iter != null; iter = iter.next)
        {
            if (!isFirst)
            {
                s.append(",");
            } else {
                isFirst = false;
            }
            s.append(iter.data.toString());
        }

        return s.toString();
    }


}



