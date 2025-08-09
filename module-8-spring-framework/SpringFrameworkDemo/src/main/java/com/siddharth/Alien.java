package com.siddharth;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien object created");
    }

    @ConstructorProperties({ "age", "laptop" }) // for "name"  attr constructor injection
    public Alien(int age, Laptop laptop) {
        this.age = age;
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void code() {
        System.out.println("Coding...");
        laptop.compile();
    }
}
