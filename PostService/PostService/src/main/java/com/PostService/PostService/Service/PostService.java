package com.PostService.PostService.Service;

import com.PostService.PostService.Model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    List<Post> posts = new ArrayList<>(
            List.of(
                    new Post(1, "Feeling Happy", "Vamsi", "Hyderabad", "crazy"),
                    new Post(2, "Feeling Happy", "Leo", "Vijayawada", "Mad Max"),
                    new Post(3, "Java is love ❤️", "Kiran", "Bangalore", "code daily"),
                    new Post(4, "Exploring Spring Boot", "Anjali", "Chennai", "dev vibes"),
                    new Post(5, "Weekend vibes", "Raj", "Pune", "chill mode"),
                    new Post(6, "Gym time!", "Sneha", "Mumbai", "fitness first"),
                    new Post(7, "Nature walk 🌿", "Arjun", "Ooty", "fresh air"),
                    new Post(8, "Late night debugging", "Meena", "Delhi", "debug mode")
            )
    );

    public  void postPost(Post post){
          posts.add(post);
    }

    public void upDatePost(int id,Post post){
        posts.forEach(it->{
            if(it.getId()==id){
                it.setAccountHolder(post.getAccountHolder());
                it.setLocation(post.getLocation());
                it.setPostName(post.getPostName());
                it.setMood(post.getMood());
            }
        });
    }

    public  List<Post> getAllPosts(){
        return posts;
    }

    public  List<Post> deletePost(int id){
      return   posts=posts.stream().filter(it->it.getId()!=id).toList();
    }

    public Post getById(int id) {
        Post p=new Post();
        posts.forEach(it->{
            if(it.getId()==id) {
                p.setMood(it.getMood());
                p.setId(it.getId());
                p.setPostName(it.getPostName());
                p.setLocation(it.getLocation());
                p.setAccountHolder(it.getAccountHolder());
            }
        });

        return  p;
    }
}
