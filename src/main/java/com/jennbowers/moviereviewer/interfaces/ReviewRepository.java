package com.jennbowers.moviereviewer.interfaces;

import com.jennbowers.moviereviewer.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {}
