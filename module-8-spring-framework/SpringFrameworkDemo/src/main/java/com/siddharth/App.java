package com.siddharth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // object will be created here
        Alien obj1 = context.getBean("alien1", Alien.class); // we are just using already created object
        System.out.println(obj1.getAge());
        obj1.code();
        /*Alien obj2 = (Alien) context.getBean("alien1"); // as we are just using already created object, so it wont be created twice
        System.out.println(obj2.age);
        obj2.code();*/

        // Desktop obj = (Desktop) context.getBean("computer2");
        // If you don't wanna do type casting
        Desktop obj2 = context.getBean("computer2", Desktop.class);
        // if there is just one bean of this class
        Desktop obj3 = context.getBean(Desktop.class);
    }
}
