package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Creating student data
        Student s1 = new Student();
        s1.setRollNumber(102);
        s1.setStudentName("Madhusudan");
        s1.setStudentAge(31);

        // establishing connection with database using config
        /*Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.Student.class);
        config.configure();*/

        // Using session to perform database operation
        // SessionFactory sf = config.buildSessionFactory();
        // Merging all
        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session = sf.openSession();

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
        Student s2 = session.find(Student.class, 105);
        System.out.println(s2);
        // removing data using object
        Transaction transaction = session.beginTransaction();
        session.remove(s2);
        transaction.commit();

        // Closing session
        session.close();
        sf.close();

        System.out.println(s1);
    }
}