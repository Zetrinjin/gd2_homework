package Task4;

import task4.ExpensesDataSource;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task4 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        int idMain = Integer.parseInt(args[0]);
        String dateMain = args[1];
        String recipientMain = args[2];
        int sumMain = Integer.parseInt(args[3]);

        //language=MySQL
        String insertQuery =  "insert into expenses (id,date,recipient,sum) values('"+idMain+"','"+dateMain+"','"+recipientMain+"','"+sumMain+"')";


        Statement statement =  ExpensesDataSource.getConnection().createStatement();
        statement.execute(insertQuery);

        String selectQery = "select * from expenses";
        ResultSet resultSet = statement.executeQuery(selectQery);
        while(resultSet.next()) {
            int id = resultSet.getInt("num");
            String date = resultSet.getString("paydate");
            String recipient = resultSet.getString("receiver");
            int sum = resultSet.getInt("value");
            System.out.println("Id:" + id + " " + "Date:" + date + " " + "Recipient:" + recipient + " " + "Sum:" + sum);

        }
        resultSet.close();
        statement.close();

    }

}
