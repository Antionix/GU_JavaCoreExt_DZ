package lesson03b;

import java.util.ArrayList;

import static java.lang.String.format;

public class User {
    private String firstName, secondName;
    private ArrayList<String> phoneNumbers;

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        phoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String toString() {
        return format("%s %s: ", firstName, secondName) + phoneNumbers;
    }
}
