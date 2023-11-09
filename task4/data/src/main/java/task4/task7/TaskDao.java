package task4.task7;

import java.util.ArrayList;

public interface TaskDao {

    Expense getExpense(int num);

    ArrayList<Expense> getExpenses();

    int addExpense(Expense expense);

}
