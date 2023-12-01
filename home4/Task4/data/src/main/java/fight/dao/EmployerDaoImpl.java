package fight.dao;

import fight.pojo.Employer;
import fight.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class EmployerDaoImpl implements EmployerDao{

    private final SessionFactory sessionFactory;

    public EmployerDaoImpl() {
        this.sessionFactory = null;
    }

    public EmployerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewEmployer(Employer employer) {
        Session session = null;
        Transaction transaction = null;
        String savedId;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(employer);
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
    public Employer getEmployerById(int id) {

        Session session = null;
        Transaction transaction = null;
        Employer employer;
        try {
            session= sessionFactory.openSession();
            transaction =session.beginTransaction();

            employer = session.get(Employer.class,id);

            Serializable identifier = session.getIdentifier(employer);

            System.out.println(identifier);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

        return employer;


    }
}
