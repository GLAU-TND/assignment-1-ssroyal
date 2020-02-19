package Definition;

import Adt.MyContactsAdt;

import java.util.Scanner;

public class MyContacts implements MyContactsAdt {
    Scanner sc = new Scanner(System.in);

    @Override
    public void addContact() {


    }

    @Override
    public void viewContacts() {

    }

    @Override
    public Object deletecontact() {
        return null;
    }

    @Override
    public void searchcontact() {

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
        contactNumbers.add(contactno);
        while (true) {
            System.out.print("Do You Want to add a new Contactnumber? (y/n) :");
            String a = sc.next();
            if (a.equals("y")) {
                System.out.print("ContactNumber: ");
                contactno = sc.next();
                contactNumbers.add(contactno);
            } else if (a.equals("n")) {
                break;
            } else {
                System.out.println("Please Enter a Vaild Input i.e., y(lowercase) for Yes or n(lowercase for NO)");
            }
        }
        return contactNumbers;
    }


}
