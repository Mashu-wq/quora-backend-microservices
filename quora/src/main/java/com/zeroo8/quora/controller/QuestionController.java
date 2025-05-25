package com.zeroo8.quora.controller;

import com.zeroo8.quora.dto.questionDTO.CreateQuestionRequest;
import com.zeroo8.quora.dto.questionDTO.QuestionResponse;
import com.zeroo8.quora.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> createQuestion(@Valid @RequestBody CreateQuestionRequest request) {
        QuestionResponse response = questionService.createQuestion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<QuestionResponse>> searchQuestions(@RequestParam(required = false) String text,
                                                                  @RequestParam(required = false) String tag) {
        List<QuestionResponse> responses = questionService.searchQuestions(text, tag);
        return ResponseEntity.ok(responses);
    }
}
