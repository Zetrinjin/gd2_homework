package home.service;

import home.pojo.People;

public interface IService {

    People add(People people);

    People update(People people);

    People get(String id);
}
