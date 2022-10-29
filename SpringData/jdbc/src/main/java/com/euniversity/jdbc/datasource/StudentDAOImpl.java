package com.euniversity.jdbc.datasource;

import com.euniversity.jdbc.entity.Student;
import com.euniversity.jdbc.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;
    
    private final String SQL_FIND_STUDENT = "select * from student where id = ?";
    private final String SQL_DELETE_STUDENT = "delete from student where id = ?";
    private final String SQL_GET_ALL = "select * from student";
    private final String SQL_INSERT_STUDENT = "insert into student(id, firstName, lastName, age, department) values(?,?,?,?,?)";
    
    private final String SQL_UPADTE_STUDENT = "update student set firstName = ? where id = ?";
    
    @Autowired
    public StudentDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public Student getStudentById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_STUDENT, new StudentMapper(), id);
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper());
    }

    @Override
    public boolean deleteStudent(Long id) {
        return jdbcTemplate.update(SQL_DELETE_STUDENT, id) > 0;
    }

    @Override
    public boolean createStudent(Student student) {
        return jdbcTemplate.update(SQL_INSERT_STUDENT, student.getId(), student.getFirstName(), student.getLastName(),
                student.getAge(), student.getDepartment()) > 0;
    }

    @Override
    public void createStudentBulk(List<Student> students) {
        for (Student student : students) {
            jdbcTemplate.update(SQL_INSERT_STUDENT, student.getId(), student.getFirstName(), student.getLastName(),
                    student.getAge(), student.getDepartment());
        }
    }

    @Override
    public void updateStudent(Long id, String name) {
        jdbcTemplate.update(SQL_UPADTE_STUDENT, name, id);
    }
}
