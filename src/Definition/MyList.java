package Definition;

import Adt.MyListADT;

/**
 * This class is the Definition class for Link List Implementation
 *
 * @see Adt.MyListADT
 * it Implements the {@link MyListADT} and Overide its Methods
 */
public class MyList<E> implements MyListADT<E> {
    /**
     * This variable will hold the size of the link list
     */
    public int size = 0;
    /**
     * This reference variable will hold the value for the first node of our list
     * Its Initial value is null when the list is empty
     */
    private Node head = null;

    /**
     * This Method will return a node at the specified index
     *
     * @param index The value of index
     * @return The node at the index
     */
    private Node<E> getNode(int index) {
        /*
          A variable the will initially hold the starting value of the List
         */


        Node<E> response = head;
        /*
          A loop for traversing the whole list till the index
          and passing that node to response
         */

        for (int i = 0; i < index; i++) {
            /*
              one by one changing the value of response
             */
            response = response.getNext();

        }

        return response;

    }

    /**
     * @param item  data to be added
     * @param index index at which data is to be added
     *              This Method add a Node in the list with data item at a specified index
     */
    public void add(E item, int index) {
        /*
         *index cannot be less then 0 and more than size of th link list
         * if such index passed throw a Exception
         */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        /*
          if index passed is 0 than call the addFirst() method

         */
        else if (index == 0) {
            addFirst(item);
        }
        /*
          call the addAfter() method and get the node value by calling getNode() method
         */
        else {
            addAfter(item, getNode(index - 1));
        }

    }

    /**
     * This method will add a node with data passed to the starting of the list
     *
     * @param item data to be added
     */
    private void addFirst(E item) {
        /*
          create a new node with reference value that head initally was holding
          Change the reference of the head to the new node created
         */
        head = new Node(item, head);
        /*
          increase the size of the list by 1
         */
        size++;
    }

    /**
     * This method will add a new node with a data item passed and after a specified node
     *
     * @param item      Data item of the  new node that is to be added
     * @param afternode the node after which the new node is to be added
     */
    private void addAfter(E item, Node<E> afternode) {
        /*
          create a new node with reference value that afternode initally was holding
          Change the reference of the afternode to the new node created
         */
        afternode.next = new Node<>(item, afternode.next);
        size++;

    }

    /**
     * This method will add a node to the last of the list
     *
     * @param item The data item to be added
     */
    @Override
    public void add(E item) {
        /*
          call the add() method and passed the size of the List as Index so that the node add to the last
         */
        add(item, size);

    }

    /**
     * This method will remove the first node from the list and return the data of that node
     *
     * @return the node that is deleted
     */
    private E removeFirst() {
        /*
          make a temp variable to hold the initial head value
         */
        Node<E> temp = head;
        /*
          initaiallze the resonse variable to be returned
         */
        E response = null;
        /*
          check if list is not empty i.e., head is not null
         */
        if (head != null) {
            /*
              change the reference of the head to the next node
             */
            head = head.getNext();
        }
        /*
          check if temp variable is not null
         */
        if (temp != null) {
            /*
              decrease the size of the list
             */
            size--;
            /*
              pass the data of the temp(previous reference of head ) to response variable
             */
            response = temp.getData();

        }
        return response;
    }

    /**
     * This method will remove a node after a specified node and will return data of that node
     *
     * @param afternode the node after of which the node is to be remove
     * @return data of the node removed
     */
    private E removeAfter(Node<E> afternode) {
        /*
          make a temp variable to hold the reference of the afternode (for the data to be returned)
         */
        Node<E> temp = afternode.getNext();
        /*
          Check if temp is not null
         */
        if (temp != null) {
            /*
              change the reference of the node to the reference of the node to be deleted
             */
            afternode.next = temp.getNext();
            /*
              decrease the size by 1
             */
            size--;
        }
        /*
          response hold the data of the removed node
         */
        E response = temp.getData();
        return response;
    }

    /**
     * This method will remove a node at a specified index
     *
     * @param index the value of index
     * @return data of tha removed node
     */

    public E remove(int index) {
        E response;
        /*
          check if index is less then 0 or more than size of the list
          if yes throw an exception
         */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        /*
          if passed index is 0 call the removeFirst() method
         */
        else if (index == 0) {
            response = removeFirst();
        }
        /*
          call the removeAfter() method and get the afternode value by getNode() method
         */
        else {
            Node<E> previousNode = getNode(index - 1);
            response = removeAfter(previousNode);
        }
        return response;
    }

    /**
     * This method will remove the last node of the list and return the data of that node
     *
     * @return data of the node removed
     */
    @Override
    public E remove() {
        return remove(size - 1);
    }

    /**
     * This method will return data of the node at a particular index
     *
     * @param index The index of the node of which we have to get the data
     * @return data of the node
     */
    @Override
    public E getData(int index) {
        /*
          call the getNode() method and get the data of that node by getData() method
         */
        return getNode(index).getData();
    }

    /**
     * A private static class that will represent a single element of our list
     * this class has a data value  and a reference value
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Constructor to initalize the data and next fields of the node class
         *
         * @param data data of the node
         * @param next reference of the node
         */

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Getter method of the data field
         *
         * @return data of the node
         */

        public E getData() {
            return data;
        }

        /**
         * Getter method of the next field
         *
         * @return reference of the node
         */
        public Node<E> getNext() {
            return next;
        }
    }
}
