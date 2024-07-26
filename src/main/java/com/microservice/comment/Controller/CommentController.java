package com.microservice.comment.Controller;

import com.microservice.comment.Payload.CommentDto;
import com.microservice.comment.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController
{
    private CommentService cr;

    public CommentController(CommentService cr) {
        this.cr = cr;
    }

    @PostMapping("/saveComment")
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto comment)
    {
        CommentDto commentDto = cr.saveComment(comment);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
