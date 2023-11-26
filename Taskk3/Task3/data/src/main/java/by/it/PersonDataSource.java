package by.it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonDataSource {
    private static PersonDataSource dataSource;
    protected PersonDataSource() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getPersonConnection()  throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/t_person",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new PersonDataSource();
        }
        return dataSource.getPersonConnection();
    }
}
