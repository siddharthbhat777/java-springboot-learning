package com.siddharth.JobApp;

import com.siddharth.JobApp.model.JobPost;
import com.siddharth.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm") // function name used in addjob jsp file
    public String handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }
}
