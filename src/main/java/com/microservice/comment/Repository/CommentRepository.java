package com.microservice.comment.Repository;

import com.microservice.comment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}