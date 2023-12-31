package home.dao;

import home.pojo.People;


import java.util.List;

public interface PeopleDao {

    void create(People people);

    void update(People people);

    People getPeople(String id);
}
