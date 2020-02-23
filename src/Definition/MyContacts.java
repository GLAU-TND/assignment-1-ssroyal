package Definition;

import Adt.MyContactsAdt;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class is the Main Definition class of the application
 * it define and implements various Method like Add,Delete,Search and View Contacts
 */
public class MyContacts implements MyContactsAdt {
    Scanner sc = new Scanner(System.in);

    /**
     * A List of Person Type  to store  Contacts
     */
    MyList<Person> myContactsBook = new MyList<>();
    /**
     * A List of String Type to store contactsNumbers of a individual person while adding a new Contact
     */
    MyList<String> contactNumbers = new MyList<>();

    /**
     * The addContact method add a new Contact to MyContactBook
     * It itself create a node of person type and store all the information of the contact passed by user and stores in the Contact List
     * It compare the FirstName of the contact and stores accordingly arranged in Dictionary Order
     */
    @Override
    public void addContact() {
        System.out.println("You have chosen to add a new contact:");
        /*
          call the getFirstName() method to store the FirstName of the Contact in the firstName Field
         */
        String firstName = getFirstName();
        /*
        call the getLastName() method to store the FirstName of the Contact in the lastName Field
         */
        String lastName = getLastName();
        /*
        call the getContactNumbers() method to store the ContactNumbers of the Contact in the contactNumbers List type Field
         */
        contactNumbers = getContactNumbers();
        /*
        call the getEmail() method to store the Email of the Contact in the Email type Field
         */
        String Email = getEmail();
        /*
        create a new Object of Person class with the values stored above by passing values in the constructor of Person
         */
        Person newContact = new Person(firstName, lastName, Email, contactNumbers);
        /*
        Compare the first name of the person by calling compareFirstName() method and storing the returned index in the index Variable
         */
        int index = compareFirstName(firstName);
        /*
        Adding the new Contact at the index location found after comparing the firstName
         */
        myContactsBook.add(newContact, index);
        /*
          Showing confirmation message
         */
        System.out.println("Contact Added Successfully");
        System.out.println();
        System.out.println();

    }

    /**
     * This method will simply print the Contacts in the same order stored in the list
     *  it will print the names in the required format by the client
     */
    @Override
    public void viewContacts() {
        /*
        Some design format required
         */
        System.out.println("---Here are all your contacts---\n" +
                "-------- * -------- * -------- * --------");
        /*
         Traversing myContactBook and printing all the contact one by one
        */
        for (int i = 0; i < myContactsBook.size; i++) {
            Person response = myContactsBook.getData(i);
            System.out.println(response);
        }
        /*
        Printing total no of contacts by the size of the MyContactBook

         */
        System.out.println("Total Contacts: " + myContactsBook.size);

    }

