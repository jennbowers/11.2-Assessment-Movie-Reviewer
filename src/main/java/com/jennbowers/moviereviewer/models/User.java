package com.jennbowers.moviereviewer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user_data", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public User() {}

    public User(String name, int age, String gender, String occupation, String username, String password, List<Review> reviews) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.username = username;
        this.password = password;
        this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}