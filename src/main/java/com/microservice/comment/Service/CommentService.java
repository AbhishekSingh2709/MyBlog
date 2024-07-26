package com.microservice.comment.Service;

import com.microservice.comment.Configuration.RestTemplateConfig;
import com.microservice.comment.Entity.Comment;
import com.microservice.comment.Payload.CommentDto;
import com.microservice.comment.Payload.Post;
import com.microservice.comment.Repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CommentService
{
    private RestTemplateConfig restTemplateConfig;
    private CommentRepository cr;

    public CommentService(RestTemplateConfig restTemplateConfig, CommentRepository cr) {
        this.restTemplateConfig = restTemplateConfig;
        this.cr = cr;
    }

    public CommentDto saveComment(CommentDto comment)
    {
        Post post = restTemplateConfig.getRestTemplate().
                getForObject("http://localhost:8081/api/v1/post/" + comment.getPostId(), Post.class);
        if (post!=null)
        {
            Comment commentEntity = DtoToEntity(comment);
            Comment savedComment = cr.save(commentEntity);
            CommentDto savedDto = EntityToDto(savedComment);
            return savedDto;
        }else
        {
            return null;
        }
    }

    public Comment DtoToEntity(CommentDto comment)
    {
        Comment entity = new Comment();
        String commentId = UUID.randomUUID().toString();
        entity.setCommentId(commentId);
        entity.setPostId(comment.getPostId());
        entity.setName(comment.getName());
        entity.setEmailId(comment.getEmailId());
        entity.setBody(comment.getBody());
        return entity;
    }

    public CommentDto EntityToDto(Comment entity)
    {
        CommentDto commentDto = new CommentDto();
        commentDto.setCommentId(entity.getCommentId());
        commentDto.setPostId(entity.getPostId());
        commentDto.setName(entity.getName());
        commentDto.setEmailId(entity.getEmailId());
        commentDto.setBody(entity.getBody());
        return commentDto;
    }
}
