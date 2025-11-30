package com.siddharth.spring_security_demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Sid", "Java"),
            new Student(2, "Aarav", "Python"),
            new Student(3, "Riya", "JavaScript"),
            new Student(4, "Karan", "C++"),
            new Student(5, "Meera", "Angular"),
            new Student(6, "Rohan", "React"),
            new Student(7, "Tara", "Node.js"),
            new Student(8, "Vikram", "Spring Boot"),
            new Student(9, "Ananya", "DevOps"),
            new Student(10, "Ishaan", "SQL")
    ));

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
