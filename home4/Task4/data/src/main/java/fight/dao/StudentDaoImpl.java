package fight.dao;

import fight.pojo.Person;
import fight.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class StudentDaoImpl implements StudentDao{

    private final SessionFactory sessionFactory;

    public StudentDaoImpl() {
        this.sessionFactory = null;

    }

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewStudent(Student student) {
        Session session = null;
        Transaction transaction = null;
        String savedId;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(student);
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
    public Student getStudentById(int id) {
        Session session = null;
        Transaction transaction = null;
        Student student;
        try {
            session= sessionFactory.openSession();
            transaction =session.beginTransaction();

            student = session.get(Student.class,id);

            Serializable identifier = session.getIdentifier(student);

            System.out.println(identifier);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

        return student;
    }
}
