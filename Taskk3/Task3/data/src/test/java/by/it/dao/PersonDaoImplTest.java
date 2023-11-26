package by.it.dao;

import by.it.PersonDataSourceTest;
import by.it.PersonSessionFactory;


import by.it.PersonSessionFactoryTest;
import by.it.pojo.Person;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class PersonDaoImplTest {

    PersonDao personDao;

    @org.junit.Before
    public void setUp() throws SQLException, ClassNotFoundException {
        personDao = new PersonDaoImpl(PersonSessionFactoryTest.getSessionFactory());
        Connection conn = PersonDataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
    }

    @org.junit.After
    public void tearDown() throws SQLException, ClassNotFoundException {
        personDao = null;
        Connection conn = PersonDataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
    }

    @Test
    public void saveNewPerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(
                null, "Yuli", "Slabko", 25
        );

        String savedId = personDao.saveNewPerson(person);

        assertNotNull(savedId);
        Connection conn = PersonDataSourceTest.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where FIRST_NAME='Yuli' and LAST_NAME='Slabko'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void readPersonById() throws SQLException, ClassNotFoundException {
        String testId = UUID.randomUUID().toString();
        Connection conn = PersonDataSourceTest.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'22',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");
        conn.close();

        Person person = personDao.readPersonById(testId);


        assertNotNull(person);
        assertEquals(testId, person.getId());
        assertEquals("Ivan", person.getFirstName());
        assertEquals("Petrov", person.getLastName());

    }

    @Test
    public void deletePersonById() throws SQLException, ClassNotFoundException {
        String testId = UUID.randomUUID().toString();
        Connection conn = PersonDataSourceTest.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'22',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");

        //When
        boolean result = personDao.deletePersonById(testId);

        //Then
        assertTrue(result);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where PERSON_ID='" + testId + "';"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(0, actualCount);
        conn.close();
    }
}