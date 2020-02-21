package definition;

import adt.MyContactsAdt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyContacts implements MyContactsAdt {
    MyList<Person> myContactsBook = new MyList<>();
    MyList<String> contactNumbers = new MyList<>();

    @Override
    public void addContact() {
        System.out.println("You have chosen to add a new contact:");
        String firstName = GetFirstName();
        String lastName = GetLastName();
        contactNumbers = GetContactNumbers();
        String Email = GetEmail();
        Person newContact;
        newContact = new Person(firstName, lastName, Email, contactNumbers);
        int index = compareFirstName(firstName);
        myContactsBook.add(newContact, index);
        System.out.println("Contact Added SucessFully");
        System.out.println();
        System.out.println();

    }
    @Override
    public void viewContacts() {
        System.out.println("---Here are all your contacts---\n" +
                "-------- * -------- * -------- * --------");

        for (int i = 0; i < myContactsBook.size; i++) {
            Person response = myContactsBook.getData(i);
            System.out.println(response);
        }
        System.out.println("Total Contacts: " + myContactsBook.size);

    }

    @Override
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        printNames();
        System.out.print("Press the number against the contact to delete it: ");
        try {
            int index = sc.nextInt();
            if (index > myContactsBook.size) {
                System.out.println("Invaild Input");
            } else {
                Person p = myContactsBook.getData(index - 1);
                String name = p.getFirstName() + p.getLastName();
                myContactsBook.remove(index - 1);
                System.out.println(name + "'s Contact has been removed Successfully");
            }
            sc.close();
        } catch (InputMismatchException E) {
            System.out.println("Integer input expected ");
        }


    }

    @Override
    public void searchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You could search for a contact from their first names:");
        String name = sc.next();
        MyList<Integer> lists = matchFirst(name);
        int size = lists.size;
        boolean a = false;
        if (size > 1) {
            a = true;
        }
        System.out.println(a ? size + " Matches found!" : " Match found!");
        for (int i = 0; i < size; i++) {
            int index = lists.getData(i);
            System.out.println(myContactsBook.getData(index));
        }
        sc.close();
    }

    private void printNames() {
        System.out.println("Here are your all contacts:");
        for (int i = 0; i < myContactsBook.size; i++) {
            Person temp = myContactsBook.getData(i);
            System.out.println((i + 1) + "." + temp.getFirstName() + " " + temp.getLastName());
        }
    }

    private MyList<Integer> matchFirst(String Firstname) {
        MyList<Integer> indexes = new MyList<>();
        if (myContactsBook.size == 0) {
            System.out.println("There are no contacts added please add some");
        } else {
            for (int i = 0; i < myContactsBook.size; i++) {
                Person temp = myContactsBook.getData(i);
                String name = temp.getFirstName();
                name = name.toLowerCase();
                Firstname = Firstname.toLowerCase();

                if (name.compareTo(Firstname) == 0) {
                    indexes.add(i);
                }

            }
        }
        return indexes;
    }


    private int compareFirstName(String Firstname) {
        int index = 0;
        if (myContactsBook.size == 0) {
        } else {
            for (int i = 0; i < myContactsBook.size; i++) {
                Person temp = myContactsBook.getData(i);
                String name = temp.getFirstName();
                name = name.toLowerCase();
                Firstname = Firstname.toLowerCase();
                if (name.compareTo(Firstname) < 0) {
                    index++;
                } else if (name.compareTo(Firstname) == 0) {
                    return index;

                } else {
                    break;
                }

            }

        }
        return index;
    }

    private String GetFirstName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the name of the Person");
        System.out.print("FirstName: ");
        String firstname = sc.next();
        sc.close();
        return firstname;

    }

    private String GetLastName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lastname: ");
        String lastname = sc.next();
        sc.close();
        return lastname;

    }

    private MyList<String> GetContactNumbers() {
        Scanner sc = new Scanner(System.in);
        MyList<String> contactNumbers = new MyList<>();
        System.out.print("ContactNumber: ");
        String contactno = sc.next();
        contactNumbers.add(contactno);
        while (true) {
            System.out.print("Do You Want to add a new Contactnumber? (y/n) :");
            String a = sc.next();
            char at = a.charAt(0);
            if (a.length() > 1) {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
                continue;
            }
            if (at == 'y') {
                System.out.print("ContactNumber: ");
                contactno = sc.next();
                contactNumbers.add(contactno);
            } else if (at == 'n') {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }
        sc.close();
        return contactNumbers;
    }

    private String GetEmail() {
        Scanner sc = new Scanner(System.in);
        String Email = null;
        while (true) {

            System.out.print("Do You Want to add an email ? (y/n) :");
            String a = sc.next();
            char at = a.charAt(0);
            if (a.length() > 1) {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
                continue;
            }
            if (at == 'y') {
                System.out.print("Email Address: ");
                Email = sc.next();
                break;
            } else if (at == 'n') {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }
        sc.close();
        return Email;

    }

}
