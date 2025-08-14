package com.siddharth;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("In Service");
    }
}
