package com.API.APIGateWay.Model;

import lombok.Data;

@Data
public class PostReviewData {
    private  Post post;
    private PostReview postReview;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostReview getPostReview() {
        return postReview;
    }

    public void setPostReview(PostReview postReview) {
        this.postReview = postReview;
    }
}
