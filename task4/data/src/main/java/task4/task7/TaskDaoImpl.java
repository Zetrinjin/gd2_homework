package task4.task7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;

public class TaskDaoImpl implements TaskDao{

    /*private final SessionFactory sessionFactory;*/

    private final Connection connection;

    public TaskDaoImpl(Connection connection) {
        this.connection = connection;
    }

   /* public TaskDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @Override
    public Expense getExpense(int num) {

        PreparedStatement ps = null;

        String sql ="select * from expenses where num = ?";

        Expense expense = new Expense();

        try {
            ps =connection.prepareStatement(sql);
            ps.setInt(1,num);

            ResultSet resultSet = ps.executeQuery();

            expense.setNum(resultSet.getInt("num"));
            expense.setPaydate(resultSet.getString("paydate"));
            expense.setReceiver(resultSet.getString("receiver"));
            expense.setValue(resultSet.getInt("value"));

            ps.executeUpdate();

            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expense;
    }



   /* @Override
    public Expense getExpense(int num) {
        Session session = null;
        Transaction transaction = null;
        Expense expense;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            expense = session.get(Expense.class, num);
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }

        return expense;
    }*/

    @Override
    public ArrayList<Expense> getExpenses() {
       ArrayList<Expense> arrayList = new ArrayList<>();

       String sql = "select * from expenses";

        Statement statement = null;

        try {
            statement =connection.createStatement();

            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()) {

                int idi = resultSet.getInt("num");
                String date = resultSet.getString("paydate");
                String recipient = resultSet.getString("receiver");
                int sum = resultSet.getInt("value");

                arrayList.add(new Expense(idi,date,recipient,sum));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayList;
    }

    @Override
    public int addExpense(Expense expense) {


        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO expenses (num, paydate, receiver, value) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement =connection.prepareStatement(sql);

            preparedStatement.setInt(1,expense.getNum());
            preparedStatement.setString(2,expense.getPaydate());
            preparedStatement.setString(3, expense.getReceiver());
            preparedStatement.setInt(4,expense.getValue());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
