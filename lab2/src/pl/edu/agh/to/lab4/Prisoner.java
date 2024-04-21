package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner implements Suspect {
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;

    private final String name;

    private final String surname;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean isInJail() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public String display() {
        return name + " " + surname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }
}
