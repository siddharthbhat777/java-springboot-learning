package com.siddharth.spring_data_jpa_example;

import com.siddharth.spring_data_jpa_example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
