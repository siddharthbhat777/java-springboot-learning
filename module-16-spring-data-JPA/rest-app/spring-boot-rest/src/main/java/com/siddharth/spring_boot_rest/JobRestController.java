package com.siddharth.spring_boot_rest;

import com.siddharth.spring_boot_rest.model.JobPost;
import com.siddharth.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path = "jobPosts", produces = {"application/json"}) // produces -> this function only returns specified data types
    // @ResponseBody -> need to use this if you are treating component as Controller and not RestController
    public List<JobPost> getAllJobs() {
        return service.getAllJobs(); // jackson library (in-built with spring) converts data into JSON
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping(path = "jobPost", consumes = "application/json") // consumes -> accept only specified type of data
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return service.getJob(postId) == null? "Deleted job post with post ID " + postId + " successfully" : "Deletion  unsuccessful";
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "Success";
    }
}