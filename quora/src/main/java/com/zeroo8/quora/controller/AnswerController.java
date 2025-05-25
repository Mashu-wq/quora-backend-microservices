package com.zeroo8.quora.controller;

import com.zeroo8.quora.dto.answerDTO.*;
import com.zeroo8.quora.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{questionId}/answers")
    public ResponseEntity<AnswerResponse> createAnswer(@PathVariable UUID questionId,
                                                       @Valid @RequestBody CreateAnswerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(answerService.createAnswer(questionId, request));
    }

    @PutMapping("/answers/{answerId}")
    public ResponseEntity<AnswerResponse> updateAnswer(@PathVariable UUID answerId,
                                                       @Valid @RequestBody UpdateAnswerRequest request) {
        return ResponseEntity.ok(answerService.updateAnswer(answerId, request));
    }
}
