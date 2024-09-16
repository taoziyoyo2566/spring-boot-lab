CREATE SCHEMA IF NOT EXISTS ${schema};

CREATE TABLE ${schema}.users (
                                 id SERIAL PRIMARY KEY,
                                 name VARCHAR(100) NOT NULL,
                                 email VARCHAR(100) NOT NULL
);