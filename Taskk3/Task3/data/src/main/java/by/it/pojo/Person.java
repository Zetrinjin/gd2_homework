package by.it.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "T_PERSON")
public class Person implements Serializable {

    @Id
    @GenericGenerator(strategy = "uuid", name = "person_uuid")
    @GeneratedValue(generator = "person_uuid")
    @Column(name = "PERSON_ID")
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private int dateOfBirth;

    public Person() {
    }

    public Person(String id, String firstName, String lastName, int dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(id, person.id)) return false;
        if (!Objects.equals(firstName, person.firstName)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        return Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        //result = 31 * result + (dateOfBirth != 0 ? dateOfBirth.hashCode() : 0);
        return result;
    }
}
