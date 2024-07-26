package com.microservice.comment.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post
{
    private String postId;
    private String title;
    private String content;
    private String description;
}
