drop table if exists users cascade;

CREATE TABLE users (
                       id INT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255),
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       GENDER VARCHAR(10)
);

