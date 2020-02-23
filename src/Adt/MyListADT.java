package Adt;

/**
 * This Interface will be the ADT for our Linked List Data Structure that we are going to use in  our Application
 * This Adt will define the methods that are available for use
 * 1. Add a item at end or an specified index
 * 2. Remove a item from end or from a specified Index
 * 3. Get data present in the list at specified Index
 */
public interface MyListADT<E> {

    /**
     * This Method will add a node to the end of the link List
     * This method will self create a node with the passed data item by the User
     *
     * @param item The data item to be added
     */
    void add(E item);

    /**
     * This method will Remove node from the end of the List and will return the same item
     *
     * @return The data that is removed
     */
    E remove();

    /**
     * This method will Get the data of the the node present at the passed Index
     *
     * @param index The index of the node which we have to get the data
     * @return The data present at the Specified Node
     */
    E getData(int index);


}
