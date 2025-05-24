-- User Table
CREATE TABLE user (
    id          BINARY(16) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL, -- Assuming hashed passwords
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  DATETIME NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

-- Question Table
CREATE TABLE question (
    id          BINARY(16) NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT NULL,
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id     BINARY(16) NOT NULL,
    CONSTRAINT pk_question PRIMARY KEY (id),
    CONSTRAINT FK_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id)
);

-- Answer Table
CREATE TABLE answer (
    id          BINARY(16) NOT NULL,
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    question_id BINARY(16) NOT NULL,
    text        LONGTEXT NOT NULL,
    user_id     BINARY(16) NOT NULL,
    CONSTRAINT pk_answer PRIMARY KEY (id),
    CONSTRAINT FK_ANSWER_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id),
    CONSTRAINT FK_ANSWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id)
);

-- Comment Table
CREATE TABLE comment (
    id          BINARY(16) NOT NULL,
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    text        VARCHAR(1000) NOT NULL,
    user_id     BINARY(16) NOT NULL,
    answer_id   BINARY(16) DEFAULT NULL,
    question_id BINARY(16) DEFAULT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id),
    CONSTRAINT FK_COMMENT_ON_USER FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT FK_COMMENT_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answer (id),
    CONSTRAINT FK_COMMENT_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id)
);

-- Vote Table (for upvotes/downvotes)
CREATE TABLE vote (
    id          BINARY(16) NOT NULL,
    user_id     BINARY(16) NOT NULL,
    question_id BINARY(16) DEFAULT NULL,
    answer_id   BINARY(16) DEFAULT NULL,
    value       TINYINT NOT NULL CHECK (value IN (1, -1)), -- 1 for upvote, -1 for downvote
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_vote PRIMARY KEY (id),
    CONSTRAINT FK_VOTE_ON_USER FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT FK_VOTE_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id),
    CONSTRAINT FK_VOTE_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answer (id)
);

-- Tag Table
CREATE TABLE tag (
    id          BINARY(16) NOT NULL,
    name        VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT pk_tag PRIMARY KEY (id)
);

-- Question_Tag Mapping Table
CREATE TABLE question_tag (
    question_id BINARY(16) NOT NULL,
    tag_id      BINARY(16) NOT NULL,
    CONSTRAINT pk_question_tag PRIMARY KEY (question_id, tag_id),
    CONSTRAINT FK_QT_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id),
    CONSTRAINT FK_QT_ON_TAG FOREIGN KEY (tag_id) REFERENCES tag (id)
);