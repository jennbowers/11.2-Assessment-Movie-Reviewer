package com.jennbowers.moviereviewer.interfaces;

import com.jennbowers.moviereviewer.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{}
