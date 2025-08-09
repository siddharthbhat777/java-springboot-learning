package com.siddharth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // object will be created here
        Alien obj1 = (Alien) context.getBean("alien1"); // we are just using already created object
        obj1.age = 25;
        System.out.println(obj1.age);
        obj1.code();
        Alien obj2 = (Alien) context.getBean("alien1"); // as we are just using already created object, so it wont be created twice
        System.out.println(obj2.age);
        obj2.code();
    }
}
