package fight.join;

import javax.persistence.Column;

public class Merch extends Mall{
    @Column
    private String toyName;

    public Merch(String toyName) {
        this.toyName = toyName;
    }

    public Merch(String id, String name, Double salary, String toyName) {
        super(id, name, salary);
        this.toyName = toyName;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }
}
