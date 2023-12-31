package prob;



public class Person {
   // private Integer id;

    private static Person person =new Person();
    private String name;

    private String surname;

    private Address address;

    public void init(){
        System.out.println("Initialize of Person 322");
    }

    public void destroy(){
        System.out.println("Destroy of Person 228");
    }

    public static Person createPerson(){
        return person;
    }

    public Person() {
    }

    public Person(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
