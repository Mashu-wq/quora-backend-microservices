package com.zeroo8.quora.controller;

import com.zeroo8.quora.dto.commentDTO.CommentResponse;
import com.zeroo8.quora.dto.commentDTO.CreateCommentRequest;
import com.zeroo8.quora.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/answers/{answerId}/comments")
    public ResponseEntity<CommentResponse> commentOnAnswer(@PathVariable UUID answerId,
                                                            @Valid @RequestBody CreateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.commentOnAnswer(answerId, request));
    }

    @PostMapping("/comments/{commentId}/comments")
    public ResponseEntity<CommentResponse> commentOnComment(@PathVariable UUID commentId,
                                                             @Valid @RequestBody CreateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.commentOnComment(commentId, request));
    }
}
