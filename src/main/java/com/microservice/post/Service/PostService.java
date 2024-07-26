package com.microservice.post.Service;

import com.microservice.post.Entity.Post;
import com.microservice.post.Payload.PostDto;
import com.microservice.post.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService
{

    @Autowired
    private PostRepository pr;

    public Post DtoToEntity(PostDto dto)
    {
        Post post = new Post();
        String postId = UUID.randomUUID().toString();
        post.setPostId(postId);
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        return post;
    }

    public  PostDto EntityToDto(Post entity)
    {
        PostDto dto = new PostDto();
        dto.setPostId(entity.getPostId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        return dto;
    }

    public PostDto savePost(PostDto post)
    {
        Post postEntity = DtoToEntity(post);
        Post savedPost = pr.save(postEntity);
        PostDto savedDto = EntityToDto(savedPost);
        return savedDto;
    }

    public PostDto findPostById(String postId)
    {
        Post postById = pr.findById(postId).get();
        PostDto postDto = EntityToDto(postById);
        return postDto;
    }
}
