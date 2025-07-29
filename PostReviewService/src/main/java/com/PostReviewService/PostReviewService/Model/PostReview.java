package com.PostReviewService.PostReviewService.Model;


import java.util.*;


//@Entity
public class PostReview {

//@Id
    private int id;
    private String name;
    private int likes;
    private List<String> comments;

    public PostReview(int id, String name, int likes, List<String> comments) {
        this.id = id;
        this.name = name;
        this.likes = likes;
        this.comments = comments;
    }

    public PostReview(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PostReview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
