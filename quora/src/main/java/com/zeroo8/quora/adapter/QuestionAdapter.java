package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.questionDTO.CreateQuestionRequest;
import com.zeroo8.quora.dto.questionDTO.QuestionResponse;
import com.zeroo8.quora.models.Question;
import com.zeroo8.quora.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QuestionAdapter {
    public Question toEntity(CreateQuestionRequest request, User user) {
        return Question.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .topicTags(request.getTopicTags())
                .user(user)
                .build();
    }

    public QuestionResponse toResponse(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .title(question.getTitle())
                .body(question.getBody())
                .topicTags(question.getTopicTags())
                .userId(question.getUser().getId())
                .username(question.getUser().getUsername())
                .createdAt(LocalDateTime.from(question.getCreatedAt()))
                .build();
    }
}
