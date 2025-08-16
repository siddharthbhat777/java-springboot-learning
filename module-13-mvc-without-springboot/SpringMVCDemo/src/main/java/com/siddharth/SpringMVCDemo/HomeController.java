package com.siddharth.SpringMVCDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

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
    /*@RequestMapping("add")
    public String add(int num1, @RequestParam("num2") int number2, Model model) {
        int result = num1 + number2;

        model.addAttribute("result", result); // passing data to ui

        System.out.println(result);
        return "result";
    }*/

    // Model and view combined
    @RequestMapping("add")
    public ModelAndView add(int num1, @RequestParam("num2") int number2, ModelAndView mv) {
        int result = num1 + number2;

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    // Normal way
    /*@RequestMapping("addAlien")
    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {

        Alien alien = new Alien();
        alien.setId(aid);
        alien.setAname(aname);

        mv.addObject("alien", alien);
        mv.setViewName("result");

        return mv;
    }*/

    // Spring way
    @RequestMapping("addAlien")
    public String addAlien(Alien alien) {
        return "result";
    }
}
