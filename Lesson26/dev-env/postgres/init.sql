CREATE TABLE user
(
    login    VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

INSERT INTO users (login, password)
VALUES ('Mikhail', '123');
