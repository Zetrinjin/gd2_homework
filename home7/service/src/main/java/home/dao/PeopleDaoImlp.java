package home.dao;

import home.pojo.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class PeopleDaoImlp implements PeopleDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public PeopleDaoImlp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public void create(People people) {
        Session session =sessionFactory.getCurrentSession();
        session.save(people);
    }

    public void update(People people) {
        Session session =sessionFactory.getCurrentSession();
        session.update(people);

    }

    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = true,
            timeout = 60)
    public People getPeople(String id) {
        Session session =sessionFactory.getCurrentSession();
        return session.get(People.class, id);
    }
}
