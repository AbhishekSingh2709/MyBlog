package com.microservice.post.Payload;

import lombok.Data;

@Data
public class PostDto {

    private String postId;
    private String title;
    private String content;
    private String description;

}
