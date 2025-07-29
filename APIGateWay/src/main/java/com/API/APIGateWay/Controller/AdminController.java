package com.API.APIGateWay.Controller;


import com.API.APIGateWay.Model.Post;
import com.API.APIGateWay.Model.PostReview;
import com.API.APIGateWay.Model.PostReviewData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/admin")
@Slf4j

public class AdminController {
    private final RestTemplate restTemplete = new RestTemplate();
    private String postServiceUrl = "http://localhost:8093";
    private String ratingServiceUrl = "http://localhost:8092";

    @PostMapping
    public ResponseEntity<Object> addMovie(@RequestBody Post post) {
        try {
//            log.info("adding post");
            Post savePost = restTemplete.postForObject(postServiceUrl+"/insta/createpost", post, Post.class);
            return ResponseEntity.ok().body(savePost);
        } catch (HttpStatusCodeException ex) {
//            log.info("error" + ex.getMessage());
            return ResponseEntity.status(ex.getStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getResponseBodyAsString());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable int id,@RequestBody Post post) {
        try {
//            log.info("updating post"+id);
            restTemplete.put(postServiceUrl+"/insta/update/"+id, post);
            return ResponseEntity.ok().build();
        } catch (HttpStatusCodeException ex) {
//            log.info("updating error" + ex.getMessage());
            return ResponseEntity.status(ex.getStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getResponseBodyAsString());
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Object> fetchPostAndReview(@PathVariable int id){
 Post post=restTemplete.getForObject(postServiceUrl+"/insta/post/"+id, Post.class);
 PostReview postReview=restTemplete.getForObject(ratingServiceUrl+"/insta/post/review/"+ post.getAccountHolder(), PostReview.class);
        PostReviewData postReviewData=new PostReviewData();
        postReviewData.setPostReview(postReview);
        postReviewData.setPost(post);

        return  ResponseEntity.ok(postReviewData);
    }

}
