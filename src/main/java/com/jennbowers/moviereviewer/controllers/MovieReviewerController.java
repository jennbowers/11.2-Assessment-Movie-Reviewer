package com.jennbowers.moviereviewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieReviewerController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
