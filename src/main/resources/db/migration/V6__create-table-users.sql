CREATE TABLE users (
    id BIGSERIAL NOT NULL,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);
