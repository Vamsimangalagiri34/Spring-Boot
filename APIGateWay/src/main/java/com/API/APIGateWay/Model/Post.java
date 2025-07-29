package com.API.APIGateWay.Model;

public class Post {

    private  int id;
    private  String postName;
    private String accountHolder;
    private String location;
    private String mood;

    public Post(int id, String postName, String accountHolder, String location, String mood) {
        this.id = id;
        this.postName = postName;
        this.accountHolder = accountHolder;
        this.location = location;
        this.mood = mood;
    }

    public Post(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }


}
