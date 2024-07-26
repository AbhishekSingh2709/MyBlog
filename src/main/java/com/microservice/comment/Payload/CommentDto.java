package com.microservice.comment.Payload;



import lombok.Data;

@Data
public class CommentDto
{
    private String commentId;
    private String name;
    private String emailId;
    private String body;
    private String postId;
}
