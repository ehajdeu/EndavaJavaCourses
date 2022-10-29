package com.euniversity.jdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final StudentService studentService;

    public TestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String triggerTest() {
        studentService.test();
        return "OK";
    }
}
