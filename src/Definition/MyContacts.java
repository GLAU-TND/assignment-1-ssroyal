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


}
