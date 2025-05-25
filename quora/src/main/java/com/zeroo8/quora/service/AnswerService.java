package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.AnswerAdapter;
import com.zeroo8.quora.dto.answerDTO.*;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.models.Answer;
import com.zeroo8.quora.models.Question;
import com.zeroo8.quora.models.User;
import com.zeroo8.quora.repositories.AnswerRepository;
import com.zeroo8.quora.repositories.QuestionRepository;
import com.zeroo8.quora.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final AnswerAdapter answerAdapter;

    public AnswerResponse createAnswer(UUID questionId, CreateAnswerRequest request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new CustomException("Question not found", HttpStatus.NOT_FOUND));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        Answer answer = answerAdapter.toEntity(request, question, user);
        return answerAdapter.toResponse(answerRepository.save(answer));
    }

    public AnswerResponse updateAnswer(UUID answerId, UpdateAnswerRequest request) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new CustomException("Answer not found", HttpStatus.NOT_FOUND));

        answer.setText(request.getText());
        return answerAdapter.toResponse(answerRepository.save(answer));
    }
}
