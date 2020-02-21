package Definition;

public class Person {
    private String FirstName;
    private String LastName;
    private String Email;
    private MyList<String> ContactNumbers;

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
        StringBuilder contacts = new StringBuilder();
        boolean a = false;
        for (int i = 0; i < ContactNumbers.size; i++) {
            if (i == 0) {
                contacts.append(ContactNumbers.getData(i));
            } else
                contacts.append(",").append(ContactNumbers.getData(i));
        }
        if (ContactNumbers.size == 1) {
            a = true;
        }
        return a ? "Contact: " + contacts : "Contacts:" + contacts;
    }

    @Override
    public String toString() {
        return "Firstname: " + getFirstName() + "\n" + "Lastname:" + getLastName() + "\n" + getContactNumbers() + "\n" + "Email:" + getEmail() + "\n" + "-------- * -------- * -------- * --------\n" +
                "-------- * -------- * -------- * --------";
    }


}
