package com.siddharth;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
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
