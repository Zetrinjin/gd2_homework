package fight.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int id;

    @Column(name = "STUDENT_FIRST_NAME")
    private String firstName;

    @Column(name = "STUDENT_LAST_NAME")
    private String lastName;

    @Column(name = "STUDENT_MARK")
    private int mark;

    @Embedded
    private Address address;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, int mark, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mark == student.mark && Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mark);
    }
}
