package com.PostReviewService.PostReviewService.Controller;

import com.PostReviewService.PostReviewService.Model.PostReview;
import com.PostReviewService.PostReviewService.Service.PostReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostReviewContr {

    @Autowired
    PostReviewService pRService;
    @GetMapping("/insta/posts")
    public List<PostReview> findAll(){
        System.out.println("from findAll");
        return  pRService.getAllReviews();
    }

    @PostMapping("/insta/post")
    public String postReview(@RequestBody PostReview postReview){
        pRService.addReview(postReview);
        return  "201";
    }

    @PutMapping("/insta/updateReview/{id}")
    public String updateReview(@PathVariable int id ,@RequestBody PostReview pr){
        pRService.updateReview(id,pr);
        return  "updated";
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("insta/deleteReview/{id}")
    public void deleteReview(@PathVariable int id){

        pRService.deleteReview(id);
    }

    @GetMapping("/insta/post/review/{name}")
    public  PostReview getByName(@PathVariable String name){
        System.out.print("from controller"+name);
        return  pRService.getByName(name);
    }


}
