package com.PostReviewService.PostReviewService.Service;

import com.PostReviewService.PostReviewService.Model.PostReview;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PostReviewService {

    public List<PostReview> postReviews = new ArrayList<>(
            List.of(
                    new PostReview(1, "Vamsi", 95, List.of("amazing post", "positive vibes", "keep going")),
                    new PostReview(2, "Leo", 92, List.of("funny", "creative", "liked it")),
                    new PostReview(3, "Kiran", 98, List.of("techie stuff", "love Java", "great post")),
                    new PostReview(4, "Anjali", 94, List.of("useful", "inspiring", "very helpful")),
                    new PostReview(5, "Raj", 89, List.of("cool", "relaxing", "weekend goals")),
                    new PostReview(6, "Sneha", 96, List.of("fitspiration", "energetic", "great energy")),
                    new PostReview(7, "Arjun", 91, List.of("refreshing", "nature lover", "peaceful vibes")),
                    new PostReview(8, "Meena", 90, List.of("relatable", "been there", "debuggers unite"))
            )
    );



    public List<PostReview> getAllReviews() {
        return postReviews;
    }

    public void addReview(PostReview review) {
        postReviews.add(review);
    }

    public void updateReview(int id, PostReview body) {
        AtomicReference<PostReview> review;
       postReviews.forEach(it->{
           if(it.getId()==id){
               it.setLikes(body.getLikes());
               it.setComments(body.getComments());
               it.setName(body.getName());
           }
       });

    }

    public void deleteReview(int id) {
        postReviews=postReviews.stream().filter(it->it.getId()!=id).toList();
    }

    public PostReview getByName(String name) {
        PostReview postr = null;

        for (PostReview it : postReviews) {
            if (it.getName().equals(name)) {
                System.out.println("from iteration: " + it);
                postr = new PostReview(it.getId(), it.getName(), it.getLikes(), it.getComments());
                break; // Optional: stop after finding the first match
            }
        }

        System.out.println("from getByName");
        System.out.println("obj is: " + postr);
        return postr;
    }

}
