package com.siddharth.SpringJDBCExample.repo;

import com.siddharth.SpringJDBCExample.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }
}
