package com.siddharth;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", null); // "" empty for default app
        tomcat.addServlet(context, "HelloServlet1", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet1");

        tomcat.start();
        tomcat.getServer().await();
    }
}
