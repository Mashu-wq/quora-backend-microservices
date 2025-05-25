package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.CommentAdapter;
import com.zeroo8.quora.dto.commentDTO.CommentResponse;
import com.zeroo8.quora.dto.commentDTO.CreateCommentRequest;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.models.*;
import com.zeroo8.quora.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final CommentAdapter commentAdapter;

    public CommentResponse commentOnAnswer(UUID answerId, CreateCommentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new CustomException("Answer not found", HttpStatus.NOT_FOUND));

        Comment comment = commentAdapter.toEntity(request.getText(), user, answer, null);
        return commentAdapter.toResponse(commentRepository.save(comment));
    }

    public CommentResponse commentOnComment(UUID parentCommentId, CreateCommentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        Comment parentComment = commentRepository.findById(parentCommentId)
                .orElseThrow(() -> new CustomException("Parent comment not found", HttpStatus.NOT_FOUND));

        Comment comment = commentAdapter.toEntity(request.getText(), user, null, parentComment);
        return commentAdapter.toResponse(commentRepository.save(comment));
    }
}