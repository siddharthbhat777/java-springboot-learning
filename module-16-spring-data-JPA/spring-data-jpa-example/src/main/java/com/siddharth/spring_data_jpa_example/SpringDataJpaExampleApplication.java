package com.siddharth.spring_data_jpa_example;

import com.siddharth.spring_data_jpa_example.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExampleApplication.class, args);
        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

        s1.setRollNo(101);
        s1.setName("Siddharth");
        s1.setMarks(94);

        s2.setRollNo(102);
        s2.setName("Ruchika");
        s2.setMarks(86);

        s3.setRollNo(103);
        s3.setName("Vasudha");
        s3.setMarks(65);
	}

}
