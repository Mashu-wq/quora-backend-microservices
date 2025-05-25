package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.TopicAdapter;
import com.zeroo8.quora.dto.topicDTO.CreateTopicRequest;
import com.zeroo8.quora.dto.topicDTO.TopicResponse;
import com.zeroo8.quora.models.Topic;
import com.zeroo8.quora.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final TopicAdapter topicAdapter;

    public TopicResponse create(CreateTopicRequest request) {
        if (topicRepository.existsByName(request.getName())) {
            throw new RuntimeException("Topic with this name already exists");
        }
        Topic topic = topicAdapter.toEntity(request);
        topic = topicRepository.save(topic);
        return topicAdapter.toResponse(topic);
    }

    public List<TopicResponse> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(topicAdapter::toResponse)
                .collect(Collectors.toList());
    }
}
