ALTER TABLE question_topic
    DROP FOREIGN KEY FKqvg2x949cnm9imyodw54fmhlw;

ALTER TABLE question_topic
    DROP FOREIGN KEY FKr6lxn6if3ti3x2oik7413pva2;

CREATE TABLE question_tags
(
    question_id BINARY(16)   NOT NULL,
    tag         VARCHAR(255) NULL
);

ALTER TABLE question_tags
    ADD CONSTRAINT fk_question_tags_on_question FOREIGN KEY (question_id) REFERENCES question (id);

DROP TABLE question_topic;
DROP TABLE topic;