package by.it.model;

import java.io.Serializable;

public class PersonDto implements Serializable {

    private final String id;
    private final String firstName;

    private final String lastName;
    private final Integer dateOfBirth;

    public PersonDto(String id, String firstName, String lastName, int dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }
}
