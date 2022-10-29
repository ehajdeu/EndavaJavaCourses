package com.euniversity.jdbc.datasource;

import com.euniversity.jdbc.entity.Student;

import java.util.List;

public interface StudentDAO {
    
    Student getStudentById(Long id);
    
    List<Student> getAllStudents();
    
    boolean deleteStudent(Long id);
    
    boolean createStudent(Student student);
    
    void createStudentBulk(List<Student> students);
    
    void updateStudent(Long id, String name);
    
}
