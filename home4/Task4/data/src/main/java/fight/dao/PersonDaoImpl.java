package fight.dao;

import fight.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonDaoImpl implements PersonDao{

    private final SessionFactory sessionFactory;

    public PersonDaoImpl() {
        sessionFactory =null;
    }

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public String saveNewPerson(Person person) {
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

        return savedId;
    }

    @Override
    public Person getPersonById(String id) {

        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session= sessionFactory.openSession();
            transaction =session.beginTransaction();

            person = session.get(Person.class,id);

            Serializable identifier = session.getIdentifier(person);

            System.out.println(identifier);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

        return person;
    }
}
