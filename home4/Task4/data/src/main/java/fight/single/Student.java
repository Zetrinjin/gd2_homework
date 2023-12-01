package fight.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUD")
@DiscriminatorValue("S")
public class Student extends Person{

    @Column
    private String faculty;
    @Column
    private Double mark;

    public Student(String faculty, Double mark) {
        this.faculty = faculty;
        this.mark = mark;
    }

    public Student(String id, String firstName, String lastName, String faculty, Double mark) {
        super(id, firstName, lastName);
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
