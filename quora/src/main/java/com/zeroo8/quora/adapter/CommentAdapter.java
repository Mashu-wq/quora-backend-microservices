package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.commentDTO.CommentResponse;
import com.zeroo8.quora.models.Answer;
import com.zeroo8.quora.models.Comment;
import com.zeroo8.quora.models.User;
import org.springframework.stereotype.Component;

@Component
public class CommentAdapter {

    public Comment toEntity(String text, User user, Answer answer, Comment parentComment) {
        return Comment.builder()
                .text(text)
                .user(user)
                .answer(answer)
                .parentComment(parentComment)
                .build();
    }

    public CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .parentId(comment.getParentComment() != null ? comment.getParentComment().getId() : comment.getAnswer() != null ? comment.getAnswer().getId() : null)
                .text(comment.getText())
                .userId(comment.getUser().getId())
                .username(comment.getUser().getUsername())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}