package Task4;



import task4.ExpensesDataSource;

import java.sql.*;

public class Task5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        int id =1;
        String paydate = "12.12.2009";
        String receiver = "magaz";
        int value = 20000;


        //language=MySQL
       // String insertQuery =  "insert into expenses (id,date,recipient,sum) values('"+idMain+"','"+dateMain+"','"+recipientMain+"','"+sumMain+"')";

        String str = "INSERT INTO expenses (num, paydate, receiver, value) VALUES (?, ?, ?, ?)";


        Connection statement =  ExpensesDataSource.getConnection();

       // Connection con = (Connection) statement;

        PreparedStatement ps= statement.prepareStatement(str);


        ps.setInt(1,id);
        ps.setString(2,paydate);
        ps.setString(3,receiver);
        ps.setInt(4,value);

        ps.executeUpdate();

        String selectQuery = "select * from expenses";

        ResultSet resultSet = ps.executeQuery(selectQuery);
        while(resultSet.next()) {
            int idi = resultSet.getInt("num");
            String date = resultSet.getString("paydate");
            String recipient = resultSet.getString("receiver");
            int sum = resultSet.getInt("value");
            System.out.println("Id:" + idi + " " + "Date:" + date + " " + "Recipient:" + recipient + " " + "Sum:" + sum);

        }
        resultSet.close();
        statement.close();

    }

}
