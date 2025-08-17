package com.siddharth.spring_data_jpa_example;

import com.siddharth.spring_data_jpa_example.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExampleApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        // Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        // Student s3 = context.getBean(Student.class);

        /*s1.setRollNo(101);
        s1.setName("Siddharth");
        s1.setMarks(94);*/

        s2.setRollNo(102);
        s2.setName("Ruchika Ganacharya");
        s2.setMarks(92);

        /*s3.setRollNo(103);
        s3.setName("Vasudha");
        s3.setMarks(65);

        repo.save(s2);
        repo.save(s3);*/

        // System.out.println(repo.findAll());

        // System.out.println(repo.findById(103)); // returns optional object to handle null output

        // to handle null output by yourself
        /*Optional<Student> student = repo.findById(105);
        System.out.println(student.orElse(new Student()));*/ // returns blank object if data not found

        /*System.out.println(repo.findByName("Siddharth")); // created custom method
        System.out.println(repo.findByMarksGreaterThan(72)); // created custom method*/

        // update data
        repo.save(s2);

        // delete data
        repo.delete(s2);
	}
}
