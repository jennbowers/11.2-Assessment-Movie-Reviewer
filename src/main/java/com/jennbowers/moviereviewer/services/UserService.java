package com.jennbowers.moviereviewer.services;

import com.jennbowers.moviereviewer.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
