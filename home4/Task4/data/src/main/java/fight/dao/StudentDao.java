package fight.dao;

import fight.pojo.Student;

public interface StudentDao {

    String saveNewStudent(Student student);

    Student getStudentById(int id);
}
