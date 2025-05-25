package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.topicDTO.TopicResponse;
import com.zeroo8.quora.dto.topicDTO.CreateTopicRequest;
import com.zeroo8.quora.models.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicAdapter {
    public TopicResponse toResponse(Topic topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }

    public Topic toEntity(CreateTopicRequest request) {
        return Topic.builder()
                .name(request.getName())
                .build();
    }
}