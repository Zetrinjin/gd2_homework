package fight.dao;

import fight.DataSourceTest;
import fight.SessionFactoryTest;
import fight.pojo.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class PersonDaoImplTest {

    PersonDao personDao;
    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        personDao = new PersonDaoImpl(SessionFactoryTest.getSessionFactory());
        Connection conn = DataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
    }

    @AfterEach
    void tearDown() throws SQLException, ClassNotFoundException {
        personDao = null;
        Connection conn = DataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
        conn.close();
    }

    @Test
    void saveNewPerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(
                null, "Yuli", "Slabko", 25
        );

        String savedId = personDao.saveNewPerson(person);

        assertNotNull(savedId);
        Connection conn = DataSourceTest.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON "
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);

    }

    @Test
    void getPersonById() throws SQLException {

        String testId = "123uuid12";

        Connection conn= null;

        conn.createStatement().executeUpdate(
                "insert into T_PERSON (id, firstName, lastName, age)" +
                        " values ('"+ testId +"', 'Yuli','Slabko','25')");

        Person person =personDao.getPersonById(testId);

        assertNotNull(person);

    }
}