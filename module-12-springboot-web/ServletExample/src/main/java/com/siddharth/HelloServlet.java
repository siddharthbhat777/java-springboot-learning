package com.siddharth;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("In Service");

        resp.setContentType("text/html"); // allows you to print with html

        // resp.getWriter().println("Hello World!");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Hello World!</h2>");
    }
}
