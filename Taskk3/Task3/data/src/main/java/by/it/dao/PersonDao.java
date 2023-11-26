package by.it.dao;

import by.it.model.PersonDto;
import by.it.pojo.Person;

public interface PersonDao {

    String saveNewPerson(Person person);

    Person readPersonById(String id);

    boolean deletePersonById(String id);

    void getPersonById(String id);

    void loadPersonById(String id);

}
