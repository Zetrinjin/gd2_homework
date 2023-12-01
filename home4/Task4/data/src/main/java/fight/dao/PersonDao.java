package fight.dao;

import fight.pojo.Person;

public interface PersonDao {

    String saveNewPerson(Person person);

    Person getPersonById(String id);

}
