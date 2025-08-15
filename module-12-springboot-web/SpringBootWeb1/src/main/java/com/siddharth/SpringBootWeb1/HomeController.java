package com.siddharth.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // Servlet and Session way
    /*@RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session) {

        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;

        session.setAttribute("result", result); // passing data to ui

        System.out.println(result);
        return "result.jsp";
    }*/

    // Spring way with param and model object
    @RequestMapping("add")
    public String add(int num1, @RequestParam("num2") int number2, Model model) {
        int result = num1 + number2;

        model.addAttribute("result", result); // passing data to ui

        System.out.println(result);
        return "result";
    }
}