    /**
     * This method will print the name of all contact with a number(1 more than the index at which the contact is stored in the list)
     * assigned with it and allow to delete the contact by pressing the number in front of it
     */
    @Override
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        /*
        Call the printNames() method to print all names  of the contact
         */
        printNames();
        /*
        message print
         */
        System.out.print("Press the number against the contact to delete it: ");
        /*
        A try catch block to handle the any other input except integer
         */
        try {
            /*
            getting the input of the user in a int type index field
             */
            int index = sc.nextInt();
            /*
            Checking if the input is 0 or more than size if yes printing Invalid Input message
             */
            if (index > myContactsBook.size || index == 0) {
                System.out.println("Invalid Input");
            } else {
            /*
                getting the data of the contact by getData() method and passing 1 less than the input passed by user to get the correct index
                and storing in a Person type variable
             */
                Person p = myContactsBook.getData(index - 1);
                /*
                Get the FirstName and LastName of the contact for showing message after deletion
                 */
                String name = p.getFirstName() + " " + p.getLastName();
                /*
                deleting that contact by calling remove() method with index-1
                 */
                myContactsBook.remove(index - 1);
                /*
                printing confirmation message
                 */
                System.out.println(name + "'s Contact has been removed Successfully");
            }
        } catch (InputMismatchException E) {
            /*
            handling the exception if generated
             */
            System.out.println("Integer input expected ");
        }

    }

    /**
     * This Method allows you to search contact by their FirstName
     */
    @Override
    public void searchContact() {
        /*
        Taking input of user and some initial declaration
         */
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("You could search for a contact from their first names:");
        String name = sc.next();
        /*
        removing space from the input given by the user if present any
         */
        name = name.trim();
        /*
        calling the matchFirst() method and storing the list of returned indexes in a indexesList field
         */
        MyList<Integer> indexesList = matchFirst(name);
        /*
        initialization of a boolean variable for ternary operation
         */
        boolean a = false;
        /*
        get the size of indexesList field in the size variable
         */
        size = indexesList.size;
        if (size > 1) {
            /*;
            if only 1 match found i.e, the size of the list is 1 then make a =true
             */
            a = true;
        }
        /*
        Check if No result found
         */
        if (size == 0) {
            System.out.println("NO RESULTS FOUND");
        } else
        /*
        Print the number of match(es) Found
         */

            System.out.println(a ? size + " Matches found!" : size + " Match found!");
        /*
        Print every matched contact by the indexes in the indexesList
         */
        for (int i = 0; i < size; i++) {
            int index = indexesList.getData(i);
            System.out.println(myContactsBook.getData(index));
        }
    }

    /**
     * This is a helper method for deleteContact() method and will print the names with the required number in front of it
     */
    private void printNames() {
        /*
        Traversing the list and getting first  and last name of the every contact 1 by 1
         */
        System.out.println("Here are your all contacts:");
        for (int i = 0; i < myContactsBook.size; i++) {
            Person temp = myContactsBook.getData(i);
            /*
            Printing the names
             */
            System.out.println((i + 1) + "." + temp.getFirstName() + " " + temp.getLastName());
        }
    }

    /** This is a helper method for searchContact() method it match the firstName passed with every contact present in the list
     *  and return a list of such indexes where the name is matched
     *  @param firstName The name that is to be searched
     *  @return A List of all the indexes at which the name name is matched
     */
    private MyList<Integer> matchFirst(String firstName) {
        /*
        Creating a new List to store the  matched indexes
         */
        MyList<Integer> indexes = new MyList<>();
        /*
        if myContactBook is empty do nothing
         */
        if (myContactsBook.size == 0) {
            System.out.println("There are No contacts saved please add some");
        }
        /*
        Traversing myContactBook to match with the firstName
         */
        else {
            for (int i = 0; i < myContactsBook.size; i++) {
                /*
                First get the contact in a Person type variable
                 */
                Person temp = myContactsBook.getData(i);
                /*
                Then get the FirstName of that contact
                 */
                String name = temp.getFirstName();
                /*
                Converting both the passed name and ContactName to lowercase to achieve case Insensitivity
                 */
                name = name.toLowerCase();
                firstName = firstName.toLowerCase();
                /*
                if both the names found same add the index to the list
                 */

                if (name.compareTo(firstName) == 0) {
                    indexes.add(i);
                }

            }
        }
        /*
        return the list
         */
        return indexes;
    }


    /**
     * This is a helper method for addContact() method
     * it helps in comparing the firstName of a contact and return a single index
     * of the contact that is found Lexicographically  equal or greater
     *
     * @param FirstName the name to be compared
     * @return index of the contact equal or greater Lexicographically
     */
    private int compareFirstName(String FirstName) {
        int index = 0;
        /*
        If there is no contact do nothing and return the first index as no sorting is required
         */
        if (myContactsBook.size == 0) {
            return index;
        }
        /*
            Traversing myContactBook to compare everyName
         */
        else {
            for (int i = 0; i < myContactsBook.size; i++) {
                 /*
                First get the contact in a Person type variable
                 */
                Person temp = myContactsBook.getData(i);
                /*
                Then get the FirstName of that contact
                 */
                String name = temp.getFirstName();
                 /*
                Converting both the passed name and ContactName to lowercase to achieve case Insensitivity
                 */
                name = name.toLowerCase();
                FirstName = FirstName.toLowerCase();
                /*
                If passed name is smaller increase the value of index by 1
                 */
                if (name.compareTo(FirstName) < 0) {
                    index++;
                }
                /*
                if the name found equal or greater break the loop and return the index
                 */
                else if (name.compareTo(FirstName) == 0) {
                    break;
                } else {
                    break;
                }

            }

        }
        return index;
    }

    /** A helper method of addContact() method
     * use to input firstName of the Contact
     *
     * @return FirstName of the new contact
     */
    private String getFirstName() {
        System.out.println("Please Enter the name of the Person");
        System.out.print("FirstName: ");
        return sc.next();

    }

    /** A helper method of addContact() method
     * use to input LastName of the Contact
     *
     * @return LastName of the new contact
     */

    private String getLastName() {
        System.out.print("LastName: ");
        return sc.next();

    }

    /** A helper method of addContact() method
     * use to input contactNumbers of the Contact
     * Ensures that there must be AtLeast 1 contact for every individual contact
     *
     * @return a list Containing ContactsNumbers of the new contact
     */

    private MyList<String> getContactNumbers() {
        /*
        Declaration of a new list to store ContactNumbers of the new Contact
         */
        MyList<String> contactNumbers = new MyList<>();
        /*
        A String Variable to store an individual Contact of the new Contact
         */
        String contactNo;
        while (true) {
            System.out.print("ContactNumber: ");
            contactNo = sc.next();
             /*
             If entered number is valid add contactNo to the list
              */
            if (Pattern.matches("[0-9]+", contactNo)) {
                contactNumbers.add(contactNo);
                break;
            }
            /*
            if entered number is not valid i.e, contains characters except digits

             */
            else {
                System.out.println("Invalid PhoneNumber");
            }
        }
        while (true) {
            /*
            Asking again for a contactNumber if user  want to add
             */
            System.out.print("Do You Want to add a new ContactNumber? (y/n) :");
            String a = sc.next();
            a = a.toLowerCase();
            /*
            Checking if the entered input is a single character or not
            if not printing Invalid input message
             */
            char at = a.charAt(0);
            if (a.length() > 1) {
                System.out.println("Please Enter a Valid Input i.e., y for Yes or n for No");
                continue;
            }
            /*
            if entered input means yes allow to add a new contact and add that contact also to the list of ContactNumbers
             */

            if (at == 'y') {
                System.out.print("ContactNumber: ");
                contactNo = sc.next();
                /*
                checking a valid contact number
                 */
                if (Pattern.matches("[0-9]+", contactNo)) {

                    contactNumbers.add(contactNo);
                } else {
                    System.out.println("Invalid PhoneNumber");
                }
            }
            /*
            if the entered input means no end the loop and return the contactNumbers list
             */
            else if (at == 'n') {
                break;
            }
            /*
            If there is some invalid input other than 'y' or 'n' then print Invalid input message
             */
            else {
                System.out.println("Please Enter a Valid Input i.e., y for Yes or n for No");
            }
        }

        return contactNumbers;


    }

    /**
     * A helper method of addContact() method
     * use to input email of the Contact
     * gives the choice if user want to add a email or not
     * there can only be a single email for a individual contact
     * if user dont want to add a email return null
     *
     * @return email of the new contact
     */


    private String getEmail() {
        String Email = null;
        System.out.print("Do You Want to add an email ? (y/n) :");
        while (true) {
            String a = sc.next();
            a = a.toLowerCase();
            /*
            Checking if the entered input is a single character or not
            if not printing Invalid input message
             */
            char at = a.charAt(0);
            if (a.length() > 1) {
                System.out.println("Please Enter a Valid Input i.e., y for Yes or n No");
                continue;
            }
            /*
            if entered input means yes allow to add a new email
             */
            if (at == 'y') {
                System.out.print("Email Address: ");
                Email = sc.next();
                break;
            }
             /*
            if the entered input means no end the loop
             */
            else if (at == 'n') {
                break;
            }
             /*
            If there is some invalid input other than 'y' or 'n' then print Invalid input message
             */
            else {
                System.out.println("Please Enter a Valid Input i.e., y for Yes or n for No");
            }
        }
        return Email;
    }
}