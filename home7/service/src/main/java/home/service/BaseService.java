package home.service;

import home.dao.PeopleDao;
import home.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaseService implements IService{

    @Autowired
    private PeopleDao peopleDao;

    @Override
    @Transactional()
    public People add(People people) {
        return null;
    }

    @Override
    public People update(People people) {
        return null;
    }

    @Override
    public People get(String id) {
        return null;
    }
}
