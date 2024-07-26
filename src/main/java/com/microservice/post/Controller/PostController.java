package com.microservice.post.Controller;


import com.microservice.post.Payload.PostDto;
import com.microservice.post.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController
{
    private PostService ps;

    public PostController(PostService ps) {
        this.ps = ps;
    }

    @PostMapping("/addPost")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto post)
    {
        PostDto postDto = ps.savePost(post);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String postId)
    {
        PostDto postDto = ps.findPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
