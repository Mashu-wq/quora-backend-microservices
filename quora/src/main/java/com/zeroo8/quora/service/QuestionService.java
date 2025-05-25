package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.QuestionAdapter;
import com.zeroo8.quora.dto.questionDTO.CreateQuestionRequest;
import com.zeroo8.quora.dto.questionDTO.QuestionResponse;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.models.Question;
import com.zeroo8.quora.models.User;
import com.zeroo8.quora.repositories.QuestionRepository;
import com.zeroo8.quora.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final QuestionAdapter questionAdapter;

    public QuestionResponse createQuestion(CreateQuestionRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        Question question = questionAdapter.toEntity(request, user);
        return questionAdapter.toResponse(questionRepository.save(question));
    }

    public List<QuestionResponse> searchQuestions(String text, String tag) {
        return questionRepository.searchQuestions(text, tag)
                .stream()
                .map(questionAdapter::toResponse)
                .collect(Collectors.toList());
    }
}
