package com.zeroo8.quora.repositories;

import com.zeroo8.quora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    @Query("SELECT q FROM Question q WHERE (:text IS NULL OR q.title LIKE %:text% OR q.body LIKE %:text%) " +
            "AND (:tag IS NULL OR :tag IN elements(q.topicTags))")
    List<Question> searchQuestions(@Param("text") String text, @Param("tag") String tag);
}