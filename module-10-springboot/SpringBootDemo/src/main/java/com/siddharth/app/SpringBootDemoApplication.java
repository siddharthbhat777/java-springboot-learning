package com.siddharth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		// Way to communicate with spring to get created object from container
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		Alien obj = context.getBean(Alien.class);
		System.out.println(obj.getAge());
		obj.code();
	}

}
