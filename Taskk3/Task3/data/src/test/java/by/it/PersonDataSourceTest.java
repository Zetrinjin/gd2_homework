package by.it;

import junit.framework.TestCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonDataSourceTest extends PersonDataSource {

    private static PersonDataSourceTest dataSource;

    public PersonDataSourceTest() throws ClassNotFoundException {
        super();
    }

    @Override
    protected Connection getPersonConnection()  throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/t_person_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new PersonDataSourceTest();
        }
        return dataSource.getPersonConnection();
    }
}