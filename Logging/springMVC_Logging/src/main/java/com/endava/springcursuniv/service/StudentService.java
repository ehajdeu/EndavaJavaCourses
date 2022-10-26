package com.endava.springcursuniv.service;

import com.endava.springcursuniv.model.Student;
import com.endava.springcursuniv.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
    
    public List<Student> getAllStudents() {
        logger.info("Getting all students...");
        List<Student> listOfStudents = studentRepository.findAll();
        if(listOfStudents.isEmpty()) {
            logger.error("There are no students registered yet!");
        } else {
            logger.info("There are {} students in the list", listOfStudents.size());
        }
        return listOfStudents;
    }
    
    public void addStudent(Student student) {
        studentRepository.save(student);
        logger.info("Student: {}, has been saved", student);
    }
    
    public Optional<Student> findStudent(long id) {
       Optional<Student> studentById = studentRepository.findById(id);
       if(studentById.isPresent()) {
           logger.info("Student with id={} was found", id);
       } else{
           logger.error("Student with id={} was not found...", id);
       }
       return studentById;

    }
    
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
    
    public void removeStudent(Student student) {
        Optional<Student> studentToDelete = findStudent(student.getId());
        if(studentToDelete.isPresent()) {
            logger.info("Removing student with id={}", student.getId());
            studentRepository.delete(student);
        } else{
            logger.warn("Student with id={} was not found...", student.getId());
        }
    }
}
