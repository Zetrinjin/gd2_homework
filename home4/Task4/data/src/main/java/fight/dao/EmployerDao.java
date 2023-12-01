package fight.dao;

import fight.pojo.Employer;

public interface EmployerDao {

    String saveNewEmployer(Employer employer);

    Employer getEmployerById(int id);
}
