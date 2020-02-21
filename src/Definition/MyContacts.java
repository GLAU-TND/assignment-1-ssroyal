package Definition;

import Adt.MyContactsAdt;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyContacts implements MyContactsAdt {
    Scanner sc = new Scanner(System.in);

    MyList<Person> MyContactsBook = new MyList<>();
    MyList<String> contactNumbers = new MyList<>();

    @Override
    public void addContact() {
        System.out.println("You have chosen to add a new contact:");
        String firstname = GetFirstName();
        String lastname = GetLastname();
        contactNumbers = GetContactnumbers();
        String Email = GetEmail();
        Person newContact;
        newContact = new Person(firstname, lastname, Email, contactNumbers);
        int index = compareFirstname(firstname);
        MyContactsBook.add(newContact, index);
        System.out.println("Contact Added SucessFully");
        System.out.println();
        System.out.println();

    }

    @Override
    public void viewContacts() {
        System.out.println("---Here are all your contacts---\n" +
                "-------- * -------- * -------- * --------");

        for (int i = 0; i < MyContactsBook.size; i++) {
            Person response = MyContactsBook.getData(i);
            System.out.println(response);
        }
        System.out.println("Total Contacts: " + MyContactsBook.size);

    }

    @Override
    public void deletecontact() {
        Scanner sc = new Scanner(System.in);
        printnames();
        System.out.print("Press the number against the contact to delete it: ");
        try {
            int index = sc.nextInt();
            if (index > MyContactsBook.size || index == 0) {
                System.out.println("Invaild Input");
            } else {
                Person p = MyContactsBook.getData(index - 1);
                String name = p.getFirstName() + p.getLastName();
                MyContactsBook.remove(index - 1);
                System.out.println(name + "'s Contact has been removed Successfully");
            }
        } catch (InputMismatchException E) {
            System.out.println("Integer input expected ");
        }

    }

    @Override
    public void searchcontact() {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("You could search for a contact from their first names:");
        String name = sc.next();
        MyList<Integer> lists = matchfirst(name);
        boolean a = false;
        size = lists.size;
        if (size > 1) {
            a = true;
        }

        System.out.println(a ? size + " Matches found!" : size + " Match found!");
        for (int i = 0; i < size; i++) {
            int index = lists.getData(i);
            System.out.println(MyContactsBook.getData(index));
        }
    }

    private void printnames() {
        System.out.println("Here are your all contacts:");
        for (int i = 0; i < MyContactsBook.size; i++) {
            Person temp = MyContactsBook.getData(i);
            System.out.println((i + 1) + "." + temp.getFirstName() + " " + temp.getLastName());
        }
    }

    private MyList<Integer> matchfirst(String Firstname) {
        MyList<Integer> indexes = new MyList<>();
        if (MyContactsBook.size == 0) {
        } else {
            for (int i = 0; i < MyContactsBook.size; i++) {
                Person temp = MyContactsBook.getData(i);
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


    private int compareFirstname(String Firstname) {
        int index = 0;
        if (MyContactsBook.size == 0) {
        } else {
            for (int i = 0; i < MyContactsBook.size; i++) {
                Person temp = MyContactsBook.getData(i);
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
        System.out.println("Please Enter the name of the Person");
        System.out.print("FirstName: ");
        String firstname = sc.next();
        return firstname;

    }

    private String GetLastname() {
        System.out.print("Lastname: ");
        String lastname = sc.next();
        return lastname;

    }

    private MyList<String> GetContactnumbers() {
        MyList<String> contactNumbers = new MyList<String>();
        System.out.print("ContactNumber: ");
        String contactno = sc.next();
        while (true) {
            if (Pattern.matches("[0-9]+", contactno)) {
                contactNumbers.add(contactno);
                break;
            } else {
                System.out.println("Invaild option");
                break;
            }
        }
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
                if (Pattern.matches("[0-9]+", contactno)) {

                    contactNumbers.add(contactno);
                } else {
                    System.out.println("Invaild option");
                }
            } else if (at == 'n') {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }

        return contactNumbers;


    }

    private String GetEmail() {
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
            } else if (at == 'n') {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }
        return Email;
    }


}