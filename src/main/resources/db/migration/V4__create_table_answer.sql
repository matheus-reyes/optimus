CREATE TABLE answer(
    id UUID NOT NULL,
    message VARCHAR(300) NOT NULL,
    created_at DATETIME NOT NULL,
    topic_id UUID NOT NULL,
    author_id UUID NOT NULL,
    solution int(1) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(topic_id) REFERENCES topic(id),
    FOREIGN KEY(author_id) REFERENCES user(id)
);
