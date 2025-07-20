package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating student data
        /*Student s1 = new Student();
        s1.setRollNumber(102);
        s1.setStudentName("Madhusudan");
        s1.setStudentAge(31);*/

        // establishing connection with database using config
        /*Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.Student.class);
        config.configure();*/

        // Using session to perform database operation
        // SessionFactory sf = config.buildSessionFactory();
        // Merging all
        /*SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session = sf.openSession();*/

        // Creating transaction to do operation
        /*Transaction transaction = session.beginTransaction();
        session.persist(s1); // store data in database
        transaction.commit();*/

        // Getting data
         /*Student s2 = session.find(Student.class, 102);
         System.out.println(s2);*/

        // Update data
        /*Transaction transaction = session.beginTransaction();
        session.merge(s1); // Update the data, if data not found then it will create it
        transaction.commit();*/

        // Delete data
        // remove method needs object instead of id
        // getting object with ID
        /*Student s2 = session.find(Student.class, 105);
        System.out.println(s2);
        // removing data using object
        Transaction transaction = session.beginTransaction();
        session.remove(s2);
        transaction.commit();*/

        // Creating laptop data
        /*Laptop l1 = new Laptop();
        l1.setLaptopId(1);
        l1.setBrand("ASUS");
        l1.setModel("ROG");
        l1.setRam(16);
        Laptop l2 = new Laptop();
        l2.setLaptopId(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);
        Laptop l3 = new Laptop();
        l3.setLaptopId(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(8);*/

        // Creating alien data
        /*Alien a1 = new Alien();
        a1.setAlienId(101);
        a1.setAlienName("Siddharth");
        a1.setTechnology("Java");

        Alien a2 = new Alien();
        a2.setAlienId(102);
        a2.setAlienName("Ruchika");
        a2.setTechnology("Python");

        Alien a3 = new Alien();
        a3.setAlienId(103);
        a3.setAlienName("Vasudha");
        a3.setTechnology("C++");*/

        // Association
        /*a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l3));*/

        // Using session
        SessionFactory sf = new Configuration()
                // .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure().buildSessionFactory();
        Session session = sf.openSession();

        // Using transaction
        /*Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        transaction.commit();*/

        // Adding HQL query
        // Normal SQL -> select * from laptop where ram=32
        // HQL -> from Laptop where ram=32
        // Query query = session.createQuery("from Laptop where brand like 'ASUS'");
        /*String brand = "ASUS";
        // Query query = session.createQuery("from Laptop where brand like ?1"); // just giving numbering to '?' to identify
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();*/

        // Fetching details
        // Laptop l1 = session.find(Laptop.class, 3);
        // System.out.println(l1);
        // System.out.println(laptops);
        /*for (Object[] data: laptops) {
            System.out.println((String)data[0] + " " + (String)data[1]);
        }*/

        // Load instead of get
        /*Laptop laptop = session.byId(Laptop.class).getReference(2);
        System.out.println(laptop);*/

        // Using Ehcache
        Laptop l1 = session.find(Laptop.class, 2);
        System.out.println(l1);

        // Closing session
        session.close();

        // Testing data fetch EAGER / LAZY
        /*Session session1 = sf.openSession();
        Alien a3 = session1.find(Alien.class, 102);
        //  System.out.println(a3);
        session1.close();*/

        // Ehcache
        Session session1 = sf.openSession();
        Laptop l2 = session1.find(Laptop.class, 2);
        System.out.println(l2);
        session1.close();

        //Closing factory
        sf.close();
    }
}