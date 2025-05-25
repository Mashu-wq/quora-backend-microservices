package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.answerDTO.AnswerResponse;
import com.zeroo8.quora.dto.answerDTO.CreateAnswerRequest;
import com.zeroo8.quora.models.Answer;
import com.zeroo8.quora.models.Question;
import com.zeroo8.quora.models.User;
import org.springframework.stereotype.Component;

@Component
public class AnswerAdapter {

    public Answer toEntity(CreateAnswerRequest request, Question question, User user) {
        return Answer.builder()
                .text(request.getText())
                .question(question)
                .user(user)
                .build();
    }

    public AnswerResponse toResponse(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .questionId(answer.getQuestion().getId())
                .text(answer.getText())
                .userId(answer.getUser().getId())
                .username(answer.getUser().getUsername())
                .createdAt(answer.getCreatedAt())
                .build();
    }
}