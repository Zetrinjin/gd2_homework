package fight.perClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEVELOPER")
public class Developer extends Game{

    @Column
    private String devName;

    @Column
    private Integer salary;

    public Developer(String devName, Integer salary) {
        this.devName = devName;
        this.salary = salary;
    }

    public Developer(String id, String gameName, String genre, Integer coast, String devName, Integer salary) {
        super(id, gameName, genre, coast);
        this.devName = devName;
        this.salary = salary;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
