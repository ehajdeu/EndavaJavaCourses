package com.euniversity.jdbc;

import com.euniversity.jdbc.datasource.StudentDAO;
import com.euniversity.jdbc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void test() {
        Student student1 = new Student(1L, "John", "Doe", 21, "IT");
        Student student2 = new Student(2L, "Ann", "Smith", 27, "ART");
        studentDAO.createStudentBulk(Arrays.asList(student1, student2));

        List<Student> studentList = studentDAO.getAllStudents();

        for (Student student : studentList) {
            System.out.println(student.getFirstName());
        }

        studentDAO.deleteStudent(1L);

        studentList = studentDAO.getAllStudents();

        System.out.println("\nPRINTING STUDENTS AFTER DELETION");
        for (Student student : studentList) {
            System.out.println("After deletion: " + student.getFirstName());
//            studentDAO.deleteStudent(student.getId());
        }
    }
}
