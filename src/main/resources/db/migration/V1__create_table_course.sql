CREATE TABLE course(
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO course VALUES (random_uuid(), 'Kotlin', 'Technology');
