package task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExpensesDataSource {
    private static ExpensesDataSource dataSource;
    private ExpensesDataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

    }


    private Connection getExpensesDataSource() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/expenses",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new ExpensesDataSource();
        }
        return dataSource.getExpensesDataSource();
    }

}
