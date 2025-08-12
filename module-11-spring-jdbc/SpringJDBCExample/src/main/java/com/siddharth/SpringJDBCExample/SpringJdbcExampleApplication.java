package com.siddharth.SpringJDBCExample;

import com.siddharth.SpringJDBCExample.model.Student;
import com.siddharth.SpringJDBCExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExampleApplication.class, args);
        Student s = context.getBean(Student.class);
        s.setRollNo(101);
        s.setName("Siddharth");
        s.setMarks(94);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println(students);
	}

}
