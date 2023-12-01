package fight.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_EMPLOYER")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "EMPLOYER_ID")
    private int id;
    @Column(name = "EMPLOYER_FIRST_NAME")
    private String firstName;
    @Column(name = "EMPLOYER_LAST_NAME")
    private String lastName;
    @Embedded
    private Address address;

    public Employer() {
    }

    public Employer(int id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(id, employer.id) && Objects.equals(firstName, employer.firstName) && Objects.equals(lastName, employer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
