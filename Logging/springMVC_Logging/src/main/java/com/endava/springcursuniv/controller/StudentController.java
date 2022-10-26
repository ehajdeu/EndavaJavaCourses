package com.endava.springcursuniv.controller;

import com.endava.springcursuniv.model.Student;
import com.endava.springcursuniv.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }
    
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
    
    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        studentService.addStudent(student);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = getStudent(id);
        model.addAttribute("student", student);
        return "update-student";
    }
    
    
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }
        studentService.updateStudent(student);
        logger.info("Student with id={} was updated", id);
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
    
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = getStudent(id);
        studentService.removeStudent(student);
        logger.info("Student with id={} was successfully removed", id);
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
    
    private Student getStudent(@PathVariable("id") long id) {
        Student student;
        if (studentService.findStudent(id).isPresent()) {
            student = studentService.findStudent(id).get();
        } else {
            logger.error("Invalid Student ID: {}", id);
            throw new IllegalArgumentException("Invalid Student ID: " + id);
        }
        return student;
    }
    
}
