package com.jennbowers.moviereviewer.controllers;

import com.jennbowers.moviereviewer.interfaces.MovieRepository;
import com.jennbowers.moviereviewer.interfaces.ReviewRepository;
import com.jennbowers.moviereviewer.models.Movie;
import com.jennbowers.moviereviewer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieReviewerController {

    @Autowired
    MovieRepository repo;

    @Autowired
    ReviewRepository reviewRepo;

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
                           @RequestParam ("releasedate") String releasedate,
                           @RequestParam ("imgurl") String imgurl){
        Movie newMovie = new Movie(title, genre, imdblink, releasedate, imgurl);
        repo.save(newMovie);
        return "redirect:/";
    }

    @RequestMapping("/edit/{movieId}")
    public String displayEditMovie(@PathVariable("movieId") long movieId,
                            Model model){
        Movie movie = repo.findOne(movieId);
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    @RequestMapping(value = "/edit/{movieId}", method = RequestMethod.POST)
    public String editMovie(@PathVariable("movieId") long movieId,
                            @RequestParam("title") String title,
                            @RequestParam("genre") String genre,
                            @RequestParam("imdblink") String imdblink,
                            @RequestParam("releasedate") String releasedate,
                            @RequestParam("imgurl") String imgurl,
                            Model model){
        Movie movie = repo.findOne(movieId);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setImdbLink(imdblink);
        movie.setReleasedate(releasedate);
        movie.setImgurl(imgurl);
        repo.save(movie);
        model.addAttribute("movie", movie);
        return "detailMovie";
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public String detailMovie(@PathVariable("movieId") long movieId,
                                     Model model) {
        Movie movie = repo.findOne(movieId);
        model.addAttribute("movie", movie);
        return "detailMovie";
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.POST)
    public String leaveReview(@PathVariable("movieId") long movieId,
                              @RequestParam("reviewername") String reviewername,
                              @RequestParam("rating") String rating,
                              @RequestParam("reviewerage") String reviewerage,
                              @RequestParam("reviewergender") String reviewergender,
                              @RequestParam("revieweroccupation") String revieweroccupation) {
        Integer reviewerAgeInt;
        if (reviewerage.equals("")) {
            reviewerAgeInt = null;
        } else {
            reviewerAgeInt = Integer.parseInt(reviewerage);
        }

        if (reviewergender.equals("")) {
            reviewergender = null;
        }

        if (revieweroccupation.equals("")) {
            revieweroccupation = null;
        }

        Movie movie = repo.findOne(movieId);
        Review newReview = new Review(reviewername, rating, reviewerAgeInt, reviewergender, revieweroccupation, movie);
        reviewRepo.save(newReview);
        return "redirect:/movie/" + movieId;
    }

}
