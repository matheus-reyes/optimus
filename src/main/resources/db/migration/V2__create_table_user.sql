CREATE TABLE user(
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO user VALUES (random_uuid(), 'Matheus', 'matheus@email.com');
