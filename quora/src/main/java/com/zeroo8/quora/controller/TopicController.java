package com.zeroo8.quora.controller;

import com.zeroo8.quora.dto.topicDTO.CreateTopicRequest;
import com.zeroo8.quora.dto.topicDTO.TopicResponse;
import com.zeroo8.quora.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<TopicResponse> create(@RequestBody @Valid CreateTopicRequest request) {
        return ResponseEntity.status(201).body(topicService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAll() {
        return ResponseEntity.ok(topicService.getAll());
    }
}
