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

    public MyList<String> getContactNumbers() {
        return ContactNumbers;
    }
}
