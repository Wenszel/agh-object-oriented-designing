package pl.edu.agh.internetshop.data;

public class User {
    private final String firstname;
    private final String lastname;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }
}
