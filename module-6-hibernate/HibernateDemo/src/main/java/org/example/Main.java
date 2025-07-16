package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Creating student data
        Student s1 = new Student();
        s1.setRollNumber(105);
        s1.setStudentName("Priyanka");
        s1.setStudentAge(29);

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
        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();

        // Closing session
        session.close();
        sf.close();

        System.out.println(s1);
    }
}