package Definition;

public class Person {
    private String FirstName = null;
    private String LastName = null;
    private String Email = null;
    private MyList<String> ContactNumbers = new MyList<String>();

    public Person(String firstName, String lastName, String email, MyList<String> contactNumbers) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNumbers = contactNumbers;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getContactNumbers() {
        String contacts = null;
        boolean a = false;
        for (int i = 0; i < ContactNumbers.size; i++) {
            if (i == 0) {
                contacts = contacts + ContactNumbers.getData(i);
            } else
                contacts = contacts + "," + ContactNumbers.getData(i);
        }
        if (ContactNumbers.size == 1) {
            a = true;
        }
        return a ? "Contact: " + contacts : "Contacts:" + contacts;
    }


}
