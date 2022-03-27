CREATE TABLE topic(
    id UUID NOT NULL,
    title VARCHAR(50) NOT NULL,
    message VARCHAR(300) NOT NULL,
    created_at DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    course_id UUID NOT NULL,
    author_id UUID NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(course_id) REFERENCES course(id),
    FOREIGN KEY(author_id) REFERENCES user(id)
);
