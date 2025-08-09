package com.siddharth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {
    private int age;

    @Autowired
    // @Qualifier("laptop") // can use class name with lowercase
    //  @Qualifier("com2")
    private Computer computer;

    public Alien() {
        System.out.println("Alien object created");
    }

    /*@ConstructorProperties({ "age", "computer" }) // for "name"  attr constructor injection
    public Alien(int age, Computer computer) {
        this.age = age;
        this.computer = computer;
    }*/

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code() {
        System.out.println("Coding...");
        computer.compile();
    }
}
