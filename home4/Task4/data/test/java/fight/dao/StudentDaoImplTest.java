package fight.dao;

import fight.DataSourceTest;
import fight.SessionFactoryTest;
import fight.pojo.Employer;
import fight.pojo.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoImplTest {

    StudentDao studentDao;
    Connection conn;
    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        studentDao = new StudentDaoImpl(SessionFactoryTest.getSessionFactory());
        conn = DataSourceTest.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_STUDENT;");
    }

    @AfterEach
    void tearDown() throws SQLException {
        studentDao = null;
        conn.createStatement().executeUpdate("DELETE FROM T_STUDENT;");
        conn.close();
    }

    @Test
    void saveNewStudent() throws SQLException {

        Student student = new Student(1,"mike","niklson",8, null);


        studentDao.saveNewStudent(student);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from T_STUDENT");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    void getStudentById() throws SQLException {
        int testId = 1;

        conn.createStatement().executeUpdate(
                "insert into T_STUDENT values ('" + testId + "', mike , 'niklson','8')");

        Student student = studentDao.getStudentById(testId);

        assertNotNull(student);
    }
}