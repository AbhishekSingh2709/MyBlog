package com.microservice.comment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "comment_id", nullable = false)
    private String commentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "post_id", nullable = false, unique = true)
    private String postId;

}