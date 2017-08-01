package com.jennbowers.moviereviewer.controllers;

import com.jennbowers.moviereviewer.interfaces.MovieRepository;
import com.jennbowers.moviereviewer.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieReviewerController {

    @Autowired
    MovieRepository repo;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movies", movies);
        return "index";
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.GET)
    public String addMovie() {
        return "addMovie";
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public String addMovie(@RequestParam ("title") String title,
                           @RequestParam ("genre") String genre,
                           @RequestParam ("imdblink") String imdblink,
                           @RequestParam ("releasedate") String releasedate){
        Movie newMovie = new Movie(title, genre, imdblink, releasedate);
        repo.save(newMovie);
        return "redirect:/";
    }
}
