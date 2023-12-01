package fight.dao;

import fight.DataSourceTest;
import fight.SessionFactoryTest;
import fight.pojo.Employer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmployerDaoImplTest {

    EmployerDao employerDao;
    Connection conn;
    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {

        employerDao = new EmployerDaoImpl(SessionFactoryTest.getSessionFactory());
        conn = DataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_EMPLOYER;");
    }

    @AfterEach
    void tearDown() throws SQLException {
        employerDao = null;
        conn.createStatement().executeUpdate("DELETE FROM T_EMPLOYER;");
        conn.close();
    }

    @Test
    void saveNewEmployer() throws SQLException {
        Employer employer = new Employer(1, "dane", "skip", null);

        employerDao.saveNewEmployer(employer);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from T_EMPLOYER");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    void getEmployerById() throws SQLException {
        int testId = 23;

        conn.createStatement().executeUpdate(
                "insert into T_EMPLOYER values ('" + testId + "', dane , 'skip')");

        Employer employer = employerDao.getEmployerById(testId);

        assertNotNull(employer);
    }
}