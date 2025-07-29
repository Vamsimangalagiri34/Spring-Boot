package com.PostService.PostService.Controller;

import com.PostService.PostService.Model.Post;
import com.PostService.PostService.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController
{
    @Autowired
    PostService postService;

    @GetMapping("/insta/posts")
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/insta/createpost")
    public  void createPost(@RequestBody  Post post){
        postService.postPost(post);
    }
    // PUT - Update post using ?id= in query
    @PutMapping("/insta/update/{id}")
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.upDatePost(id, post);
    }

    // DELETE - Delete post using ?id= in query
    @DeleteMapping("/insta/delete/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
    @GetMapping("/insta/post/{id}")
    public  Post getById(@PathVariable int id){
        return  postService.getById(id);
    }
}
