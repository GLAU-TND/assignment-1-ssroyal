package Adt;

/**
 * This is  interface for our Main Contact application
 * This Interface will define what are actual methods of our Application
 * The user can Perform The Following Operations
 * 1.Add a new Contact
 * 2. View All contacts
 * 3. Search a  Contact by First name
 * 4. Delete a contact
 */
public interface MyContactsAdt {

    /**
     * This method add a new Contact to the Contact List
     * This Method automatically will check the first name of the contact and will store Lexicographically in the List
     */
    void addContact();

    /**
     * This Method Will show all the contacts and the total number of the Contacts
     */
    void viewContacts();

    /**
     * This method will first print all the names of contact and allow you to delete a specified one
     */
    void deleteContact();

    /**
     * This method will allow you to search for a contact by its first name
     */
    void searchContact();
}