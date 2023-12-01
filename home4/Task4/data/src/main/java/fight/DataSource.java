package fight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static DataSource dataSource;
    protected DataSource() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getPersonConnection()  throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task_4",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource.getPersonConnection();
    }
}
