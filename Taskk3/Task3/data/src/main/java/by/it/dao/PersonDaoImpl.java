package by.it.dao;

import by.it.model.PersonDto;
import by.it.pojo.Person;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

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
       /* Person person = new Person(
                personDto.getId(),
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getDateOfBirth()
        );*/
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
    public Person readPersonById(String id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            person = session.get(Person.class, id);

            transaction.commit();

        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return person;

    }

    @Override
    public boolean deletePersonById(String id) {

        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id); //Some work
            if (person == null) {
                return false;
            }
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return true;

    }

    @Override
    public void getPersonById(String id) {

        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);
            //вызываем get методы
            System.out.println(person.getFirstName());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

    }

    @Override
    public void loadPersonById(String id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.load(Person.class, id);
            //вызываем get методы
            System.out.println(person.getFirstName());

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

    }
}
