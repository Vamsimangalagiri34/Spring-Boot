package com.API.APIGateWay.Model;


import java.util.List;


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
}
