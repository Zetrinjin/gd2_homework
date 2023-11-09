package Task4;


import task4.ExpensesDataSource;

import java.sql.*;

public class Task6 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       /* Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/expenses",
                "root", "root");*/

       Statement st = ExpensesDataSource.getConnection().createStatement();

        String selectQuery = "select * from expenses";

        ResultSet resultSet = st.executeQuery(selectQuery);
        while(resultSet.next()) {
            int idi = resultSet.getInt("num");
            String date = resultSet.getString("paydate");
            String recipient = resultSet.getString("receiver");
            int sum = resultSet.getInt("value");
            System.out.println("Id:" + idi + " " + "Date:" + date + " " + "Recipient:" + recipient + " " + "Sum:" + sum);

        }
        System.out.println(" ");

        selectQuery= "select receiver,value from expenses";
        resultSet=st.executeQuery(selectQuery);
        //не будет выводить так как только два значения а не все
       /* while(resultSet.next()) {
            int idi = resultSet.getInt("num");
            String date = resultSet.getString("paydate");
            String recipient = resultSet.getString("receiver");
            int sum = resultSet.getInt("value");
            System.out.println("Id:" + idi + " " + "Date:" + date + " " + "Recipient:" + recipient + " " + "Sum:" + sum);

        }*/
        while(resultSet.next()) {

            String recipient = resultSet.getString("receiver");
            int sum = resultSet.getInt("value");
            System.out.println("Recipient:" + recipient + " " + "Sum:" + sum);
        }

        System.out.println(" ");

        selectQuery= "select SUM(value) from expenses where paydate=(select paydate from expenses group by paydate " +
                "order by max(value) desc limit 0,1 ) ";
        resultSet=st.executeQuery(selectQuery);
        while(resultSet.next()) {

            //String date = resultSet.getString("paydate");

            int sum = resultSet.getInt(1);
            System.out.println( "Sum:" + sum);
        }

        System.out.println(" ");

        selectQuery= "select max(value) from expenses where paydate = (\n" +
                "    select  paydate\n" +
                "    from expenses\n" +
                "    group by paydate\n" +
                "    order by sum(value) desc\n" +
                "    limit 0, 1\n" +
                ")";
        resultSet=st.executeQuery(selectQuery);
        while(resultSet.next()) {

            //String date = resultSet.getString("paydate");

            int sum = resultSet.getInt(1);
            System.out.println( "Sum:" + sum);
        }





        resultSet.close();
        st.close();

    }

}
