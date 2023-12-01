package fight.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
@DiscriminatorValue("E")
public class Employee extends Person{

    @Column
    private String company;

    @Column
    private Double salary;

    public Employee(String company, Double salary) {
        this.company = company;
        this.salary = salary;
    }

    public Employee(String id, String firstName, String lastName, String company, Double salary) {
        super(id, firstName, lastName);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
