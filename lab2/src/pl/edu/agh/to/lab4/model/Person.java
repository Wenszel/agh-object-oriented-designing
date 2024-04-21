package pl.edu.agh.to.lab4.model;

public class Person implements Suspect{
    private String firstname;

    private String lastname;

    private int age;

    public Person(String firstname, String lastname, int age) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public String firstname() {
        return firstname;
    }

    public String middlename() {
        return lastname;
    }

    @Override
    public String display() {
        return firstname + " " + lastname;
    }

    @Override
    public String getName() {
        return firstname;
    }

    @Override
    public String getSurname() {
        return lastname;
    }
}
